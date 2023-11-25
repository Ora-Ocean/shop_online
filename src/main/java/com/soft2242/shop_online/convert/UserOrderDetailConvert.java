package com.soft2242.shop_online.convert;

import com.soft2242.shop_online.entity.UserOrder;
import com.soft2242.shop_online.vo.OrderDetailVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserOrderDetailConvert {

    UserOrderDetailConvert INSTANCE = Mappers.getMapper(UserOrderDetailConvert.class);

    OrderDetailVO convertToDetailVO(UserOrder userOrder);

    OrderDetailVO convertToOrderDetailVO(UserOrder userOrder);


}
