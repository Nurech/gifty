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
    <button @click='addTableRow()'>Add New Row</button>
    <br>
    {{ infovali }}
    <div class="wrapper">
      <h3>Message to be sent by e-mail:</h3>
      <ResizeAuto>
        <template v-slot:default="{resize}">
        <textarea
            class="textarea"
            @input="resize"
            placeholder="Please insert Your message to the gift choosers"
            v-model="messageEmail"
        ></textarea>
        </template>
      </ResizeAuto>
    </div>
  </div>
</template>
<script type="text/javascript">
import {post} from "axios";
import ResizeAuto from "./ResizeAuto";

export default {
  name: "App",
  components: {ResizeAuto},

  data: function () {
    return {
      'userId': "",
      'guestName': "",
      'role': "",
      'email': "",
      'generateLink': "",
      'deleteButton': "",
      'randomNumber': "",
      'messageEmail': "",
      'infovali': "",
      'tableRows': [{userId: getRandom(6), role: "owner"}]
    }
  },
  methods: {
    'testButton': function () {
      let result = {
        'message': this.messageEmail,
        'guests': this.tableRows
      }
      this.infovali = result;

      post('/api/user/', result
      )
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
  let random = '0123456789';
  let result = "";
  for (let i = 0; i < length; i++) {
    result += random.charAt(Math.floor(Math.random() * random.length));
  }
  return result;
}
</script>

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

wrapper {
  padding: 15px;
}

textarea {
  overflow-y: hidden;
  resize: both;
  margin: 0.5rem;
  padding: 0.5rem;
  border-color: #edf2f7;
  background-color: #edf2f7;
  border-width: 0.25rem;
  border-radius: 0.2rem;
  max-height: 18rem;
  min-width: 15rem;
  appearance: none;
}
</style>