import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import NovoAutor from '../views/NovoAutor.vue'
import NovoGenero from '../views/NovoGenero.vue'
import VerGenero from '@/views/VerGenero.vue'

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
  {
    path: '/novo-genero',
    name: 'NovoGenero',
    component: NovoGenero
  },

  {
    path: '/ver-genero',
    name: 'VerGenero',
    component: VerGenero
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router