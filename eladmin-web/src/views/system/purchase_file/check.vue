<template>
  <div>
    <el-table ref="table" v-loading="crud.loading" :data="crud.data" size="small" style="width: 100%;" @selection-change="crud.selectionChangeHandler">
      <el-table-column type="selection" width="55" />

      <el-table-column prop="providerId" label="供应商编号" />
      <el-table-column prop="providerName" label="供应商名称" />

      <el-table-column prop="firstKindName" label="Ⅰ级分类">
        <template slot-scope="scope">
          {{ dict.label.I[scope.row.firstKindName] }}
        </template>
      </el-table-column>
      <el-table-column prop="secondKindName" label="Ⅱ级分类">
        <template slot-scope="scope">
          {{ dict.label.II[scope.row.secondKindName] }}
        </template>
      </el-table-column>
      <el-table-column prop="thirdKindName" label="III类产品">
        <template slot-scope="scope">
          {{ dict.label.III[scope.row.thirdKindName] }}
        </template>
      </el-table-column>
      <el-table-column prop="providerClass" label="优质级别">
        <template slot-scope="scope">
          {{ dict.label.nice[scope.row.providerClass] }}
        </template>
      </el-table-column>
      <el-table-column prop="supplierBuyer" label="采购人" />

      <el-table-column v-if="checkPer(['admin','parchaseSupplierfiles:edit','parchaseSupplierfiles:del'])" label="操作" width="150px" align="center">

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
    <el-dialog width="70%" :close-on-click-modal="false" :before-close="crud.cancelCU" :visible.sync="crud.status.cu > 0" :title="crud.status.title">
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
      <div slot="footer" class="dialog-footer">

        <el-button type="text" @click="crud.cancelCU">取消</el-button>
        <!--      crud.CheckCu  <el-button :loading="crud.status.cu === 2" type="primary" @click="crud.submitCU">确认</el-button>-->
        <el-popover
          placement="top"
          width="160"
          :value="crud.status.cu > 0"
        >
          <p>审核结果</p>
          <div style="text-align: right; margin: 0">
            <el-button size="mini" type="text" @click="check('未通过')">未通过</el-button>
            <el-button type="primary" :loading="crud.status.cu === 2" size="mini" @click="check('通过')">通过</el-button>
          </div>
          <el-button slot="reference">确认</el-button>
        </el-popover>
      </div>
    </el-dialog>
  </div>

</template>

<script>
import crudPurchaseFile from '@/api/purchaseFile'
import CRUD, { presenter, header, form, crud } from '@crud/crud'
import rrOperation from '@crud/RR.operation'
import crudOperation from '@crud/CRUD.operation'
import udOperation from '@crud/check'
import pagination from '@crud/Pagination'

const defaultForm = { id: null, firstKindId: null, firstKindName: null, secondKindId: null, secondKindName: null, thirdKindId: null, thirdKindName: null, providerId: null, providerName: null, providerNick: null, providerAddress: null, providerClass: null, type: null, providerBank: null, providerAccount: null, providerWeb: null, providerTel1: null, providerTel2: null, providerEmail: null, providerFax: null, providerPostcode: null, contactPerson1: null, contactPerson1Department: null, contactPerson1Duty: null, contactPerson1Sex: null, contactPerson1OfficeTel: null, contactPerson1HomeTel: null, contactPerson1Mobile: null, contactPerson1Fax: null, contactPerson1Email: null, contactPerson1Favorite: null, contactPerson2: null, contactPerson2Department: null, contactPerson2Duty: null, contactPerson2Sex: null, contactPerson2OfficeTel: null, contactPerson2HomeTel: null, contactPerson2Mobile: null, contactPerson2Fax: null, contactPerson2Email: null, contactPerson2Favorite: null, invoiceInfo: null, demandProducts: null, recommendProducts: null, checkTag: null, contactAmount: null, achievementSum: null, attachmentName: null, tradeAmount: null, returnSum: null, returnAmount: null, gatherPeriodSum: null, gatherPeriodAverage: null, fileChangeAmount: null, gatherPeriodLimit: null, gatherSumLimit: null, contactPeriodLimit: null, usedProviderName: null, register: null, checker: null, changer: null, registerId: null, checkerId: null, changerId: null, registerTime: null, checkTime: null, changeTime: null, latelyChangeTime: null, latelyTradeTime: null, latelyContactTime: null, deleteTime: null, recoveryTime: null, purchaser: null, purchaserId: null, modifyTag: null, excelTag: null, remindContactTag: null, remindGatherTag: null, remindReturnTag: null, creditYesOrNotTag: null, purchasecreditCostPriceSum: null, opinion: null, promotion: null }
export default {
  name: 'Check',
  components: { pagination, crudOperation, rrOperation, udOperation },
  mixins: [presenter(), header(), form(defaultForm), crud()],
  dicts: ['I', 'II', 'III', 'nice'],
  cruds() {
    return CRUD({ title: '供应商档案管理', url: 'api/purchaseFile', idField: 'id', sort: 'id,asc', query: { checkTag: 0 }, crudMethod: { ...crudPurchaseFile }})
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
      }}
  },
  methods: {
    // 钩子：在获取表格数据之前执行，false 则代表不获取数据
    [CRUD.HOOK.beforeRefresh]() {
      return true
    },
    check(type) {
      if (type !== '通过') {
        this.form.checkTag = 1
        //  this.from.checkTag
      } else {
        this.form.checkTag = 1
      }
      this.crud.CheckCu()
    }
  }
}
</script>

<style scoped>

</style>
