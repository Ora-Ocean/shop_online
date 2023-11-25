package com.soft2242.shop_online.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.shop_online.entity.UserShoppingAddress;
import com.soft2242.shop_online.vo.AddressVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */
public interface UserShoppingAddressService extends IService<UserShoppingAddress> {

        /**
         * 添加收货地址
         *
         * @param addressVO
         * @return Integer
         */
        Integer saveShoppingAddress(AddressVO addressVO);

        /**
         * 修改收货地址
         *
         * @param addressVO
         * @return Integer
         */
        Integer editShoppingAddress(AddressVO addressVO);

        /**
         * 获取收货地址
         *
         * @param userId
         * @return List
         */
        List<AddressVO> getList(Integer userId);

        /**
         * 收货地址详情
         *
         * @param id
         * @return AddressVO
         */
        AddressVO getAddressInfo(Integer id);

        /**
         * 删除收货地址
         *
         * @param id
         * @param
         * @return Integer
         */
        void removeShoppingAddress(Integer id);
}
