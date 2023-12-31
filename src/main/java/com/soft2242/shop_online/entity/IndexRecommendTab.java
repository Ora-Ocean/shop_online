package com.soft2242.shop_online.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ycshang
 * @since 2023-11-08
 */
@Getter
@Setter
@TableName("t_index_recommend_tab")
@ApiModel(value = "IndexRecommendTab对象", description = "")
public class IndexRecommendTab {

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("推荐标签id")
    @TableField("recommend_id")
    private Integer recommendId;

    @ApiModelProperty("tab名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("逻辑删除(0-未删除，1-已删除)")
    @TableField("delete_flag")
    @TableLogic
    @JsonIgnore
    private Integer deleteFlag;

    @ApiModelProperty("创建时间")
    @JsonIgnore
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @JsonIgnore
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
