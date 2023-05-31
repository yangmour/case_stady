package com.atguigu.syt.vo.cmn;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author: yf
 * @Create: 2023/05/31 -15:04
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "地区")
@TableName("region")
public class RegionVo {

    @ApiModelProperty(value = "id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "地区名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "地区编码")
    @TableField("code")
    private String code;

    @ApiModelProperty(value = "地区级别：1-省、自治区、直辖市 2-地级市、地区、自治州、盟 3-市辖区、县级市、县")
    @TableField("level")
    private Integer level;

    @ApiModelProperty(value = "是否包含子节点")
    @TableField(exist = false)//说明数据库的表中没有此列(业务扩展字段)
    private boolean hasChildren;
}