package com.soft2242.shop_online.mapper;

import com.soft2242.shop_online.entity.UserShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft2242.shop_online.vo.CartGoodsVO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */
public interface UserShoppingCartMapper extends BaseMapper<UserShoppingCart> {
    List<CartGoodsVO> getCartGoodsInfo(@Param("id")Integer id);


}
