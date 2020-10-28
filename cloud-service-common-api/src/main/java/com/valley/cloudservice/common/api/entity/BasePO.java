package com.valley.cloudservice.common.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author libihui
 * @version 1.0 2020/2/20
 * @description：PO基类
 */
@Setter
@Getter
@Accessors(chain = true)
public class BasePO implements Serializable {

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createUserId;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    private String updateUserId;

    /**
     * 审核状态
     */

    /**
     * 审核状态
     */
    @ApiModelProperty("审核状态")
    private String auditState;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 删除标记
     */
    @ApiModelProperty("删除标记")
    private String deleteFlag;

    /**
     * 审核人
     */
    @ApiModelProperty("审核人")
    private String auditUserId;

    /**
     * 审核时间
     */
    @ApiModelProperty("审核时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date auditTime;


    @ApiModelProperty("审核原因")
    private String auditReason;
}
