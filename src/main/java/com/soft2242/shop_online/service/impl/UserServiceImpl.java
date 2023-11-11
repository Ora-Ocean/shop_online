package com.soft2242.shop_online.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
//import com.aliyuncs.utils.LogUtils;
//import com.aliyuncs.utils.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.soft2242.shop_online.common.exception.ServerException;
import com.soft2242.shop_online.common.utils.GeneratorCodeUtils;
import com.soft2242.shop_online.common.utils.JWTUtils;
import com.soft2242.shop_online.convert.UserConvert;
import com.soft2242.shop_online.entity.User;
import com.soft2242.shop_online.mapper.UserMapper;
import com.soft2242.shop_online.query.UserLoginQuery;
import com.soft2242.shop_online.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft2242.shop_online.vo.LoginResultVO;
import com.soft2242.shop_online.vo.UserTokenVO;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.soft2242.shop_online.constant.APIConstant.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public LoginResultVO login(UserLoginQuery query) {
        //  1、获取openId
        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=" + APP_ID +
                "&secret=" + APP_SECRET +
                "&js_code=" + query.getCode() +
                "&grant_type=authorization_code";

        RestTemplate restTemplate = new RestTemplate();
        String openIdResult = restTemplate.getForObject(url,String.class);
        if (StringUtils.contains(openIdResult,WX_ERR_CODE)){
            throw new ServerException("openId获取失败"+openIdResult);
        }
        //2.解析返回的数据
        JSONObject jsonObject = JSON.parseObject(openIdResult);
        String openId = jsonObject.getString(WX_OPENID);
        User user = baseMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getOpenId,openId));
        //3.判断用户是否存在
        if (user == null){
            user = new User();
            String account = "用户" + GeneratorCodeUtils.generateCode();
            user.setAvatar(DEFAULT_AVATAR);
            user.setAccount(account);
            user.setNickname(account);
            user.setOpenId(openId);
            user.setMobile("''");
            baseMapper.insert(user);
        }
        LoginResultVO userV0 = UserConvert.INSTANCE.convertToLoginResultVO(user);
        //4.生成token，存入redis并设置过期时间
        UserTokenVO tokenVO = new UserTokenVO(userV0.getId());
        String token = JWTUtils.generateToken(JWT_SECRET,tokenVO.toMap());
        return userV0;
    }
}