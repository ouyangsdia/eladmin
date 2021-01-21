<template>
  <div class="app-container">
    <!--工具栏-->
    <div class="head-container">
      <!--如果想在工具栏加入更多按钮，可以使用插槽方式， slot = 'left' or 'right'-->
      <crudOperation :permission="permission" />
      <!--表单组件-->
      <el-dialog :close-on-click-modal="false" :before-close="crud.cancelCU" :visible.sync="crud.status.cu > 0" :title="crud.status.title" width="500px">
        <el-form ref="form" :model="form" :rules="rules" size="small" label-width="80px">


          <el-col :span="12">
          <el-form-item label="id">
            <el-input v-model="form.id" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="I类产品" prop="firstKindName">
            <el-select v-model="form.firstKindName" filterable placeholder="请选择">
              <el-option
                v-for="item in dict.I"
                :key="item.id"
                :label="item.label"
                :value="item.value" />
            </el-select>
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="II类产品" prop="secondKindName">
            <el-select v-model="form.secondKindName" filterable placeholder="请选择">
              <el-option
                v-for="item in dict.II"
                :key="item.id"
                :label="item.label"
                :value="item.value" />
            </el-select>
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="III类产品" prop="thirdKindName">
            <el-select v-model="form.thirdKindName" filterable placeholder="请选择">
              <el-option
                v-for="item in dict.III"
                :key="item.id"
                :label="item.label"
                :value="item.value" />
            </el-select>
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="供应商编号" prop="providerId">
            <el-input v-model="form.providerId" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="供应商名称" prop="providerName">
            <el-input v-model="form.providerName" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="供应商曾用名">
            <el-input v-model="form.providerNick" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="地址">
            <el-input v-model="form.providerAddress" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="优质级别" prop="providerClass">
            <el-input v-model="form.providerClass" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="type" prop="type">
            <el-input v-model="form.type" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="开户银行">
            <el-input v-model="form.providerBank" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="银行账号">
            <el-input v-model="form.providerAccount" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="网址">
            <el-input v-model="form.providerWeb" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="电话">
            <el-input v-model="form.providerTel1" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="providerTel2">
            <el-input v-model="form.providerTel2" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="EMAIL">
            <el-input v-model="form.providerEmail" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="providerFax">
            <el-input v-model="form.providerFax" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="邮政编码">
            <el-input v-model="form.providerPostcode" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="第一联系人">
            <el-input v-model="form.contactPerson1" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="部门">
            <el-input v-model="form.contactPerson1Department" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="职务">
            <el-input v-model="form.contactPerson1Duty" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="性别">
            <el-input v-model="form.contactPerson1Sex" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="办公电话">
            <el-input v-model="form.contactPerson1OfficeTel" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="家庭电话">
            <el-input v-model="form.contactPerson1HomeTel" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="手机">
            <el-input v-model="form.contactPerson1Mobile" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="contactPerson1Fax">
            <el-input v-model="form.contactPerson1Fax" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="EMAIL">
            <el-input v-model="form.contactPerson1Email" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="contactPerson1Favorite">
            <el-input v-model="form.contactPerson1Favorite" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="第二联系人">
            <el-input v-model="form.contactPerson2" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="部门">
            <el-input v-model="form.contactPerson2Department" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="职务">
            <el-input v-model="form.contactPerson2Duty" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="性别">
            <el-input v-model="form.contactPerson2Sex" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="办公电话">
            <el-input v-model="form.contactPerson2OfficeTel" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="家庭电话">
            <el-input v-model="form.contactPerson2HomeTel" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="手机">
            <el-input v-model="form.contactPerson2Mobile" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="contactPerson2Fax">
            <el-input v-model="form.contactPerson2Fax" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="EMAIL">
            <el-input v-model="form.contactPerson2Email" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="contactPerson2Favorite">
            <el-input v-model="form.contactPerson2Favorite" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="开票信息">
            <el-input v-model="form.invoiceInfo" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="demandProducts">
            <el-input v-model="form.demandProducts" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="推荐供应产品集合">
            <el-input v-model="form.recommendProducts" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="复核标志">
            <el-input v-model="form.checkTag" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="contactAmount">
            <el-input v-model="form.contactAmount" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="achievementSum">
            <el-input v-model="form.achievementSum" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="attachmentName">
            <el-input v-model="form.attachmentName" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="tradeAmount">
            <el-input v-model="form.tradeAmount" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="returnSum">
            <el-input v-model="form.returnSum" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="returnAmount">
            <el-input v-model="form.returnAmount" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="gatherPeriodSum">
            <el-input v-model="form.gatherPeriodSum" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="gatherPeriodAverage">
            <el-input v-model="form.gatherPeriodAverage" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="fileChangeAmount">
            <el-input v-model="form.fileChangeAmount" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="gatherPeriodLimit">
            <el-input v-model="form.gatherPeriodLimit" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="gatherSumLimit">
            <el-input v-model="form.gatherSumLimit" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="contactPeriodLimit">
            <el-input v-model="form.contactPeriodLimit" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="usedProviderName">
            <el-input v-model="form.usedProviderName" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="登记人">
            <el-input v-model="form.register" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="复核人">
            <el-input v-model="form.checker" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="更改人">
            <el-input v-model="form.changer" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="登记人iD">
            <el-input v-model="form.registerId" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="复核人ID">
            <el-input v-model="form.checkerId" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="更改人id">
            <el-input v-model="form.changerId" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="登记时间">
            <el-input v-model="form.registerTime" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="复核时间">
            <el-input v-model="form.checkTime" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="更改时间">
            <el-input v-model="form.changeTime" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="latelyChangeTime">
            <el-input v-model="form.latelyChangeTime" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="latelyTradeTime">
            <el-input v-model="form.latelyTradeTime" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="latelyContactTime">
            <el-input v-model="form.latelyContactTime" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="deleteTime">
            <el-input v-model="form.deleteTime" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="recoveryTime">
            <el-input v-model="form.recoveryTime" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="purchaser">
            <el-input v-model="form.purchaser" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="purchaserId">
            <el-input v-model="form.purchaserId" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="modifyTag">
            <el-input v-model="form.modifyTag" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="excelTag">
            <el-input v-model="form.excelTag" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="remindContactTag">
            <el-input v-model="form.remindContactTag" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="remindGatherTag">
            <el-input v-model="form.remindGatherTag" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="remindReturnTag">
            <el-input v-model="form.remindReturnTag" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="creditYesOrNotTag">
            <el-input v-model="form.creditYesOrNotTag" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="purchasecreditCostPriceSum">
            <el-input v-model="form.purchasecreditCostPriceSum" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="opinion">
            <el-input v-model="form.opinion" style="width: 370px;" />
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="promotion">
            <el-input v-model="form.promotion" style="width: 370px;" />
          </el-form-item>
          </el-col>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="text" @click="crud.cancelCU">取消</el-button>
          <el-button :loading="crud.status.cu === 2" type="primary" @click="crud.submitCU">确认</el-button>
        </div>
      </el-dialog>
      <!--表格渲染-->
      <el-table ref="table" v-loading="crud.loading" :data="crud.data" size="small" style="width: 100%;" @selection-change="crud.selectionChangeHandler">
        <el-table-column type="selection" width="55" />
        <el-table-column prop="id" label="id" />
        <el-table-column prop="firstKindName" label="I类产品">
          <template slot-scope="scope">
            {{ dict.label.I[scope.row.firstKindName] }}
          </template>
        </el-table-column>
        <el-table-column prop="secondKindName" label="II类产品">
          <template slot-scope="scope">
            {{ dict.label.II[scope.row.secondKindName] }}
          </template>
        </el-table-column>
        <el-table-column prop="thirdKindName" label="III类产品">
          <template slot-scope="scope">
            {{ dict.label.III[scope.row.thirdKindName] }}
          </template>
        </el-table-column>
        <el-table-column prop="providerId" label="供应商编号" />
        <el-table-column prop="providerName" label="供应商名称" />
        <el-table-column prop="providerNick" label="供应商曾用名" />
        <el-table-column prop="providerAddress" label="地址" />
        <el-table-column prop="providerClass" label="优质级别">
          <template slot-scope="scope">
            {{ dict.label.nice[scope.row.providerClass] }}
          </template>
        </el-table-column>
        <el-table-column prop="type" label="type" />
        <el-table-column prop="providerBank" label="开户银行" />
        <el-table-column prop="providerAccount" label="银行账号" />
        <el-table-column prop="providerWeb" label="网址" />
        <el-table-column prop="providerTel1" label="电话" />
        <el-table-column prop="providerTel2" label="providerTel2" />
        <el-table-column prop="providerEmail" label="EMAIL" />
        <el-table-column prop="providerFax" label="providerFax" />
        <el-table-column prop="providerPostcode" label="邮政编码" />
        <el-table-column prop="contactPerson1" label="第一联系人" />
        <el-table-column prop="contactPerson1Department" label="部门" />
        <el-table-column prop="contactPerson1Duty" label="职务" />
        <el-table-column prop="contactPerson1Sex" label="性别" />
        <el-table-column prop="contactPerson1OfficeTel" label="办公电话" />
        <el-table-column prop="contactPerson1HomeTel" label="家庭电话" />
        <el-table-column prop="contactPerson1Mobile" label="手机" />
        <el-table-column prop="contactPerson1Fax" label="contactPerson1Fax" />
        <el-table-column prop="contactPerson1Email" label="EMAIL" />
        <el-table-column prop="contactPerson1Favorite" label="contactPerson1Favorite" />
        <el-table-column prop="contactPerson2" label="第二联系人" />
        <el-table-column prop="contactPerson2Department" label="部门" />
        <el-table-column prop="contactPerson2Duty" label="职务" />
        <el-table-column prop="contactPerson2Sex" label="性别" />
        <el-table-column prop="contactPerson2OfficeTel" label="办公电话" />
        <el-table-column prop="contactPerson2HomeTel" label="家庭电话" />
        <el-table-column prop="contactPerson2Mobile" label="手机" />
        <el-table-column prop="contactPerson2Fax" label="contactPerson2Fax" />
        <el-table-column prop="contactPerson2Email" label="EMAIL" />
        <el-table-column prop="contactPerson2Favorite" label="contactPerson2Favorite" />
        <el-table-column prop="invoiceInfo" label="开票信息" />
        <el-table-column prop="demandProducts" label="demandProducts" />
        <el-table-column prop="recommendProducts" label="推荐供应产品集合" />
        <el-table-column prop="checkTag" label="复核标志" />
        <el-table-column prop="contactAmount" label="contactAmount" />
        <el-table-column prop="achievementSum" label="achievementSum" />
        <el-table-column prop="attachmentName" label="attachmentName" />
        <el-table-column prop="tradeAmount" label="tradeAmount" />
        <el-table-column prop="returnSum" label="returnSum" />
        <el-table-column prop="returnAmount" label="returnAmount" />
        <el-table-column prop="gatherPeriodSum" label="gatherPeriodSum" />
        <el-table-column prop="gatherPeriodAverage" label="gatherPeriodAverage" />
        <el-table-column prop="fileChangeAmount" label="fileChangeAmount" />
        <el-table-column prop="gatherPeriodLimit" label="gatherPeriodLimit" />
        <el-table-column prop="gatherSumLimit" label="gatherSumLimit" />
        <el-table-column prop="contactPeriodLimit" label="contactPeriodLimit" />
        <el-table-column prop="usedProviderName" label="usedProviderName" />
        <el-table-column prop="register" label="登记人" />
        <el-table-column prop="checker" label="复核人" />
        <el-table-column prop="changer" label="更改人" />
        <el-table-column prop="registerId" label="登记人iD" />
        <el-table-column prop="checkerId" label="复核人ID" />
        <el-table-column prop="changerId" label="更改人id" />
        <el-table-column prop="registerTime" label="登记时间" />
        <el-table-column prop="checkTime" label="复核时间" />
        <el-table-column prop="changeTime" label="更改时间" />
        <el-table-column prop="latelyChangeTime" label="latelyChangeTime" />
        <el-table-column prop="latelyTradeTime" label="latelyTradeTime" />
        <el-table-column prop="latelyContactTime" label="latelyContactTime" />
        <el-table-column prop="deleteTime" label="deleteTime" />
        <el-table-column prop="recoveryTime" label="recoveryTime" />
        <el-table-column prop="purchaser" label="purchaser" />
        <el-table-column prop="purchaserId" label="purchaserId" />
        <el-table-column prop="modifyTag" label="modifyTag" />
        <el-table-column prop="excelTag" label="excelTag" />
        <el-table-column prop="remindContactTag" label="remindContactTag" />
        <el-table-column prop="remindGatherTag" label="remindGatherTag" />
        <el-table-column prop="remindReturnTag" label="remindReturnTag" />
        <el-table-column prop="creditYesOrNotTag" label="creditYesOrNotTag" />
        <el-table-column prop="purchasecreditCostPriceSum" label="purchasecreditCostPriceSum" />
        <el-table-column prop="opinion" label="opinion" />
        <el-table-column prop="promotion" label="promotion" />
        <el-table-column v-if="checkPer(['admin','purchaseFile:edit','purchaseFile:del'])" label="操作" width="150px" align="center">
          <template slot-scope="scope">
            <udOperation
              :data="scope.row"
              :permission="permission"
            />
          </template>
        </el-table-column>
      </el-table>
      <!--分页组件-->
      <pagination />
    </div>
  </div>
