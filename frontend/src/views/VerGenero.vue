<template>
  <div class="page-container">
    <header class="header">
      <h1>GÊNEROS CADASTRADOS</h1>
    </header>

    <div class="faixa"></div>

    <div class="content">
      <div class="list-section">
        <h2>Lista de Gêneros</h2>

        <!-- Campo de Busca -->
        <div class="search-box">
          <input
            type="text"
            v-model="busca"
            placeholder="Buscar gênero..."
          />
        </div>

        <!-- Lista -->
        <div class="generos-list">
          <div
            v-for="(g, index) in generosFiltrados"
            :key="index"
            class="genero-card"
          >
            <h3>{{ g.nome }}</h3>
            <p class="descricao">{{ g.descricao || "Sem descrição." }}</p>

            <div class="card-actions">
              <button class="edit">Editar</button>
              <button class="delete" @click="deletarGenero(index)">
                Excluir
              </button>
            </div>
          </div>
        </div>
      </div>

      <!-- Mascote -->
      <div class="mascote-container">
        <img src="/img/cacto.png" class="mascote" alt="cacto" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "VerGeneros",

  data() {
    return {
      busca: "",
      // Exemplo inicial (substituir pelo GET da API depois)
      generos: [
        { nome: "Romance", descricao: "Histórias que envolvem amor e emoção." },
        { nome: "Fantasia", descricao: "Universos mágicos e criaturas incríveis." },
        { nome: "Terror", descricao: "Histórias assustadoras e sombrias." }
      ]
    };
  },

  computed: {
    generosFiltrados() {
      return this.generos.filter(g =>
        g.nome.toLowerCase().includes(this.busca.toLowerCase())
      );
    }
  },

  methods: {
    deletarGenero(i) {
      if (confirm("Tem certeza que deseja excluir este gênero?")) {
        this.generos.splice(i, 1);
      }
    }
  }
};
</script>

<style scoped>
/* Fundo */
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
  font-size: 28px;
  color: #5c3d2e;
}

.faixa {
  width: 100%;
  height: 16px;
  background-image: repeating-linear-gradient(
    90deg,
    #f4c542 0 22px,
    #e39b27 22px 44px
  );
}

.content {
  display: flex;
  justify-content: center;
  align-items: flex-start;
  gap: 50px;
  padding: 40px;
}

/* Lista de gêneros */
.list-section {
  width: 550px;
  background: #fff7ec;
  padding: 30px;
  border-radius: 24px;
  border: 3px solid #f4c542;
  box-shadow: 0 6px 16px rgba(0, 0, 0, 0.15);
  animation: fade-in 0.4s ease;
}

.list-section h2 {
  color: #d94e1f;
  text-transform: uppercase;
  margin-bottom: 20px;
  font-size: 22px;
}

.search-box input {
  width: 100%;
  padding: 12px;
  border: 2px solid #f4c542;
  border-radius: 12px;
  margin-bottom: 20px;
  font-size: 16px;
}

/* Cards */
.generos-list {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.genero-card {
  background: #fff;
  border: 2px solid #f4c542;
  padding: 20px;
  border-radius: 18px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.12);
  transition: 0.25s;
  animation: fade-in 0.4s ease;
}

.genero-card:hover {
  transform: scale(1.02);
}

.genero-card h3 {
  font-size: 18px;
  color: #c64922;
}

.descricao {
  font-size: 14px;
  margin-top: 6px;
  opacity: 0.8;
}

.card-actions {
  display: flex;
  justify-content: flex-end;
  gap: 12px;
  margin-top: 15px;
}

button {
  padding: 8px 14px;
  border-radius: 10px;
  font-size: 14px;
  cursor: pointer;
  border: none;
  transition: 0.25s;
}

.edit {
  background: #f4c542;
  color: #5c3d2e;
}

.edit:hover {
  background: #d7a62b;
}

.delete {
  background: #e85a2a;
  color: white;
}

.delete:hover {
  background: #c64922;
}

/* Mascote */
.mascote-container {
  display: flex;
  justify-content: center;
  align-items: center;
}

.mascote {
  width: 310px;
  animation: mascoteAnim 2.8s ease-in-out infinite;
}

/* Mascote animado */
@keyframes mascoteAnim {
  0% {
    transform: rotate(0deg);
  }
  25% {
    transform: rotate(1.6deg);
  }
  50% {
    transform: rotate(0deg);
  }
  75% {
    transform: rotate(-1.8deg);
  }
  100% {
    transform: rotate(0deg);
  }
}

/* Fade-in */
@keyframes fade-in {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
  }
}
</style>
