package com.soft2242.shop_online.controller;

import com.soft2242.shop_online.common.result.PageResult;
import com.soft2242.shop_online.common.result.Result;
import com.soft2242.shop_online.query.Query;
import com.soft2242.shop_online.query.RecommendByTabGoodsQuery;
import com.soft2242.shop_online.service.GoodsService;
import com.soft2242.shop_online.vo.GoodsVO;
import com.soft2242.shop_online.vo.IndexTabRecommendVO;
import com.soft2242.shop_online.vo.RecommendGoodsVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */
@RestController
@Tag(name = "商品模块")
@AllArgsConstructor
@RequestMapping("goods")
public class GoodsController {
    private final GoodsService goodsService;

    @Operation(summary = "首页-热门推荐商品列表")
    @PostMapping("preference")
    public Result<IndexTabRecommendVO> getTabRecommendGoodsByTabId(@RequestBody @Validated RecommendByTabGoodsQuery query) {
        IndexTabRecommendVO result = goodsService.getTabRecommendGoodsByTabId(query);
        return Result.ok(result);
    }

    @Operation(summary = "首页-猜你喜欢")
    @PostMapping("guessLike")
    public Result<PageResult<RecommendGoodsVO>> getRecommendGoodsByPage(@RequestBody @Validated Query query) {
        PageResult<RecommendGoodsVO> result = goodsService.getRecommendGoodsByPage(query);
        return Result.ok(result);
    }
    @Operation(summary = "首页-商品详情")
    @GetMapping("detail")
    public Result<GoodsVO> getGoodsDetail(@RequestParam Integer id) {
        GoodsVO goodsDetail = goodsService.getGoodsDetail(id);
        return Result.ok(goodsDetail);
    }
}