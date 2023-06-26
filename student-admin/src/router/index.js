import Vue from 'vue'
import router from 'vue-router'
import dataAnalyse from '../views/dataAnalyse/dataAnalyse'
import userManage from '../views/userManage/userManage'
import toDoList from '../views/toDoList/toDoList'
import postList from '../views/postList/postList'
import logIn from '../views/logIn/logIn'
import dashBoard from '../views/dashBoard/dashBoard'
Vue.use(router)
export default new router({
  routes: [
    {
      path: '/views/dashBoard/dashBoard',
      name: 'dashBoard',
      component: dashBoard
    },
     {
      path: '/views/dataAnalyse/dataAnalyse',
      name: 'dataAnalyse',
      component: dataAnalyse
    },
    {
      path: '/views/logIn/logIn',
      name: 'logIn',
      component: logIn
    },
    {
      path: '/views/postList/postList',
      name: 'postList',
      component: postList
    },
    {
        path: '/views/userManage/userManage',
        name: 'userManage',
        component: userManage
      },
     {
      path: '/views/toDoList/toDoList',
      name: 'toDoList',
      component: toDoList
    },
  ]
})

