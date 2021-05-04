<template>
  <div class="gifts">

    <h3>Event owner gift wishlist</h3>

    <input type="text" v-model="gift.giftTitle" placeholder="Gift title">
    <input type="text" v-model="gift.giftAmount" placeholder="Gift amount">

    <br>
    <button @click="addGift()">Add gift</button>
    <br>

  </div>
</template>

<script>

import {post} from 'axios';

export default {
  name: 'GiftList',

  data: function () {
    return {
      errors: [],
      showResponse: false,

      gift: {
        id: 0,
        giftTitle: '',
        giftAmount: 0,
        eventId: '',
      }
    }
  },

  methods: {
    "addGift": function () {
      post('/api/gift/', {
        giftTitle: this.gift.giftTitle,
        giftAmount: this.user.giftAmount,
        eventId: "123-123-123"
      })
          .then((response) => {
            this.gift = response.data;
            console.log('Created new User with Id ' + response.data);
            this.showResponse = true
          }).catch((error) => {
        this.errors = error.response.data.message;
      });
    },
  }
};

</script>

<style scoped>
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