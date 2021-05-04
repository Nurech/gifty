<template>
  <div class="gifts">

    <h3>Event owner gift wishlist</h3>

    <input type="text" v-model="gift.giftTitle" placeholder="Gift title">
    <input type="text" v-model="gift.giftAmount" placeholder="Gift amount">

    <br>
    <button @click="saveDB()">Save giftlist to DB</button>
    <br><br>

    <table border="1">

      <thead>
      <th>Nr</th>
      <th>Gift title</th>
      <th>Gift amount</th>
      <th></th>
      </thead>

      <tbody>
      <tr v-for="(item, index) in tableRows" :item="item">
        <td>{{ item.guestName }}</td>
        <td>{{ item.role }}</td>
        <td>{{ item.email }}</td>
        <td>
          <button @click='delTableRow(index)'>Remove</button>
        </td>

      </tr>
      </tbody>
    </table>
    <button @click='addTableRow()'>Add another gift</button>


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
        number: "",
        id: 0,
        giftTitle: '',
        giftAmount: 0,
        eventId: '',
      }
    }
  },

  methods: {
    addTableRow: function () {
      let my_objects = {
        guestName: this.guestName,
        role: this.role,
        email: this.email,
        generateLink: this.generateLink,
        deleteButton: this.deleteButton
      };
      this.tableRows.push(my_objects);
      this.guestName = "Guest " + this.tableRows.length;
      this.role = "";
      this.email = "";
      this.generateLink = "";
      this.deleteButton = "";
    },
    delTableRow: function (id) {
      this.tableRows.splice(id, 1);
    },

    "saveDB": function () {
      post('/api/gift/', {
        giftTitle: this.gift.giftTitle,
        giftAmount: this.gift.giftAmount,
        eventId: "123-123-123"
      })
          .then((response) => {
            this.gift = response.data;
            console.log('Added gift ' + response.data);
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