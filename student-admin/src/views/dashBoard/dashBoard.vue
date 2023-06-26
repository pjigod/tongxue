<template>
  <div class=".home-header-menu">
    <el-col :span="24">
      <el-menu
        :default-active="this.$route.path"
        router
        mode="horizontal"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b"
      >
        <el-menu-item  v-for="(item, i) in navList" :key="i" :index="item.name" >
          <template slot="title">
            <i class="el-icon-s-platform"></i>
            <span> {{ item.navItem }}</span>
          </template>
        </el-menu-item>
      </el-menu>
    </el-col>
    <router-view class="menu-right" />
  </div>
</template>
<script>
export default {
  data() {
    return {
      navList: [
        { name: "/views/toDoList/toDoList", navItem: "待办事件" },
        { name: "/views/userManage/userManage", navItem: "用户管理" },
        { name: "/views/dataAnalyse/dataAnalyse", navItem: "数据分析" },
        { name: "/views/postList/postList", navItem: "帖子管理" },
      ],
    };
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    },
  },
};
</script>

<style>
.menu-right {
  margin-left: 200px;
}
.el-menu-item{
  min-width: 300px;
}
</style>

