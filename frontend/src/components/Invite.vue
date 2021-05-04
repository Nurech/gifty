<template>
  <div class="invite">
    <h3>Add your participants</h3>
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
        <td>{{ item.guestId }}</td>
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

  </div>
</template>
<script type="text/javascript">
export default {
  data: function () {
    return {
      'guestId': "",
      'guestName': "",
      'role': "",
      'email': "",
      'generateLink': "",
      'deleteButton': "",
      'randomNumber': "",
      'tableRows': [{}]
    }
  },
  methods: {
    "dbGuestId": function () {
      post('/api/user/', {
        guestName: this.guestId
      })
          .then((response) => {
            this.guestId = response.data
          })
    },
    addTableRow: function () {
      this.guestId = getRandom(6);
      this.guestName = "";
      this.role = "user";
      this.email = "";
      this.generateLink = "";
      this.deleteButton = "";
      let my_objects = {
        guestId: this.guestId,
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