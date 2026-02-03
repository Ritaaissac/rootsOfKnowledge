<template>
  <h1>oi</h1>
</template>


<script>
import { createNovoLivro } from '@/actions/novoLivroActions';

createNovoLivro
export default {
  name: 'NovoLivro',
  data() {
    return {
      livro: {
        titulo: '',
        autor: '',
        genero: ''
      }
    };
  },
  methods: {
    async submitForm() {
      try {
        await createNovoLivro(this.livro);
        this.livro = {
          titulo: '',
          autor: '',
          genero: ''
        };
      } catch (error) {
        console.error('Erro ao criar livro: ', error);
        alert('Erro ao criar livro. Tente novamente.');
      }
    }
  }
}

</script>