</template>

<script>
import crudPurchaseFile from '@/api/purchaseFile'
import CRUD, { presenter, header, form, crud } from '@crud/crud'
import rrOperation from '@crud/RR.operation'
import crudOperation from '@crud/CRUD.operation'
import udOperation from '@crud/UD.operation'
import pagination from '@crud/Pagination'

const defaultForm = { id: null, firstKindId: null, firstKindName: null, secondKindId: null, secondKindName: null, thirdKindId: null, thirdKindName: null, providerId: null, providerName: null, providerNick: null, providerAddress: null, providerClass: null, type: null, providerBank: null, providerAccount: null, providerWeb: null, providerTel1: null, providerTel2: null, providerEmail: null, providerFax: null, providerPostcode: null, contactPerson1: null, contactPerson1Department: null, contactPerson1Duty: null, contactPerson1Sex: null, contactPerson1OfficeTel: null, contactPerson1HomeTel: null, contactPerson1Mobile: null, contactPerson1Fax: null, contactPerson1Email: null, contactPerson1Favorite: null, contactPerson2: null, contactPerson2Department: null, contactPerson2Duty: null, contactPerson2Sex: null, contactPerson2OfficeTel: null, contactPerson2HomeTel: null, contactPerson2Mobile: null, contactPerson2Fax: null, contactPerson2Email: null, contactPerson2Favorite: null, invoiceInfo: null, demandProducts: null, recommendProducts: null, checkTag: null, contactAmount: null, achievementSum: null, attachmentName: null, tradeAmount: null, returnSum: null, returnAmount: null, gatherPeriodSum: null, gatherPeriodAverage: null, fileChangeAmount: null, gatherPeriodLimit: null, gatherSumLimit: null, contactPeriodLimit: null, usedProviderName: null, register: null, checker: null, changer: null, registerId: null, checkerId: null, changerId: null, registerTime: null, checkTime: null, changeTime: null, latelyChangeTime: null, latelyTradeTime: null, latelyContactTime: null, deleteTime: null, recoveryTime: null, purchaser: null, purchaserId: null, modifyTag: null, excelTag: null, remindContactTag: null, remindGatherTag: null, remindReturnTag: null, creditYesOrNotTag: null, purchasecreditCostPriceSum: null, opinion: null, promotion: null }
export default {
  name: 'PurchaseFile',
  components: { pagination, crudOperation, rrOperation, udOperation },
  mixins: [presenter(), header(), form(defaultForm), crud()],
  dicts: ['I', 'II', 'III', 'nice'],
  cruds() {
    return CRUD({ title: '供应商档案管理', url: 'api/purchaseFile', idField: 'id', sort: 'id,desc', crudMethod: { ...crudPurchaseFile }})
  },
  data() {
    return {
      permission: {
        add: ['admin', 'purchaseFile:add'],
        edit: ['admin', 'purchaseFile:edit'],
        del: ['admin', 'purchaseFile:del']
      },
      rules: {
        firstKindName: [
          { required: true, message: 'I类产品不能为空', trigger: 'blur' }
        ],
        secondKindName: [
          { required: true, message: 'II类产品不能为空', trigger: 'blur' }
        ],
        thirdKindName: [
          { required: true, message: 'III类产品不能为空', trigger: 'blur' }
        ],
        providerId: [
          { required: true, message: '供应商编号不能为空', trigger: 'blur' }
        ],
        providerName: [
          { required: true, message: '供应商名称不能为空', trigger: 'blur' }
        ],
        providerClass: [
          { required: true, message: '优质级别不能为空', trigger: 'blur' }
        ],
        type: [
          { required: true, message: '不能为空', trigger: 'blur' }
        ]
      }    }
  },
  methods: {
    // 钩子：在获取表格数据之前执行，false 则代表不获取数据
    [CRUD.HOOK.beforeRefresh]() {
      return true
    }
  }
}
</script>

<style scoped>

</style>
