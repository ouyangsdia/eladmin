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
package me.zhengjie.yj.purchase_file.service.impl;

import lombok.RequiredArgsConstructor;
import me.zhengjie.utils.FileUtil;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.yj.purchase_file.domain.PurchaseFile;
import me.zhengjie.yj.purchase_file.repository.PurchaseFileRepository;
import me.zhengjie.yj.purchase_file.service.PurchaseFileService;
import me.zhengjie.yj.purchase_file.service.dto.PurchaseFileDto;
import me.zhengjie.yj.purchase_file.service.dto.PurchaseFileQueryCriteria;
import me.zhengjie.yj.purchase_file.service.mapstruct.PurchaseFileMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
* @website https://el-admin.vip
* @description 服务实现
* @author 杨娇
* @date 2021-01-21
**/
@Service
@RequiredArgsConstructor
public class PurchaseFileServiceImpl implements PurchaseFileService {

    private final PurchaseFileRepository purchaseFileRepository;
    private final PurchaseFileMapper purchaseFileMapper;

    @Override
    public Map<String,Object> queryAll(PurchaseFileQueryCriteria criteria, Pageable pageable){
        System.out.println("___________________________________");

        Page<PurchaseFile> page = purchaseFileRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(purchaseFileMapper::toDto));
    }

    @Override
    public List<PurchaseFileDto> queryAll(PurchaseFileQueryCriteria criteria){
        return purchaseFileMapper.toDto(purchaseFileRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public PurchaseFileDto findById(Integer id) {
        PurchaseFile purchaseFile = purchaseFileRepository.findById(id).orElseGet(PurchaseFile::new);
        ValidationUtil.isNull(purchaseFile.getId(),"PurchaseFile","id",id);
        return purchaseFileMapper.toDto(purchaseFile);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PurchaseFileDto create(PurchaseFile resources) {
        return purchaseFileMapper.toDto(purchaseFileRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PurchaseFile resources) {
        PurchaseFile purchaseFile = purchaseFileRepository.findById(resources.getId()).orElseGet(PurchaseFile::new);
        ValidationUtil.isNull( purchaseFile.getId(),"PurchaseFile","id",resources.getId());
        purchaseFile.copy(resources);
        purchaseFileRepository.save(purchaseFile);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer id : ids) {
            purchaseFileRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<PurchaseFileDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (PurchaseFileDto purchaseFile : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put(" firstKindId",  purchaseFile.getFirstKindId());
            map.put("I类产品", purchaseFile.getFirstKindName());
            map.put(" secondKindId",  purchaseFile.getSecondKindId());
            map.put("II类产品", purchaseFile.getSecondKindName());
            map.put(" thirdKindId",  purchaseFile.getThirdKindId());
            map.put("III类产品", purchaseFile.getThirdKindName());
            map.put("供应商编号", purchaseFile.getProviderId());
            map.put("供应商名称", purchaseFile.getProviderName());
            map.put("供应商曾用名", purchaseFile.getProviderNick());
            map.put("地址", purchaseFile.getProviderAddress());
            map.put("优质级别", purchaseFile.getProviderClass());
            map.put(" type",  purchaseFile.getType());
            map.put("开户银行", purchaseFile.getProviderBank());
            map.put("银行账号", purchaseFile.getProviderAccount());
            map.put("网址", purchaseFile.getProviderWeb());
            map.put("电话", purchaseFile.getProviderTel1());
            map.put(" providerTel2",  purchaseFile.getProviderTel2());
            map.put("EMAIL", purchaseFile.getProviderEmail());
            map.put(" providerFax",  purchaseFile.getProviderFax());
            map.put("邮政编码", purchaseFile.getProviderPostcode());
            map.put("第一联系人", purchaseFile.getContactPerson1());
            map.put("部门", purchaseFile.getContactPerson1Department());
            map.put("职务", purchaseFile.getContactPerson1Duty());
            map.put("性别", purchaseFile.getContactPerson1Sex());
            map.put("办公电话", purchaseFile.getContactPerson1OfficeTel());
            map.put("家庭电话", purchaseFile.getContactPerson1HomeTel());
            map.put("手机", purchaseFile.getContactPerson1Mobile());
            map.put(" contactPerson1Fax",  purchaseFile.getContactPerson1Fax());
            map.put("EMAIL", purchaseFile.getContactPerson1Email());
            map.put(" contactPerson1Favorite",  purchaseFile.getContactPerson1Favorite());
            map.put("第二联系人", purchaseFile.getContactPerson2());
            map.put("部门", purchaseFile.getContactPerson2Department());
            map.put("职务", purchaseFile.getContactPerson2Duty());
            map.put("性别", purchaseFile.getContactPerson2Sex());
            map.put("办公电话", purchaseFile.getContactPerson2OfficeTel());
            map.put("家庭电话", purchaseFile.getContactPerson2HomeTel());
            map.put("手机", purchaseFile.getContactPerson2Mobile());
            map.put(" contactPerson2Fax",  purchaseFile.getContactPerson2Fax());
            map.put("EMAIL", purchaseFile.getContactPerson2Email());
            map.put(" contactPerson2Favorite",  purchaseFile.getContactPerson2Favorite());
            map.put("开票信息", purchaseFile.getInvoiceInfo());
            map.put(" demandProducts",  purchaseFile.getDemandProducts());
            map.put("推荐供应产品集合", purchaseFile.getRecommendProducts());
            map.put("复核标志", purchaseFile.getCheckTag());
            map.put(" contactAmount",  purchaseFile.getContactAmount());
            map.put(" achievementSum",  purchaseFile.getAchievementSum());
            map.put(" attachmentName",  purchaseFile.getAttachmentName());
            map.put(" tradeAmount",  purchaseFile.getTradeAmount());
            map.put(" returnSum",  purchaseFile.getReturnSum());
            map.put(" returnAmount",  purchaseFile.getReturnAmount());
            map.put(" gatherPeriodSum",  purchaseFile.getGatherPeriodSum());
            map.put(" gatherPeriodAverage",  purchaseFile.getGatherPeriodAverage());
            map.put(" fileChangeAmount",  purchaseFile.getFileChangeAmount());
            map.put(" gatherPeriodLimit",  purchaseFile.getGatherPeriodLimit());
            map.put(" gatherSumLimit",  purchaseFile.getGatherSumLimit());
            map.put(" contactPeriodLimit",  purchaseFile.getContactPeriodLimit());
            map.put(" usedProviderName",  purchaseFile.getUsedProviderName());
            map.put("登记人", purchaseFile.getRegister());
            map.put("复核人", purchaseFile.getChecker());
            map.put("更改人", purchaseFile.getChanger());
            map.put("登记人iD", purchaseFile.getRegisterId());
            map.put("复核人ID", purchaseFile.getCheckerId());
            map.put("更改人id", purchaseFile.getChangerId());
            map.put("登记时间", purchaseFile.getRegisterTime());
            map.put("复核时间", purchaseFile.getCheckTime());
            map.put("更改时间", purchaseFile.getChangeTime());
            map.put(" latelyChangeTime",  purchaseFile.getLatelyChangeTime());
            map.put(" latelyTradeTime",  purchaseFile.getLatelyTradeTime());
            map.put(" latelyContactTime",  purchaseFile.getLatelyContactTime());
            map.put(" deleteTime",  purchaseFile.getDeleteTime());
            map.put(" recoveryTime",  purchaseFile.getRecoveryTime());
            map.put(" purchaser",  purchaseFile.getPurchaser());
            map.put(" purchaserId",  purchaseFile.getPurchaserId());
            map.put(" modifyTag",  purchaseFile.getModifyTag());
            map.put(" excelTag",  purchaseFile.getExcelTag());
            map.put(" remindContactTag",  purchaseFile.getRemindContactTag());
            map.put(" remindGatherTag",  purchaseFile.getRemindGatherTag());
            map.put(" remindReturnTag",  purchaseFile.getRemindReturnTag());
            map.put(" creditYesOrNotTag",  purchaseFile.getCreditYesOrNotTag());
            map.put(" purchasecreditCostPriceSum",  purchaseFile.getPurchasecreditCostPriceSum());
            map.put(" opinion",  purchaseFile.getOpinion());
            map.put(" promotion",  purchaseFile.getPromotion());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}