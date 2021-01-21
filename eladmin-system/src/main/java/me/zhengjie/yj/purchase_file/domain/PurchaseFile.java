/*
*  Copyright 2019-2020 Zheng Jie
*
*  Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*  http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*/
package me.zhengjie.yj.purchase_file.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author 杨娇
* @date 2021-01-21
**/
@Entity
@Data
@Table(name="purchase_file")
public class PurchaseFile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(value = "id")
    private Integer id;

    @Column(name = "FIRST_KIND_ID")
    @ApiModelProperty(value = "firstKindId")
    private String firstKindId;

    @Column(name = "FIRST_KIND_NAME",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "I类产品")
    private String firstKindName;

    @Column(name = "SECOND_KIND_ID")
    @ApiModelProperty(value = "secondKindId")
    private String secondKindId;

    @Column(name = "SECOND_KIND_NAME",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "II类产品")
    private String secondKindName;

    @Column(name = "THIRD_KIND_ID")
    @ApiModelProperty(value = "thirdKindId")
    private String thirdKindId;

    @Column(name = "THIRD_KIND_NAME",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "III类产品")
    private String thirdKindName;

    @Column(name = "PROVIDER_ID",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "供应商编号")
    private String providerId;

    @Column(name = "PROVIDER_NAME",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "供应商名称")
    private String providerName;

    @Column(name = "PROVIDER_NICK")
    @ApiModelProperty(value = "供应商曾用名")
    private String providerNick;

    @Column(name = "PROVIDER_ADDRESS")
    @ApiModelProperty(value = "地址")
    private String providerAddress;

    @Column(name = "PROVIDER_CLASS",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "优质级别")
    private String providerClass;

    @Column(name = "type")
    @ApiModelProperty(value = "type")
    private String type;

    @Column(name = "PROVIDER_BANK")
    @ApiModelProperty(value = "开户银行")
    private String providerBank;

    @Column(name = "PROVIDER_ACCOUNT")
    @ApiModelProperty(value = "银行账号")
    private String providerAccount;

    @Column(name = "PROVIDER_WEB")
    @ApiModelProperty(value = "网址")
    private String providerWeb;

    @Column(name = "PROVIDER_TEL1")
    @ApiModelProperty(value = "电话")
    private String providerTel1;

    @Column(name = "PROVIDER_TEL2")
    @ApiModelProperty(value = "providerTel2")
    private String providerTel2;

    @Column(name = "PROVIDER_EMAIL")
    @ApiModelProperty(value = "EMAIL")
    private String providerEmail;

    @Column(name = "PROVIDER_FAX")
    @ApiModelProperty(value = "providerFax")
    private String providerFax;

    @Column(name = "PROVIDER_POSTCODE")
    @ApiModelProperty(value = "邮政编码")
    private String providerPostcode;

    @Column(name = "CONTACT_PERSON1")
    @ApiModelProperty(value = "第一联系人")
    private String contactPerson1;

    @Column(name = "CONTACT_PERSON1_DEPARTMENT")
    @ApiModelProperty(value = "部门")
    private String contactPerson1Department;

    @Column(name = "CONTACT_PERSON1_DUTY")
    @ApiModelProperty(value = "职务")
    private String contactPerson1Duty;

    @Column(name = "CONTACT_PERSON1_SEX")
    @ApiModelProperty(value = "性别")
    private String contactPerson1Sex;

    @Column(name = "CONTACT_PERSON1_OFFICE_TEL")
    @ApiModelProperty(value = "办公电话")
    private String contactPerson1OfficeTel;

    @Column(name = "CONTACT_PERSON1_HOME_TEL")
    @ApiModelProperty(value = "家庭电话")
    private String contactPerson1HomeTel;

    @Column(name = "CONTACT_PERSON1_MOBILE")
    @ApiModelProperty(value = "手机")
    private String contactPerson1Mobile;

    @Column(name = "CONTACT_PERSON1_FAX")
    @ApiModelProperty(value = "contactPerson1Fax")
    private String contactPerson1Fax;

    @Column(name = "CONTACT_PERSON1_EMAIL")
    @ApiModelProperty(value = "EMAIL")
    private String contactPerson1Email;

    @Column(name = "CONTACT_PERSON1_FAVORITE")
    @ApiModelProperty(value = "contactPerson1Favorite")
    private String contactPerson1Favorite;

    @Column(name = "CONTACT_PERSON2")
    @ApiModelProperty(value = "第二联系人")
    private String contactPerson2;

    @Column(name = "CONTACT_PERSON2_DEPARTMENT")
    @ApiModelProperty(value = "部门")
    private String contactPerson2Department;

    @Column(name = "CONTACT_PERSON2_DUTY")
    @ApiModelProperty(value = "职务")
    private String contactPerson2Duty;

    @Column(name = "CONTACT_PERSON2_SEX")
    @ApiModelProperty(value = "性别")
    private String contactPerson2Sex;

    @Column(name = "CONTACT_PERSON2_OFFICE_TEL")
    @ApiModelProperty(value = "办公电话")
    private String contactPerson2OfficeTel;

    @Column(name = "CONTACT_PERSON2_HOME_TEL")
    @ApiModelProperty(value = "家庭电话")
    private String contactPerson2HomeTel;

    @Column(name = "CONTACT_PERSON2_MOBILE")
    @ApiModelProperty(value = "手机")
    private String contactPerson2Mobile;

    @Column(name = "CONTACT_PERSON2_FAX")
    @ApiModelProperty(value = "contactPerson2Fax")
    private String contactPerson2Fax;

    @Column(name = "CONTACT_PERSON2_EMAIL")
    @ApiModelProperty(value = "EMAIL")
    private String contactPerson2Email;

    @Column(name = "CONTACT_PERSON2_FAVORITE")
    @ApiModelProperty(value = "contactPerson2Favorite")
    private String contactPerson2Favorite;

    @Column(name = "INVOICE_INFO")
    @ApiModelProperty(value = "开票信息")
    private String invoiceInfo;

    @Column(name = "DEMAND_PRODUCTS")
    @ApiModelProperty(value = "demandProducts")
    private String demandProducts;

    @Column(name = "RECOMMEND_PRODUCTS")
    @ApiModelProperty(value = "推荐供应产品集合")
    private String recommendProducts;

    @Column(name = "CHECK_TAG")
    @ApiModelProperty(value = "复核标志")
    private Integer checkTag;

    @Column(name = "CONTACT_AMOUNT")
    @ApiModelProperty(value = "contactAmount")
    private Integer contactAmount;

    @Column(name = "ACHIEVEMENT_SUM")
    @ApiModelProperty(value = "achievementSum")
    private Double achievementSum;

    @Column(name = "ATTACHMENT_NAME")
    @ApiModelProperty(value = "attachmentName")
    private String attachmentName;

    @Column(name = "TRADE_AMOUNT")
    @ApiModelProperty(value = "tradeAmount")
    private Integer tradeAmount;

    @Column(name = "RETURN_SUM")
    @ApiModelProperty(value = "returnSum")
    private Double returnSum;

    @Column(name = "RETURN_AMOUNT")
    @ApiModelProperty(value = "returnAmount")
    private Integer returnAmount;

    @Column(name = "GATHER_PERIOD_SUM")
    @ApiModelProperty(value = "gatherPeriodSum")
    private Integer gatherPeriodSum;

    @Column(name = "GATHER_PERIOD_AVERAGE")
    @ApiModelProperty(value = "gatherPeriodAverage")
    private Double gatherPeriodAverage;

    @Column(name = "FILE_CHANGE_AMOUNT")
    @ApiModelProperty(value = "fileChangeAmount")
    private Integer fileChangeAmount;

    @Column(name = "GATHER_PERIOD_LIMIT")
    @ApiModelProperty(value = "gatherPeriodLimit")
    private Integer gatherPeriodLimit;

    @Column(name = "GATHER_SUM_LIMIT")
    @ApiModelProperty(value = "gatherSumLimit")
    private Double gatherSumLimit;

    @Column(name = "CONTACT_PERIOD_LIMIT")
    @ApiModelProperty(value = "contactPeriodLimit")
    private Integer contactPeriodLimit;

    @Column(name = "USED_PROVIDER_NAME")
    @ApiModelProperty(value = "usedProviderName")
    private String usedProviderName;

    @Column(name = "REGISTER")
    @ApiModelProperty(value = "登记人")
    private String register;

    @Column(name = "CHECKER")
    @ApiModelProperty(value = "复核人")
    private String checker;

    @Column(name = "CHANGER")
    @ApiModelProperty(value = "更改人")
    private String changer;

    @Column(name = "REGISTER_ID")
    @ApiModelProperty(value = "登记人iD")
    private String registerId;

    @Column(name = "CHECKER_ID")
    @ApiModelProperty(value = "复核人ID")
    private String checkerId;

    @Column(name = "CHANGER_ID")
    @ApiModelProperty(value = "更改人id")
    private String changerId;

    @Column(name = "REGISTER_TIME")
    @ApiModelProperty(value = "登记时间")
    private Timestamp registerTime;

    @Column(name = "CHECK_TIME")
    @ApiModelProperty(value = "复核时间")
    private Timestamp checkTime;

    @Column(name = "CHANGE_TIME")
    @ApiModelProperty(value = "更改时间")
    private Timestamp changeTime;

    @Column(name = "LATELY_CHANGE_TIME")
    @ApiModelProperty(value = "latelyChangeTime")
    private Timestamp latelyChangeTime;

    @Column(name = "LATELY_TRADE_TIME")
    @ApiModelProperty(value = "latelyTradeTime")
    private Timestamp latelyTradeTime;

    @Column(name = "LATELY_CONTACT_TIME")
    @ApiModelProperty(value = "latelyContactTime")
    private Timestamp latelyContactTime;

    @Column(name = "DELETE_TIME")
    @ApiModelProperty(value = "deleteTime")
    private Timestamp deleteTime;

    @Column(name = "RECOVERY_TIME")
    @ApiModelProperty(value = "recoveryTime")
    private Timestamp recoveryTime;

    @Column(name = "PURCHASER")
    @ApiModelProperty(value = "purchaser")
    private String purchaser;

    @Column(name = "PURCHASER_ID")
    @ApiModelProperty(value = "purchaserId")
    private String purchaserId;

    @Column(name = "MODIFY_TAG")
    @ApiModelProperty(value = "modifyTag")
    private Integer modifyTag;

    @Column(name = "EXCEL_TAG")
    @ApiModelProperty(value = "excelTag")
    private Integer excelTag;

    @Column(name = "REMIND_CONTACT_TAG")
    @ApiModelProperty(value = "remindContactTag")
    private Integer remindContactTag;

    @Column(name = "REMIND_GATHER_TAG")
    @ApiModelProperty(value = "remindGatherTag")
    private Integer remindGatherTag;

    @Column(name = "REMIND_RETURN_TAG")
    @ApiModelProperty(value = "remindReturnTag")
    private Integer remindReturnTag;

    @Column(name = "CREDIT_YES_OR_NOT_TAG")
    @ApiModelProperty(value = "creditYesOrNotTag")
    private Integer creditYesOrNotTag;

    @Column(name = "PURCHASECREDIT_COST_PRICE_SUM")
    @ApiModelProperty(value = "purchasecreditCostPriceSum")
    private Double purchasecreditCostPriceSum;

    @Column(name = "opinion")
    @ApiModelProperty(value = "opinion")
    private String opinion;

    @Column(name = "promotion")
    @ApiModelProperty(value = "promotion")
    private String promotion;

    public void copy(PurchaseFile source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}