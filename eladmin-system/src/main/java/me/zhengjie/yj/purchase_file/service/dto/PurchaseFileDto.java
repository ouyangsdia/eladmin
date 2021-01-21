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
package me.zhengjie.yj.purchase_file.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author 杨娇
* @date 2021-01-21
**/
@Data
public class PurchaseFileDto implements Serializable {

    private Integer id;

    private String firstKindId;

    /** I类产品 */
    private String firstKindName;

    private String secondKindId;

    /** II类产品 */
    private String secondKindName;

    private String thirdKindId;

    /** III类产品 */
    private String thirdKindName;

    /** 供应商编号 */
    private String providerId;

    /** 供应商名称 */
    private String providerName;

    /** 供应商曾用名 */
    private String providerNick;

    /** 地址 */
    private String providerAddress;

    /** 优质级别 */
    private String providerClass;

    private String type;

    /** 开户银行 */
    private String providerBank;

    /** 银行账号 */
    private String providerAccount;

    /** 网址 */
    private String providerWeb;

    /** 电话 */
    private String providerTel1;

    private String providerTel2;

    /** EMAIL */
    private String providerEmail;

    private String providerFax;

    /** 邮政编码 */
    private String providerPostcode;

    /** 第一联系人 */
    private String contactPerson1;

    /** 部门 */
    private String contactPerson1Department;

    /** 职务 */
    private String contactPerson1Duty;

    /** 性别 */
    private String contactPerson1Sex;

    /** 办公电话 */
    private String contactPerson1OfficeTel;

    /** 家庭电话 */
    private String contactPerson1HomeTel;

    /** 手机 */
    private String contactPerson1Mobile;

    private String contactPerson1Fax;

    /** EMAIL */
    private String contactPerson1Email;

    private String contactPerson1Favorite;

    /** 第二联系人 */
    private String contactPerson2;

    /** 部门 */
    private String contactPerson2Department;

    /** 职务 */
    private String contactPerson2Duty;

    /** 性别 */
    private String contactPerson2Sex;

    /** 办公电话 */
    private String contactPerson2OfficeTel;

    /** 家庭电话 */
    private String contactPerson2HomeTel;

    /** 手机 */
    private String contactPerson2Mobile;

    private String contactPerson2Fax;

    /** EMAIL */
    private String contactPerson2Email;

    private String contactPerson2Favorite;

    /** 开票信息 */
    private String invoiceInfo;

    private String demandProducts;

    /** 推荐供应产品集合 */
    private String recommendProducts;

    /** 复核标志 */
    private Integer checkTag;

    private Integer contactAmount;

    private Double achievementSum;

    private String attachmentName;

    private Integer tradeAmount;

    private Double returnSum;

    private Integer returnAmount;

    private Integer gatherPeriodSum;

    private Double gatherPeriodAverage;

    private Integer fileChangeAmount;

    private Integer gatherPeriodLimit;

    private Double gatherSumLimit;

    private Integer contactPeriodLimit;

    private String usedProviderName;

    /** 登记人 */
    private String register;

    /** 复核人 */
    private String checker;

    /** 更改人 */
    private String changer;

    /** 登记人iD */
    private String registerId;

    /** 复核人ID */
    private String checkerId;

    /** 更改人id */
    private String changerId;

    /** 登记时间 */
    private Timestamp registerTime;

    /** 复核时间 */
    private Timestamp checkTime;

    /** 更改时间 */
    private Timestamp changeTime;

    private Timestamp latelyChangeTime;

    private Timestamp latelyTradeTime;

    private Timestamp latelyContactTime;

    private Timestamp deleteTime;

    private Timestamp recoveryTime;

    private String purchaser;

    private String purchaserId;

    private Integer modifyTag;

    private Integer excelTag;

    private Integer remindContactTag;

    private Integer remindGatherTag;

    private Integer remindReturnTag;

    private Integer creditYesOrNotTag;

    private Double purchasecreditCostPriceSum;

    private String opinion;

    private String promotion;
}