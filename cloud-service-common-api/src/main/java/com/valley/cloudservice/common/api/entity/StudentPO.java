package com.valley.cloudservice.common.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.util.Date;

@Data
@Accessors(chain = true)
@ApiModel("")
public class StudentPO extends BasePO{

    @ApiModelProperty("")
    private String studentName;

    @ApiModelProperty("")
    private String sex;

    @ApiModelProperty("")
    private String idCard;

}