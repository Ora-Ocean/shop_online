package com.soft2242.shop_online.service;

import com.soft2242.shop_online.common.result.PageResult;
import com.soft2242.shop_online.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft2242.shop_online.query.Query;
import com.soft2242.shop_online.query.RecommendByTabGoodsQuery;
import com.soft2242.shop_online.vo.IndexTabRecommendVO;
import com.soft2242.shop_online.vo.RecommendGoodsVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */
public interface GoodsService extends IService<Goods> {

    IndexTabRecommendVO getTabRecommendGoodsByTabId(RecommendByTabGoodsQuery query);

    PageResult<RecommendGoodsVO> getRecommendGoodsByPage(Query query);

}
