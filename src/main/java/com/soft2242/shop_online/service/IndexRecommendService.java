package com.soft2242.shop_online.service;

import com.soft2242.shop_online.entity.IndexRecommend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.shop_online.vo.IndexRecommendVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */
public interface IndexRecommendService extends IService<IndexRecommend> {
    List<IndexRecommendVO> getList();



}
