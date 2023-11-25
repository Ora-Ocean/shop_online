package com.soft2242.shop_online.mapper;

import com.soft2242.shop_online.entity.UserShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft2242.shop_online.vo.CartGoodsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 *
 */
public interface UserShoppingCartMapper extends BaseMapper<UserShoppingCart> {
    /**
     * 获取购物车信息
     *
     * @param id
     * @return list
     */
    List<CartGoodsVO> getCartGoodsInfo(@Param("id") Integer id);
}
