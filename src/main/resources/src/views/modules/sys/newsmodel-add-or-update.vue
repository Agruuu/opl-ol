<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="新闻model标题" prop="modelTitle">
      <el-input v-model="dataForm.modelTitle" placeholder="新闻model标题"></el-input>
    </el-form-item>
    <el-form-item label="父级新闻model标题" prop="modelSupperId">
      <el-input v-model="dataForm.modelSupperId" placeholder="父级新闻model标题"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          modelId: 0,
          modelTitle: '',
          modelSupperId: ''
        },
        dataRule: {
          modelTitle: [
            { required: true, message: '新闻model标题不能为空', trigger: 'blur' }
          ],
          modelSupperId: [
            { required: true, message: '父级新闻model标题不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.modelId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.modelId) {
            this.$http({
              url: this.$http.adornUrl(`/sys/newsmodel/info/${this.dataForm.modelId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.modelTitle = data.newsmodel.modelTitle
                this.dataForm.modelSupperId = data.newsmodel.modelSupperId
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/sys/newsmodel/${!this.dataForm.modelId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'modelId': this.dataForm.modelId || undefined,
                'modelTitle': this.dataForm.modelTitle,
                'modelSupperId': this.dataForm.modelSupperId
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
