<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld/>
    <Invite/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import Invite from "@/components/Invite";

export default {
  name: 'Home',
  components: {
    Invite,
    HelloWorld
  }
}
</script>
