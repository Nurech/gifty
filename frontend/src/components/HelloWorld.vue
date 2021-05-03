<template>
  <div class="user">
    <h1>{{ msg }}</h1>
    <h1>Create User</h1>

    <h3>Just some database interaction...123456</h3>

    <input type="text" v-model="user.firstName" placeholder="first name">
    <input type="text" v-model="user.lastName" placeholder="last name">

    <button @click="createNewUser()">Create User</button>

    <div v-if="showResponse"><h6>User created with Id: {{ user.id }}</h6></div>

    <button v-if="showResponse" @click="retrieveUser()">Retrieve user {{ user.id }} data from database</button>

    <h4 v-if="showRetrievedUser">Retrieved User {{ retrievedUser.firstName }} {{ retrievedUser.lastName }}</h4>
  </div>

</template>
aita veaga
<script>

import {post} from 'axios';

export default {
  name: 'HelloWorld',

  data: function () {
    return {
      errors: [],
      showResponse: false,
      showRetrievedUser: false,

      user: {
        id: 0,
        firstName: '',
        lastName: ''
      },

      retrievedUser: {
        id: 0,
        firstName: '',
        lastName: ''
      }
    }
  },

  methods: {

    "createNewUser": function () {
      post('/api/user/', {
        firstName: this.user.firstName,
        lastName: this.user.lastName
      })
          .then((response) => {
            this.user.id = response.data;
            console.log('Created new User with Id ' + response.data);
            this.showResponse = true
          }).catch((error) => {
        this.errors = error.response.data.message;
      });
    },
}
}
;
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
