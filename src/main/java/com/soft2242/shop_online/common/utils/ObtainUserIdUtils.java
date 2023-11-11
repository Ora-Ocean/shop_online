package com.soft2242.shop_online.common.utils;

import com.soft2242.shop_online.common.exception.ServerException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;

public class ObtainUserIdUtils {

    public static Integer getUserId(HttpServletRequest request) {
        if (request.getAttribute("userId") == null) {
            throw new ServerException("用户不存在");
        }
        Integer userId = Integer.parseInt(request.getAttribute("userId").toString());
        if (userId == null) {
            throw new ServerException("用户不存在");
        }
        return userId;
    }

}