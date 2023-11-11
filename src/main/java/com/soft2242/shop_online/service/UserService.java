package com.soft2242.shop_online.service;

import com.soft2242.shop_online.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.shop_online.query.UserLoginQuery;
import com.soft2242.shop_online.vo.LoginResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */
public interface UserService extends IService<User> {
    LoginResultVO login(UserLoginQuery query);

}
