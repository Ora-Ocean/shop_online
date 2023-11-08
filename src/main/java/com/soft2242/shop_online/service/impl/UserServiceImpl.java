package com.soft2242.shop_online.service.impl;

import com.soft2242.shop_online.entity.User;
import com.soft2242.shop_online.mapper.UserMapper;
import com.soft2242.shop_online.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
