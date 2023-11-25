package com.soft2242.shop_online.mapper;

import com.soft2242.shop_online.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft2242.shop_online.vo.UserOrderGoodsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *

 */
public interface GoodsMapper extends BaseMapper<Goods> {

    List<UserOrderGoodsVO> getGoodsListByOrderId(@Param("id") Integer id);

}
