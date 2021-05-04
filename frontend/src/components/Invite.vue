<template>
  <div class="invite">

    <table border="1">
      <thead>
      <th>Guest name</th>
      <th>Role</th>
      <th>E-mail</th>
      <th>Link</th>
      <th></th>
      </thead>
      <tbody>
      <tr v-for="(item, index) in tableRows" :item="item">
        <td>{{ item.guestName }}</td>
        <td>{{ item.role }}</td>
        <td>{{ item.email }}</td>
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
      'guestName': "Guest Name",
      'role': "Owner",
      'email': "owner@owner.ee",
      'generateLink': "some URL",
      'deleteButton': "",
      'tableRows': []
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
    }
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
