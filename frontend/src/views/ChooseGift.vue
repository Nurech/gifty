<template>
  <div align="center" class="table">
    <br>
    <h3>Choose gift to make</h3>
    <br>
    <table>
      <thead>
      <th>Nr</th>
      <th>Gift title</th>
      <th>Description</th>
      <th></th>
      </thead>
      <tbody>
      <tr v-for="(item, index) in tableRows" :item="item.gift_id">
        <td>{{ item.nr }}</td>
        <td>{{ item.gift_title }}</td>
        <td>{{ item.gift_description }}</td>
        <td>
          <button @click='selTableRow(item.gift_id)'>Select</button>
        </td>
      </tr>
      </tbody>
    </table>

    <br>
    {{ infoks }}
      <br>
       <button @click='dataToTable'>Täida tabel</button>
    <br>
    {{ infoks2 }}
    <br>
  </div>
</template>
<script type="text/javascript">
import {get, post} from "axios";

export default {
  data: function () {

    return {
      'nr': "",
      'gift_title': "",
      'gift_description': "",
      'infoks': { "gifts": [ { "gift_id": "1", "gift_title": "Suur punane auto", "gift_amount": "2", "gift_description": "See kingitus on väga äge kingitus" },
          { "gift_id": "5", "gift_title": "Väike roosa maja", "gift_amount": "1", "gift_description": "See kingitus on veel ägedam kingitus" }] },
      'tableRows': [],
      'infoks2': ""
    }
  },
  methods: {
    async dataToTable () {
     /* get('/api/gift/', this.tableRows
      )
          .then((response) => {
            this.user.id = response.data;
            console.log('Gift has chosen ' + response.data);
            this.showResponse = true
          }).catch((error) => {
        this.errors = error.response.data.message;
      });*/
      this.tableRows = this.infoks.gifts;
           },

    selTableRow: function (id) {
      let result = {
        'gift_id':id
         }
      post('/api/gift_was_chosen/', result);
      this.infoks2 = "Valiti kingitus, mille ID on " + id;

    }
  }
};

let i = 0;
function getOne(number) {
  let result = i + number;
  i++;
  return result;
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>

body {
  background: lightpink; /* fallback for old browsers */
}
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

table, th, td {
  border: 1px solid black;
}
table {
  border-collapse: collapse;
  margin: auto;
  width: 50%;
  border: 3px solid black;
  padding: 50px;
}
</style>