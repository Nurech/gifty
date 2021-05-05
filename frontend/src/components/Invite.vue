<template>
  <div class="invite">
    <br>
    <h3>Add your participants</h3>
    <button v-on:click="testButton()">TEST</button>
    <br>
    <br>
    <table border="1">
      <thead>
      <th>Guest id</th>
      <th>Guest name</th>
      <th>Role</th>
      <th>E-mail</th>
      <th>Link</th>
      <th></th>
      </thead>
      <tbody>
      <tr v-for="(item, index) in tableRows" :item="item">
        <td>{{ item.userId }}</td>
        <td><input v-model="item.guestName" placeholder="Guest name"/></td>
        <td>{{ item.role }}</td>
        <td><input v-model="item.email" placeholder="E-mail"/></td>
        <td>{{ item.generateLink }}</td>
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
      'userId': "",
      'guestName': "",
      'role': "",
      'email': "",
      'generateLink': "",
      'deleteButton': "",
      'randomNumber': "",
      'tableRows': [{userId: getRandom(6), role: "owner"}],
      'infoks': "Infopunkt"
    }
  },
  methods: {
    'testButton': function () {
      post('/api/user/', this.tableRows
      ),
          this.infoks = this.tableRows;
    },
    addTableRow: function () {
      this.userId = getRandom(6);
      this.guestName = "";
      this.role = "user";
      this.email = "";
      this.generateLink = "";
      this.deleteButton = "";
      let my_objects = {
        userId: this.userId,
        guestName: this.guestName,
        role: this.role,
        email: this.email,
        generateLink: this.generateLink,
        deleteButton: this.deleteButton
      };
      this.tableRows.push(my_objects);
    },
    delTableRow: function (id) {
      this.tableRows.splice(id, 1);
    }
  }
};

function getRandom(length) {
  var random = '0123456789';
  var result = "";
  for (var i = 0; i < length; i++) {
    result += random.charAt(Math.floor(Math.random() * random.length));
  }
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