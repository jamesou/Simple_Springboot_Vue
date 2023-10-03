import Vue from 'vue'
import VueRouter from 'vue-router'
import BlogDetail from '../views/BlogDetail.vue'
import BlogEdit from '../views/BlogEdit.vue'
import Blogs from '../views/Blogs.vue'
import Login from '../views/Login.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    redirect:{name:"Blogs"}
  },
  {
    path: '/blogs',
    name: 'Blogs',
    component: Blogs
  },

  {
    path: '/login',
    name: 'Login',
    component: Login
  },

  {
    path: '/blog/add',
    name: 'BlogAdd',
    component: BlogEdit,
    meta:{
      requireAuth:true
    }
  },
  {
    path: '/blog/:blogId',
    name: 'BlogDetail',
    component: BlogDetail
  },
  {
    path: '/blog/:blogId/edit',
    name: 'BlogEdit',
    component: BlogEdit,
    meta:{
      requireAuth:true
    }
  },


  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Blogs.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
