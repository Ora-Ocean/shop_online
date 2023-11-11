package com.soft2242.shop_online.controller;

import com.soft2242.shop_online.common.result.Result;
import com.soft2242.shop_online.entity.Category;
import com.soft2242.shop_online.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */
@RestController
@Tag(name = "分类管理")
@AllArgsConstructor
@RequestMapping("/shop_online/category")
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping("index")
    @Operation(summary = "首页-商品分类")
    public Result<List<Category>> getIndexCategoryList() {
        List<Category> list = categoryService.getIndexCategoryList();
        return Result.ok(list);
    }
}