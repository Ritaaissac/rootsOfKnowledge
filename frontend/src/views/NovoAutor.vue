<template>
  <div class="page-container">
    <!-- TOPO -->
    <header class="topo">
      <div class="topo-texto">
        <span class="biblioteca">BIBLIOTECA</span>
        <h1>RAÍZES DO SABER</h1>
      </div>

      <div class="faixa-xilo"></div>
    </header>

    <!-- CONTEÚDO -->
    <div class="content">
      <div class="form-card">
        <h2>Novo Autor</h2>
        <p class="subtitle">
          Cadastre um novo autor para o acervo da biblioteca.
        </p>

        <form @submit.prevent="submitForm">
          <div class="field full">
            <label>Nome do Autor</label>
            <input
              v-model="autor.nome"
              type="text"
              placeholder="Ex: Ariano Suassuna"
              required
            />
          </div>

          <div class="field full">
            <label>Link do Portfólio</label>
            <textarea
              v-model="autor.portfolioAutor"
              placeholder="Ex: https://meuportfolio.com"
              required
            ></textarea>
          </div>

          <button type="submit">Salvar Autor</button>
        </form>
      </div>

      <!-- IMAGEM INSTITUCIONAL -->
      <div class="ilustracao-container">
        <img
          src="/img/pergaminho-pena.png"
          alt="Pergaminho com pena representando o saber"
          class="ilustracao"
        />
      </div>
    </div>
  </div>
</template>

<script>
import { createNovoAutor } from '@/actions/novoAutorActions';

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
        await createNovoAutor(this.autor);
        alert('Autor criado com sucesso!');
        this.autor.nome = '';
        this.autor.portfolioAutor = '';
      } catch (error) {
        console.error('Erro ao criar autor:', error);
        alert('Erro ao criar autor. Tente novamente.');
      }
    }
  }
};
</script>

<style scoped>
/* ---------------------------- */
/* BASE                         */
/* ---------------------------- */
* {
  box-sizing: border-box;
}

.page-container {
  background: linear-gradient(to bottom, #f9eedf, #f3e3ce);
  min-height: 100vh;
  font-family: "Poppins", sans-serif;
  color: #5c3d2e;
}

/* ---------------------------- */
/* TOPO                         */
/* ---------------------------- */
.topo {
  background: #fff3df;
  padding: 20px 40px 0;
}

.topo-texto {
  line-height: 1.1;
}

.biblioteca {
  font-size: 13px;
  letter-spacing: 4px;
  color: #2f6f4e;
  font-weight: 600;
}

.topo-texto h1 {
  margin: 6px 0 18px;
  font-size: 38px;
  color: #ff6a00;
  font-weight: 160;
}

/* ---------------------------- */
/* FAIXA DECORATIVA             */
/* ---------------------------- */
.faixa-xilo {
  height: 10px;
  max-width: 100%;

  background: repeating-linear-gradient(
    90deg,
    #ffe066 0 14px,
    #ffd43b 14px 28px,
    #ffec99 28px 42px
  );
}

/* ---------------------------- */
/* LAYOUT                       */
/* ---------------------------- */
.content {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 50px;
  gap: 60px;
}

/* ---------------------------- */
/* FORM CARD                    */
/* ---------------------------- */
.form-card {
  width: 480px;
  background: #fff7ec;
  padding: 35px;
  border-radius: 24px;
  border: 3px solid #f4c542;
  box-shadow: 0 6px 18px rgba(0, 0, 0, 0.18);
  animation: fade-in 0.5s ease;
}

h2 {
  color: #d94e1f;
  text-transform: uppercase;
  margin-bottom: 10px;
  font-size: 22px;
}

.subtitle {
  margin-bottom: 20px;
  font-size: 15px;
  opacity: 0.8;
}

form {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 20px;
}

.full {
  grid-column: span 2;
}

label {
  font-weight: 600;
}

input,
textarea {
  width: 100%;
  padding: 12px;
  border-radius: 12px;
  border: 2px solid #f4c542;
  background: #fff;
  margin-top: 6px;
  transition: 0.25s;
}

input:focus,
textarea:focus {
  border-color: #e85a2a;
  box-shadow: 0 0 6px rgba(232, 90, 42, 0.4);
}

textarea {
  resize: none;
  height: 120px;
}

/* ---------------------------- */
/* BOTÃO                        */
/* ---------------------------- */
button {
  grid-column: span 2;
  padding: 14px;
  font-size: 18px;
  background: #e85a2a;
  color: #fff;
  border: none;
  border-radius: 20px;
  cursor: pointer;
  transition: 0.3s;
  box-shadow: 0 6px 12px rgba(232, 90, 42, 0.3);
}

button:hover {
  background: #c64922;
  transform: scale(1.04);
}

/* ILUSTRAÇÃO  */
.ilustracao-container {
  display: flex;
  justify-content: center;
  align-items: center;
  background: transparent;
  mix-blend-mode: multiply;
}

.ilustracao {
  width: 500px;
  opacity: 0.95;
  filter: brightness(1.05) contrast(1.1);

}

/* ---------------------------- */
/* ANIMAÇÕES                    */
/* ---------------------------- */
@keyframes fade-in {
  from {
    opacity: 0;
    transform: translateY(25px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

/* ---------------------------- */
/* RESPONSIVO                   */
/* ---------------------------- */
@media (max-width: 900px) {
  .content {
    flex-direction: column;
  }

  .ilustracao {
    width: 200px;
  }
}
</style>
