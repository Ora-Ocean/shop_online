package com.soft2242.shop_online.service;

import com.soft2242.shop_online.entity.UserShoppingCart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.shop_online.query.CartQuery;
import com.soft2242.shop_online.vo.CartGoodsVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */

//添加购物车
public interface UserShoppingCartService extends IService<UserShoppingCart> {
    CartGoodsVO addShopCart (CartQuery query);

}
