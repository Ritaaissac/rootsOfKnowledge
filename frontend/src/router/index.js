import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import NovoAutor from '../views/NovoAutor.vue'
import NovoGenero from '../views/NovoGenero.vue'
import VerGenero from '@/views/VerGenero.vue'
import path from 'node:path'
import NovoLivro from '@/views/NovoLivro.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/novo-autor', // mudar as rotas posteriormente para ficar /autor/novo, /genero/novo, etc.
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
  },
  
  {
    path: '/novo-livro',
    name: 'NovoLivro',
    component: NovoLivro
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router