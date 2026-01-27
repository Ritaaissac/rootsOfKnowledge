<template>
  <div class="page-container">
    <header class="header">
      <h1>BIBLIOTECA RAÍZES DO SABER</h1>
    </header>

    <!-- Faixa decorativa estilo xilogravura -->
    <div class="faixa"></div>

    <div class="content">
      <div class="form-card">
        <h2>Adicionar Gênero</h2>
        <p class="subtitle">Cadastre um novo gênero literário para a biblioteca.</p>

        <form @submit.prevent="salvarGenero">
          <div class="field full">
            <label>Nome do Gênero</label>
            <input v-model="genero.nome" type="text" placeholder="Ex: Romance" />
          </div>

          <div class="field full">
            <label>Descrição (Opcional)</label>
            <textarea
              v-model="genero.descricao"
              placeholder="Descreva brevemente o gênero..."
            ></textarea>
          </div>

          <button type="submit">Salvar Gênero</button>
        </form>
      </div>

      <div class="mascote-container">
        <img src="/img/cacto.png" alt="Mascote cacto" class="mascote" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AdicionarGenero",
  data() {
    return {
      genero: {
        nome: "",
        descricao: "",
      },
    };
  },
  methods: {
    salvarGenero() {
      console.log("Gênero salvo:", this.genero);
      alert("Gênero cadastrado com sucesso!");
    },
  },
};
</script>

<style scoped>
/* ---------------------------- */
/* FUNDO E ESTRUTURA GERAL      */
/* ---------------------------- */
.page-container {
  background: linear-gradient(to bottom, #f9eedf, #f3e3ce);
  min-height: 100vh;
  font-family: "Poppins", sans-serif;
  color: #5c3d2e;
}

.header {
  background: linear-gradient(90deg, #f4c542, #f29f32);
  padding: 25px;
  text-align: center;
  font-weight: 700;
  font-size: 30px;
  color: #5c3d2e;
  letter-spacing: 2px;
}

/* Faixa decorativa nordestina */
.faixa {
  width: 100%;
  height: 16px;
  background-image: repeating-linear-gradient(
    90deg,
    #f4c542 0 22px,
    #e39b27 22px 44px
  );
}

/* ---------------------------- */
/* LAYOUT                       */
/* ---------------------------- */
.content {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 40px;
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

/* BOTÃO */
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

/* ---------------------------- */
/* MASCOTE                      */
/* ---------------------------- */

.mascote-container {
  display: flex;
  justify-content: center;
  align-items: center;
}

.mascote {
  width: 400px;
  height: auto;
  animation: mascoteAnim 2.8s ease-in-out infinite;
}

/* Animação do mascote — braço e livro mexendo */
@keyframes mascoteAnim {
  0% {
    transform: rotate(0deg) translateY(0);
  }
  25% {
    transform: rotate(2deg) translateY(-4px);
  }
  50% {
    transform: rotate(0deg) translateY(0);
  }
  75% {
    transform: rotate(-2deg) translateY(-3px);
  }
  100% {
    transform: rotate(0deg) translateY(0);
  }
}

/* Fade-in suave */
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
</style>
