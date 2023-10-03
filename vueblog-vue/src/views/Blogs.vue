<template>
    <div class="mcontaner">
        <Header></Header>

        <div class="block">
            <el-timeline>

                <el-timeline-item :timestamp="blog.created" placement="top" v-for="blog in blogs">
                    <el-card>


                        <h4>
                            <router-link :to="{name: 'BlogDetail', params: {blogId: blog.id}}">
                                {{blog.title}}
                            </router-link>
                        </h4>
                        <p>{{blog.description}}</p>
                    </el-card>  <el-button
                        size="mini"
                        type="danger"
                        icon="el-icon-delete"
                        @click="deleteBlog(blog.id)">删除
                </el-button>
                </el-timeline-item>

            </el-timeline>

            <el-pagination class="mpage"
                           background
                           layout="prev, pager, next"
                           :current-page="currentPage"
                           :page-size="pageSize"
                           :total="total"
                           @current-change=page>
            </el-pagination>

        </div>

    </div>
</template>

<script>
    import Header from "../components/Header";
    export default {
        name: "Blogs.vue",
        components: {Header},
        data() {
            return {
                blogs: {},
                currentPage: 1,
                total: 0,
                pageSize: 5
            }
        },
        methods: {
            page(currentPage) {
                const _this = this
                _this.$axios.get("/blogs?currentPage=" + currentPage).then(res => {
                    console.log(res)
                    _this.blogs = res.data.data.records
                    _this.currentPage = res.data.data.current
                    _this.total = res.data.data.total
                    _this.pageSize = res.data.data.size

                })
            },
             async deleteBlog(id) {
                 const blogId = id
                 const _this = this
                 const confirmResult = await this.$confirm('此操作将永久删除用户，是否继续?', "提示", {
                     confirmButtonText: "确定",
                     cancelButtonText: "取消",
                     type: 'warning',
                 }).catch(err => err)
                 if (confirmResult != 'confirm') {
                     return this.$message.info("已取消删除");
                 }
                 const{data:res}=await _this.$axios.get("/blog/drop/" + blogId)

                return  this.$message.success("删除成功");
                location.reload();
             },

        },
        created() {
            this.page(1)
        }
    }
</script>

<style scoped>

    el-button{
       margin-left: 300px;
    }

</style>
