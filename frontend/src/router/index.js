import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import NovoAutor from '../views/NovoAutor.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/novo-autor',
    name: 'NovoAutor',
    component: NovoAutor
  },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
