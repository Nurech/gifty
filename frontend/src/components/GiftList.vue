<template>
  <div class="gifts">

    <h3>Event owner gift wishlist</h3>

    <input type="text" v-model="gift.giftTitle" placeholder="Gift title">
    <input type="text" v-model="gift.giftAmount" placeholder="Gift amount">

    <br>
    <button @click="saveDB()">Save giftlist to DB</button>
    <br><br>


    <div id="content-editable-table" class="container">
      <h1>Editable Table to JSON with Vue.js</h1>
      <table class="table table-striped editable-table">
        <thead v-if="table.thead.length">
        <tr>
          <th v-for="(heading, index) in table.thead">
            <input type="text" v-model="table.thead[index]" />
          </th>

          <th>
            <button class="btn btn-primary" type="button" v-on:click="addColumn()" title="Add Column">+</button>
          </th>
        </tr>
        </thead>

        <tbody>
        <tr v-for="row in table.tbody">
          <td v-for="(value, index) in row">
            <input type="text" v-model="row[index]" />
          </td>
          <td>&nbsp;</td>
        </tr>

        <tr>
          <td  v-bind:colspan="table.thead.length + 1">
            <button class="btn btn-primary" type="button" v-on:click="addRow()" title="Add Row">+</button>
          </td>
        </tr>
        </tbody>

        <tfoot v-if="table.tfoot.length">
        <tr>
          <td v-for="(foot, index) in table.tfoot">
            <input type="text" v-model="table.tfoot[index]" />
          </td>
          <td>&nbsp;</td>
        </tr>
        </tfoot>
      </table>

      <pre class="output">
    {{tableJSON}}
  </pre>
    </div>

    <button @click='addTableRow()'>Add another gift</button>


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
          'Heading 1',
          'Heading 2',
          'Heading 3'
        ],
        tbody: [
          ['R:1 V:1', 'R:1 V:2', 'R:1 V:3'],
          ['R:2 V:1', 'R:2 V:2', 'R:2 V:3'],
          ['R:3 V:1', 'R:3 V:2', 'R:3 V:3']
        ],
        tfoot: [
          'Footer 1',
          'Footer 2',
          'Footer 3'
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

    addColumn: function() {
      this.table.thead.push('Heading ' + (this.table.thead.length + 1));
      let i = 0, length = this.table.tbody.length;
      for(; i < length; i++) {
        this.table.tbody[i].push('R:' + (i + 1) + ' V:' + this.table.thead.length);
      }
      this.table.tfoot.push('Footer ' + this.table.thead.length);
      this.updateTableJSON();
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