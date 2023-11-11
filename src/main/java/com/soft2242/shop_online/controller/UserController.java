package com.soft2242.shop_online.controller;

import com.soft2242.shop_online.common.result.Result;
import com.soft2242.shop_online.query.UserLoginQuery;
import com.soft2242.shop_online.service.UserService;
import com.soft2242.shop_online.service.impl.UserServiceImpl;
import com.soft2242.shop_online.vo.LoginResultVO;
import io.swagger.annotations.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */
@RestController
@RequestMapping("user")
@AllArgsConstructor
//@Tag(name = "用户模块")


public class UserController {
    private final UserService userService;
    @Operation(summary = "微信登录")
    @PostMapping("login/wxMin")
    public Result<LoginResultVO> wxLogin(@RequestBody @Validated UserLoginQuery query) {
        LoginResultVO userVO = userService.login(query);
        return Result.ok(userVO);
    }
}


