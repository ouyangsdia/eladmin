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
package me.zhengjie.yj.purchase_file.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.zhengjie.annotation.Log;
import me.zhengjie.yj.purchase_file.domain.PurchaseFile;
import me.zhengjie.yj.purchase_file.service.PurchaseFileService;
import me.zhengjie.yj.purchase_file.service.dto.PurchaseFileQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @website https://el-admin.vip
* @author 杨娇
* @date 2021-01-21
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "供应商档案管理管理")
@RequestMapping("/api/purchaseFile")
public class PurchaseFileController {

    private final PurchaseFileService purchaseFileService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('purchaseFile:list')")
    public void download(HttpServletResponse response, PurchaseFileQueryCriteria criteria) throws IOException {
        purchaseFileService.download(purchaseFileService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询供应商档案管理")
    @ApiOperation("查询供应商档案管理")
    @PreAuthorize("@el.check('purchaseFile:list')")
    public ResponseEntity<Object> query(PurchaseFileQueryCriteria criteria, Pageable pageable){
        System.out.println(criteria);
        return new ResponseEntity<>(purchaseFileService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增供应商档案管理")
    @ApiOperation("新增供应商档案管理")
    @PreAuthorize("@el.check('purchaseFile:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody PurchaseFile resources){
        return new ResponseEntity<>(purchaseFileService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改供应商档案管理")
    @ApiOperation("修改供应商档案管理")
    @PreAuthorize("@el.check('purchaseFile:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody PurchaseFile resources){
        purchaseFileService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除供应商档案管理")
    @ApiOperation("删除供应商档案管理")
    @PreAuthorize("@el.check('purchaseFile:del')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Integer[] ids) {
        purchaseFileService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}