package com.soft2242.shop_online.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft2242.shop_online.common.exception.ServerException;
import com.soft2242.shop_online.convert.AddressConvert;
import com.soft2242.shop_online.entity.UserShoppingAddress;
import com.soft2242.shop_online.enums.AddressDefaultEnum;
import com.soft2242.shop_online.mapper.UserShoppingAddressMapper;
import com.soft2242.shop_online.service.UserShoppingAddressService;
import com.soft2242.shop_online.vo.AddressVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */
@Service
public class UserShoppingAddressServiceImpl extends ServiceImpl<UserShoppingAddressMapper, UserShoppingAddress> implements UserShoppingAddressService {

    @Override
    public Integer saveShoppingAddress(AddressVO addressVO) {
        // 接收数据转换为实体类
        UserShoppingAddress convert = AddressConvert.INSTANCE.convert(addressVO);
        // 是否需要设为默认地址
        if (addressVO.getIsDefault().equals(AddressDefaultEnum.DEFAULT_ADDRESS.getValue())) {
            // 根据用户查询是否存在默认地址
            LambdaQueryWrapper<UserShoppingAddress> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(UserShoppingAddress::getIsDefault, AddressDefaultEnum.DEFAULT_ADDRESS.getValue()).eq(UserShoppingAddress::getUserId, addressVO.getUserId());
            List<UserShoppingAddress> list = baseMapper.selectList(wrapper);
            // 如果存在，返回500
            if (list.size() > 0) {
                throw new ServerException("已存在默认地址，请勿重复操作");
            }
        }
        save(convert); // 实体对象插入
        return convert.getId();
    }

    @Override
    public Integer editShoppingAddress(AddressVO addressVO) {
        // 判断地址是否存在
        UserShoppingAddress userShoppingAddress = baseMapper.selectById(addressVO.getId());
        if (userShoppingAddress == null) {
            throw new ServerException("地址不存在");
        }
        // 查询该用户是否存在默认地址
        if (addressVO.getIsDefault().equals(AddressDefaultEnum.DEFAULT_ADDRESS.getValue())) {
            LambdaQueryWrapper<UserShoppingAddress> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(UserShoppingAddress::getIsDefault, AddressDefaultEnum.DEFAULT_ADDRESS.getValue()).eq(UserShoppingAddress::getUserId, addressVO.getUserId());
            UserShoppingAddress address = baseMapper.selectOne(wrapper);
            // 如果存在 更新之前默认地址
            if (address != null) {
                address.setIsDefault(AddressDefaultEnum.NOT_DEFAULT_ADDRESS.getValue());
                updateById(address);
            }
        }
        UserShoppingAddress address = AddressConvert.INSTANCE.convert(addressVO);
        updateById(address);
        return address.getId();
    }

    @Override
    public List<AddressVO> getList(Integer userId) {
        LambdaQueryWrapper<UserShoppingAddress> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserShoppingAddress::getUserId, userId);
//        根据是否为默认地址和创建时间倒序排列
        wrapper.orderByDesc(UserShoppingAddress::getIsDefault);
        wrapper.orderByDesc(UserShoppingAddress::getCreateTime);
        List<UserShoppingAddress> list = baseMapper.selectList(wrapper);
        List<AddressVO> results = AddressConvert.INSTANCE.convertToAddressVOList(list);
        return results;
    }

    @Override
    public AddressVO getAddressInfo(Integer id) {
        UserShoppingAddress userShoppingAddress = baseMapper.selectById(id);
        if (userShoppingAddress == null) {
            throw new ServerException("地址不存在");
        }
        AddressVO addressVO = AddressConvert.INSTANCE.convertToAddressVO(userShoppingAddress);
        return addressVO;
    }

    @Override
    public void removeShoppingAddress(Integer id) {
        removeById(id);
    }
}