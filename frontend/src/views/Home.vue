<template>
  <div class="home">

    <!-- HEADER -->
    <header class="header">
      <div class="logo">
        <span>BIBLIOTECA</span>
        <strong>RAÍZES DO SABER</strong>
      </div>
    </header>

    <!-- MAIN -->
    <main class="main">
      <section class="text">
        <span class="welcome">BEM-VINDO À</span>
        <h1>BIBLIOTECA<br />RAÍZES DO SABER</h1>
        <p>Descubra o Nordeste, uma terra de cores vibrantes, ritmos contagiantes e histórias de tirar o fôlego.</p>

        <!-- BOTÕES DE AÇÃO -->
        <div class="buttons-section">
          <div class="group">
            <button class="boton" @click="navigateTo('/novo-livro')">Novo Livro</button>
            <button class="boton" @click="navigateTo('/novo-autor')">Novo Autor</button>
            <button class="boton" @click="navigateTo('/novo-genero')">Novo Gênero</button>
          </div>

          <div class="group">
            <button class="boton" @click="navigateTo('/ver-genero')">Ver Gêneros</button>
          </div>
        </div>
      </section>

      <!-- IMAGEM DIREITA -->
      <section class="image">
        <img src="/img/nordeste.png" alt="Ilustração Nordeste" />
      </section>
    </main>

  </div>
</template>

<script>
export default {
  name: "Home",
  methods: {
    redirectToNovoLivro() {
      this.$router.push({ path: "/novo-livro" });
    },
    navigateTo(path) {
      this.$router.push({ path });
    },
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}

.home {
  background-color: #fff4e6;
  min-height: 100vh;
}

/* HEADER */
.header {
  padding: 24px 50px;
  background: #fff1db;
}

.logo span {
  display: block;
  font-size: 12px;
  letter-spacing: 2px;
  color: #2f6f4e;
}

.logo strong {
  font-size: 26px;
  color: #f97316;
}

/* MAIN LAYOUT */
.main {
  display: flex;
  height: calc(100vh - 120px);
}

/* TEXT LEFT SIDE */
.text {
  flex: 1;
  padding: 60px 40px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.welcome {
  font-size: 12px;
  letter-spacing: 3px;
  color: #2f6f4e;
}

.text h1 {
  font-size: 48px;
  color: #f97316;
  margin: 10px 0;
}

.text p {
  font-size: 14px;
  max-width: 400px;
}

/* MAIN BUTTON */
.boton-main {
  margin-top: 20px;
  padding: 12px 30px;
  background: linear-gradient(135deg, #f97316, #f59e0b);
  border: none;
  border-radius: 8px;
  color: white;
  font-weight: 600;
  cursor: pointer;
  font-size: 14px;
}

/* ACTION BUTTONS */
.buttons-section {
  margin-top: 40px;
}

.group {
  display: flex;
  gap: 12px;
  margin-bottom: 15px;
}

.boton {
  padding: 15px 20px;
  background: linear-gradient(135deg, #f97316, #f59e0b);
  border: none;
  border-radius: 8px;
  color: white;
  font-size: 12px;
  font-weight: 600;
  cursor: pointer;
  width: 100px;
}

/* IMAGE RIGHT SIDE */
.image {
  flex: 1;
  background: linear-gradient(135deg, #f97316, #f59e0b);
  display: flex;
  justify-content: center;
  align-items: center;
}

.image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>
