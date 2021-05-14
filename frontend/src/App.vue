<template>
  <div id="app">
    <div id="nav">
      <router-link to="/createEvent">Create Gifter event</router-link> |
      <router-link to="/about">About Gifter</router-link>
    </div>
    <router-view></router-view>
  </div>
</template>

<style>
#app {
  font-family: "Comic Sans MS", Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background: antiquewhite; /* fallback for old browsers */
  background: antiquewhite(to right, white, antiquewhite); /* Chrome 10-25, Safari 5.1-6 */
  background: antiquewhite(to right, white, antiquewhite); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
a {
  font-weight: bold;
  color: #2c3e50;
}
}

#nav {
  padding: 30px;
  background: antiquewhite; /* fallback for old browsers */
  background: antiquewhite(to right, white, antiquewhite); /* Chrome 10-25, Safari 5.1-6 */
  background: antiquewhite(to right, white, antiquewhite); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  a {
    font-weight: bold;
    color: #2c3e50;
  }
}
</style>
