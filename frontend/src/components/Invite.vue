<template>
  <div class="invite">

    <table>
      <tr>
        <th>Sample Table</th>
      </tr>
      <tr v-for="(content, index) in tableRows">
        <td>{{ content }}</td>
      </tr>
    </table>
    <br>

    <button @click='addTableRow()'>Add New Row</button>

  </div>
</template>
<script>

import {post} from 'axios';

export default {
  name: 'Invite',

  data: function () {
    return {}
  },

  methods: {
    addTableRow: function () {
      this.counter++;
      this.tableRows.push("Table Row " + this.counter);
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
