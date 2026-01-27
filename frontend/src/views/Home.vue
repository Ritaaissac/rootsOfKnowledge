<template>
  <div class="home">

    <!-- HEADER -->
    <header class="header">
      <div class="logo">
        <span>BIBLIOTECA </span>
        <strong>RAÍZES</strong>
        <strong>DO SABER</strong>
      </div>

    </header>

    <!-- DECORATIVE STRIP -->
    <div class="strip"></div>

    <!-- MAIN -->
    <main class="main">
      <section class="text">
        <span class="welcome">BEM-VINDO À</span>
        <h1>BIBLIOTECA<br /> RAÍZES DO <br  /> SABER</h1>
        <p>
          Descubra o Nordeste, uma terra de cores vibrantes,
          ritmos contagiantes e histórias de tirar o fôlego.
        </p>
        <button>Vamos lá!</button>
      </section>

      <section class="image">
        <img src="/img/nordeste.png" alt="Ilustração Nordeste" />
      </section>
    </main>

  </div>
</template>

<script>
export default {
  name: 'Home'
}
</script>

<style scoped>
* {
  box-sizing: border-box;
  font-family: 'Poppins', sans-serif;
}

.home {
  background-color: #fff4e6;
  color: #3a3a3a;
  min-height: 100vh;
}

/* HEADER */
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 24px 60px;
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

.nav a {
  margin-left: 32px;
  text-decoration: none;
  color: #555;
  font-size: 14px;
}

/* STRIP */
.strip {
  height: 18px;
  background: repeating-linear-gradient(
    90deg,
    #fcd34d,
    #fcd34d 16px,
    #fde68a 16px,
    #fde68a 32px
  );
}

/* MAIN */
.main {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 80px 60px;
  gap: 60px;
}

/* TEXT */
.text {
  max-width: 480px;
}

.welcome {
  font-size: 12px;
  letter-spacing: 3px;
  color: #2f6f4e;
}

.text h1 {
  font-size: 52px;
  color: #f97316;
  line-height: 1.1;
  margin: 16px 0;
}

.text p {
  font-size: 15px;
  line-height: 1.6;
  margin-bottom: 24px;
  color: #555;
}

.text button {
  background: #f59e0b;
  color: white;
  border: none;
  padding: 12px 28px;
  border-radius: 999px;
  cursor: pointer;
  font-size: 14px;
}

/* IMAGE */
.image img {
  max-width: 520px;
  border-radius: 24px;
}
</style>
