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
package me.zhengjie.yj.purchase_file.service;

import me.zhengjie.yj.purchase_file.domain.PurchaseFile;
import me.zhengjie.yj.purchase_file.service.dto.PurchaseFileDto;
import me.zhengjie.yj.purchase_file.service.dto.PurchaseFileQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
* @website https://el-admin.vip
* @description 服务接口
* @author 杨娇
* @date 2021-01-21
**/
public interface PurchaseFileService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(PurchaseFileQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<PurchaseFileDto>
    */
    List<PurchaseFileDto> queryAll(PurchaseFileQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return PurchaseFileDto
     */
    PurchaseFileDto findById(Integer id);

    /**
    * 创建
    * @param resources /
    * @return PurchaseFileDto
    */
    PurchaseFileDto create(PurchaseFile resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(PurchaseFile resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Integer[] ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<PurchaseFileDto> all, HttpServletResponse response) throws IOException;
}