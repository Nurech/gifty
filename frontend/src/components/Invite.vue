<template>
  <div class="user">

    <h1>Invite</h1>
    <h3>invite</h3>
  </div>
</template>
<script>

import {post} from 'axios';

export default {
  name: 'Invite',

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
}
};
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
