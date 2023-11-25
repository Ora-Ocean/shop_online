package com.soft2242.shop_online.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.shop_online.entity.UserOrder;
import com.soft2242.shop_online.query.OrderPreQuery;
import com.soft2242.shop_online.vo.OrderDetailVO;
import com.soft2242.shop_online.vo.SubmitOrderVO;
import com.soft2242.shop_online.vo.UserOrderVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */
public interface UserOrderService extends IService<UserOrder> {
    Integer addGoodsOrder(UserOrderVO orderVO);
    /**
     * 订单详情
     *
     * @param id
     * @return
     */
    OrderDetailVO getOrderDetail(Integer id);
    /**
     * 填写订单 - 获取预付订单
     *
     * @param userId
     * @return
     */
    SubmitOrderVO getPreOrderDetail(Integer userId);
    /**
     * 填写订单 - 获取立即购买订单
     *
     * @param query
     * @return
     */
    SubmitOrderVO getPreNowOrderDetail(OrderPreQuery query);
    /**
     * 填写订单 - 获取再次购买订单
     *
     * @param id
     * @return
     */
    SubmitOrderVO getRepurchaseOrderDetail(Integer id);
}
