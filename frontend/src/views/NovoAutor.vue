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

<style scoped>
* {
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}


/* CONTAINER PRINCIPAL */
.novo-autor {
  min-height: 100vh;
  background-color: #fff4e6;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  padding: 40px 20px;
}

/* TÍTULO */
.novo-autor h1 {
  font-size: 42px;
  color: #f97316;
  margin-bottom: 32px;
  text-align: center;
}

/* CARD DO FORM */
.novo-autor form {
  width: 100%;
  max-width: 520px;
  background-color: #ffe9c6;
  padding: 40px;
  border-radius: 28px;
  box-shadow: 0 25px 50px rgba(0, 0, 0, 0.1);
}

/* GRUPOS DE CAMPOS */
.novo-autor form > div {
  display: flex;
  flex-direction: column;
  margin-bottom: 24px;
}

/* LABEL */
.novo-autor label {
  font-size: 12px;
  letter-spacing: 2px;
  text-transform: uppercase;
  color: #2f6f4e;
  margin-bottom: 8px;
}

/* INPUT E TEXTAREA */
.novo-autor input,
.novo-autor textarea {
  padding: 14px 18px;
  border-radius: 14px;
  border: 1.5px solid #fcd34d;
  font-size: 14px;
  background-color: #ffffff;
  outline: none;
  transition: border-color 0.3s ease, box-shadow 0.3s ease;
}

.novo-autor textarea {
  resize: vertical;
  min-height: 120px;
}

/* FOCO */
.novo-autor input:focus,
.novo-autor textarea:focus {
  border-color: #f59e0b;
  box-shadow: 0 0 0 4px rgba(245, 158, 11, 0.25);
}

/* BOTÃO */
.novo-autor button {
  width: 100%;
  margin-top: 16px;
  padding: 14px;
  border: none;
  border-radius: 999px;
  background: linear-gradient(135deg, #f59e0b, #f97316);
  color: #ffffff;
  font-size: 15px;
  font-weight: 600;
  cursor: pointer;
  transition: transform 0.2s ease, box-shadow 0.2s ease;
}

.novo-autor button:hover {
  transform: translateY(-2px);
  box-shadow: 0 10px 20px rgba(249, 115, 22, 0.3);
}

.novo-autor button:active {
  transform: translateY(0);
  box-shadow: none;
}
.novo-autor::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 16px;
  background: repeating-linear-gradient(
    90deg,
    #fcd34d,
    #fcd34d 16px,
    #fde68a 16px,
    #fde68a 32px
  );
}

/* RESPONSIVIDADE */
@media (max-width: 480px) {
  .novo-autor h1 {
    font-size: 32px;
  }

  .novo-autor form {
    padding: 28px;
  }
}

@media (max-width: 360px) {
  .novo-autor h1 {
    font-size: 28px;
  }

  .novo-autor form {
    padding: 22px;
  }
}

</style>