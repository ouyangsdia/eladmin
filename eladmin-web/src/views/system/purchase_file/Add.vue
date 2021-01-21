<template>
  <div class="main">
    <div class="crud-opts">
      <span class="crud-opts-left">
        <!--左侧插槽-->
        <slot name="left" />
        <el-button
          v-if="crud.optShow.add"
          v-permission="permission.add"
          class="filter-item"
          size="mini"
          type="primary"
          icon="el-icon-plus"
          :loading="crud.status.cu === 2"
          @click="crud.toAdd2"
        >
          新增
        </el-button>
        <el-button
          v-if="crud.optShow.edit"
          v-permission="permission.edit"
          class="filter-item"
          size="mini"
          type="success"
          icon="el-icon-edit"

          @click="crud.toEdit(crud.selections[0])"
        >
          EXCEL导入
        </el-button>
        <el-button
          v-if="crud.optShow.del"
          slot="reference"
          v-permission="permission.del"
          class="filter-item"
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :loading="crud.delAllLoading"
          @click="toDelete(crud.selections)"
        >
          PDF打印
        </el-button>
        <el-button
          v-if="crud.optShow.download"
          :loading="crud.downloadLoading"
          class="filter-item"
          size="mini"
          type="warning"
          icon="el-icon-download"
          @click="crud.doExport"
        >清除</el-button>
        <!--右侧-->
        <slot name="right" />
      </span>

    </div>
    <el-form ref="form" :model="form" :rules="rules" size="small" label-width="120px">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>主信息</span>
        </div>
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
          <el-form-item label="I类产品" prop="firstKindName">
            <el-select v-model="form.firstKindName" filterable placeholder="请选择">
              <el-option
                v-for="item in dict.I"
                :key="item.id"
                :label="item.label"
                :value="item.value"
              />
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
                :value="item.value"
              />
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
                :value="item.value"
              />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="优质级别" prop="providerClass">

            <el-select v-model="form.providerClass" filterable placeholder="请选择">
              <el-option
                v-for="item in dict.nice"
                :key="item.id"
                :label="item.label"
                :value="item.value"
              />
            </el-select>
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
          <el-form-item label="EMAIL">
            <el-input v-model="form.providerEmail" style="width: 370px;" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="邮政编码">
            <el-input v-model="form.providerPostcode" style="width: 370px;" />
          </el-form-item>
        </el-col>
      </el-card>
      <el-card>
        <div slot="header" class="clearfix">
          <span>联系人信息</span>
        </div>
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
          <el-form-item label="EMAIL">
            <el-input v-model="form.contactPerson1Email" style="width: 370px;" />
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
          <el-form-item label="EMAIL">
            <el-input v-model="form.contactPerson2Email" style="width: 370px;" />
          </el-form-item>
        </el-col>
      </el-card>
      <el-card>
        <div slot="header" class="clearfix">
          <span>动态信息</span>
        </div>
        <el-col :span="12">
          <el-form-item label="开票信息">
            <el-input v-model="form.invoiceInfo" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="推荐供应产品集合">
            <el-input v-model="form.recommendProducts" :rows="3" type="textarea" style="width: 370px;" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记人">
            <el-input v-model="form.register" style="width: 370px;" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="登记时间">
            <el-date-picker v-model="form.registerTime" type="datetime" style="width: 370px;" />
          </el-form-item>
        </el-col>
      </el-card>
    </el-form>
  </div>

</template>

<script>

import crudPurchaseFile from '@/api/purchaseFile'
import CRUD, { presenter, header, form, crud } from '@crud/crud'
import rrOperation from '@crud/RR.operation'
import crudOperation from '@crud/CRUD.operation'
import udOperation from '@crud/UD.operation'
import pagination from '@crud/Pagination'
const defaultForm = { id: null, firstKindId: null, firstKindName: null, secondKindId: null, secondKindName: null, thirdKindId: null, thirdKindName: null, providerId: null, providerName: null, providerNick: null, providerAddress: null, providerClass: null, type: null, providerBank: null, providerAccount: null, providerWeb: null, providerTel1: null, providerTel2: null, providerEmail: null, providerFax: null, providerPostcode: null, contactPerson1: null, contactPerson1Department: null, contactPerson1Duty: null, contactPerson1Sex: null, contactPerson1OfficeTel: null, contactPerson1HomeTel: null, contactPerson1Mobile: null, contactPerson1Fax: null, contactPerson1Email: null, contactPerson1Favorite: null, contactPerson2: null, contactPerson2Department: null, contactPerson2Duty: null, contactPerson2Sex: null, contactPerson2OfficeTel: null, contactPerson2HomeTel: null, contactPerson2Mobile: null, contactPerson2Fax: null, contactPerson2Email: null, contactPerson2Favorite: null, invoiceInfo: null, demandProducts: null, recommendProducts: null, checkTag: null, contactAmount: null, achievementSum: null, attachmentName: null, tradeAmount: null, returnSum: null, returnAmount: null, gatherPeriodSum: null, gatherPeriodAverage: null, fileChangeAmount: null, gatherPeriodLimit: null, gatherSumLimit: null, contactPeriodLimit: null, usedProviderName: null, register: null, checker: null, changer: null, registerId: null, checkerId: null, changerId: null, registerTime: new Date(), checkTime: null, changeTime: null, latelyChangeTime: null, latelyTradeTime: null, latelyContactTime: null, deleteTime: null, recoveryTime: null, purchaser: null, purchaserId: null, modifyTag: null, excelTag: null, remindContactTag: null, remindGatherTag: null, remindReturnTag: null, creditYesOrNotTag: null, purchasecreditCostPriceSum: null, opinion: null, promotion: null }
export default {
  name: 'Add',
  // eslint-disable-next-line vue/no-unused-components
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
        ]
      }}
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
.main{
  padding: 20px 100px;
}
.crud-opts {
  padding: 20px 0;
  display: -webkit-flex;
  display: flex;
  align-items: inherit;
}
</style>
