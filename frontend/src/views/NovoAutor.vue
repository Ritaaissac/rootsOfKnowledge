<template>
    <div class="novo-autor">
        <h1>Novo Autor</h1>
        <form @submit.prevent="submitForm">
        <div>
            <label for="nome">Nome:</label>
            <input type="text" id="nome" v-model="autor.nome" required />
        </div>
        <div>
            <label for="portfolioAutor">Link do Portfolio:</label>
            <textarea id="portfolioAutor" v-model="autor.portfolioAutor" required></textarea>
        </div>
        <button type="submit">Salvar Autor</button>
        </form>
    </div>
</template>

<script>
import { createNovoAutor } from '../actions/novoAutorActions';

export default {
  name: 'NovoAutor',
  data() {
    return {
      autor: {
        nome: '',
        portfolioAutor: ''
      }
    };
  },
  methods: {
    async submitForm() {
      try {
        // Chamar a ação para criar um novo autor
        await createNovoAutor(this.autor);
        alert('Autor criado com sucesso!');
        // Limpar o formulário
        this.autor.nome = '';
        this.autor.portfolioAutor = '';
      } catch (error) {
        console.error('Erro ao criar autor:', error);
        alert('Erro ao criar autor. Por favor, tente novamente.');
      }
    }
  }
}
</script>
