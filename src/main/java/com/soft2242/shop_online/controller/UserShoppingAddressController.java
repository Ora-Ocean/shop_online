package com.soft2242.shop_online.controller;

import com.soft2242.shop_online.common.exception.ServerException;
import com.soft2242.shop_online.common.result.Result;
import com.soft2242.shop_online.service.UserShoppingAddressService;
import com.soft2242.shop_online.vo.AddressVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.soft2242.shop_online.common.utils.ObtainUserIdUtils.getUserId;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */
@Tag(name = "地址管理")
@RestController
@RequestMapping("member")
@AllArgsConstructor
public class UserShoppingAddressController {

    private final UserShoppingAddressService userShoppingAddressService;
    @Resource
    private HttpServletRequest request;

    @Operation(summary = "添加收货地址")
    @PostMapping("address")
    public Result<Integer> saveAddress(@RequestBody @Validated AddressVO addressVO) {
        Integer userId = getUserId(request);
        addressVO.setUserId(userId);
        Integer addressId = userShoppingAddressService.saveShoppingAddress(addressVO);
        return Result.ok(addressId);
    }

    @Operation(summary = "修改收货地址")
    @PutMapping("address")
    public Result<Integer> editAddress(@RequestBody @Validated AddressVO addressVO) {
        if (addressVO.getId() == null) {
            throw new ServerException("请求参数不能为空");
        }
        addressVO.setUserId(getUserId(request));
        Integer addressId = userShoppingAddressService.editShoppingAddress(addressVO);
        return Result.ok(addressId);
    }

    @Operation(summary = "收货地址列表")
    @GetMapping("address")
    public Result<List<AddressVO>> getList(HttpServletRequest request) {
        Integer userId = getUserId(request);
        List<AddressVO> list = userShoppingAddressService.getList(userId);
        return Result.ok(list);

    }

    @Operation(summary = "收货地址详情")
    @GetMapping("address/detail")
    public Result<AddressVO> getAddressDetail(@RequestParam Integer id, HttpServletRequest request) {
        if (id == null) {
            throw new ServerException("请求参数不能为空");
        }
        AddressVO addressInfo = userShoppingAddressService.getAddressInfo(id);
        return Result.ok(addressInfo);
    }

    @Operation(summary = "删除收货地址")
    @DeleteMapping("address")
    public Result removeAddress(@RequestParam Integer id, HttpServletRequest request) {
        if (id == null) {
            throw new ServerException("请求参数不能为空");
        }
        userShoppingAddressService.removeShoppingAddress(id);
        return Result.ok();
    }


}
