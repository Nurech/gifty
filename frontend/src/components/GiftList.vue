<template>
  <div class="gifts">
    <br>
    <h3>Add your gifts</h3>
    <button v-on:click="testButton()">TEST</button>
    <br>
    <br>
    <table border="1" align="centre">
      <thead>
      <th>#</th>
      <th>Gift title</th>
      <th>How many</th>
      <th>Description</th>
      <th></th>
      </thead>
      <tbody>
      <tr v-for="(item, index) in tableRows" :item="item">
        <td>{{ item.nr }}</td>
        <td><input v-model="item.giftTitle" placeholder="Gift Title"/></td>
        <td><input v-model="item.giftAmount" placeholder="Amount"/></td>
        <td><input v-model="item.giftDescription" placeholder="Gift Description"/></td>
        <td>
          <button @click='delTableRow(index)'>Remove</button>
        </td>
      </tr>
      </tbody>
    </table>
    <br>
    {{ infoks }}
    <br>
    <button @click='addTableRow()'>Add New Row</button>

  </div>
</template>
<script type="text/javascript">
import {post} from "axios";

export default {
  data: function () {

    return {
      'nr': "",
      'giftTitle': "",
      'giftAmount': "",
      'email': "",
      'giftDescription': "",
      'deleteButton': "",
      'randomNumber': "",
      'tableRows': [{nr: getOne(1)}],
      'infoks': ""
    }
  },
  methods: {
    'testButton': function () {
      post('/api/gift/', this.tableRows
      )
          .then((response) => {
            this.user.id = response.data;
            console.log('Created new User with Id ' + response.data);
            this.showResponse = true
          }).catch((error) => {
        this.errors = error.response.data.message;
      });
      this.infoks = this.tableRows;
    },

    addTableRow: function () {
      this.nr = getOne(1);
      this.giftTitle = "";
      this.giftAmount = "";
      this.giftDescription = "";
      let my_objects = {
        nr: this.nr,
        giftTitle: this.giftTitle,
        giftAmount: this.giftAmount,
        giftDescription: this.giftDescription
      };
      this.tableRows.push(my_objects);
    },

    delTableRow: function (id) {
      this.tableRows.splice(id, 1);
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