<template>
  <div class="gifts">

    <h3>Event owner gift wishlist</h3>

    <input type="text" v-model="gift.giftTitle" placeholder="Gift title">
    <input type="text" v-model="gift.giftAmount" placeholder="Gift amount">

    <br>
    <button @click="saveDB()">Save giftlist to DB</button>
    <br><br>


    <div id="content-editable-table" class="container">
      <h1>Event owner gift wishlist</h1>
      <table class="table table-striped editable-table">
        <thead>
        <th>Id</th>
        <th>Gift name</th>
        <th>Gift amount</th>
        <th>Gift description</th>
        </thead>

        <tbody>
        <tr v-for="row in table.tbody" >
          <td v-for="(value, index) in row">
            <input type="text" v-model="row[index]" />
          </td>
        </tr>
        <tr>
          <td  v-bind:colspan="table.thead.length + 1">
            <button class="btn btn-primary" type="button" v-on:click="addRow()" title="Add Row">+ Add row</button>
          </td>
        </tr>
        </tbody>
      </table>

      <pre class="output">
    {{tableJSON}}
  </pre>
    </div>

  </div>
</template>

<script>

import {post} from 'axios';

export default {
  name: 'GiftList',

  data: function () {
    return {
      tableJSON: '',
      table: {
        thead: [
          'id',
          'giftName',
          'giftAmount',
          'description'
        ],
        tbody: [
          ['1', 'Book', '3', 'I used to read a lot of crime/mystery books'],
          ['2', 'Gift Card', '2', 'I really enjoy The Mall, so would be nice to get some gift cards'],

        ],
      },

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

  mounted: function() {
    let _this = this;
    _this.updateTableJSON();

    $('#content-editable-table').on('change', '[type="text"]', function() {
      _this.updateTableJSON();
    });
  },

  methods: {

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

    updateTableJSON: function() {
      this.tableJSON = JSON.stringify(this.table);
    },

    addRow: function() {
      let newRow = [];
      let i = 0, length = this.table.thead.length;
      for(; i < length; i++) {
        newRow.push('R:' + (this.table.tbody.length + 1) + ' V:' + (i + 1))
      }
      this.table.tbody.push(newRow);
      this.updateTableJSON();
    }
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