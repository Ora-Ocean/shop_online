package com.soft2242.shop_online.service;

import com.soft2242.shop_online.entity.UserShippingAddress;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.shop_online.vo.AddressVO;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */
public interface UserShippingAddressService extends IService<UserShippingAddress> {
    Integer saveShippingAddress(AddressVO addressVO);
    Integer editShippingAddress(AddressVO addressVO);
    List<AddressVO> getAddressList(Integer userId);
    AddressVO getAddress(Integer id);
    void deleteAddress(Integer id);
    

}
