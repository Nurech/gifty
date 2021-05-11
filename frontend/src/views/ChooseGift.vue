<template>
  <div align="center" class="table">
    <br>
    <h1> {{ testInfo }}</h1>
    <br>
    <i> {{ eventDescription }}</i>
    <br>
    <h3>Please choose a gift to make</h3>
    <br>
    <table>
      <thead>
      <th>Nr</th>
      <th>Gift title</th>
      <th>Description</th>
      <th></th>
      </thead>
      <tbody>
      <tr v-for="(item, index) in testInfo.gifts" :item="item.gift_id">
        <td>{{ item.giftId }}</td>
        <td>{{ item.giftTitle }}</td>
        <td>{{ item.giftDescription }}</td>
        <td>
          <button @click='selTableRow(item.gift_id)'>Select</button>
        </td>
      </tr>
      </tbody>
    </table>
    <br>
    <!--    {{ infoks }}-->
    <br>
    <br>
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
      testInfo: {}
    }
  },

  methods: {
    selTableRow: function (id) {
      let result = {
        'gift_id': id
      }
      post('/api/gift_was_chosen/', result);
      this.infoks2 = "Valiti kingitus, mille ID on " + id;
    }
  },

  mounted() {

    // get url, insert two variables this.$route. (pathvariable)

    //TODO
     get('api/event/225767/user/453645')
         .then((response) => {
           this.testInfo = response.data;
           this.event = response.data;
           this.showResponse = true
         }).catch((error) => {
       this.errors = error.response.data.message;
     });

    this.tableRows = response.gifts;
    this.eventInfo = "Welcome to choose gift for " + this.event_author + "´s " + this.event_date + " " + this.event_name;
    this.eventDescription = this.event_description;
  }
};

let pathArray = window.location.pathname.split('/');
let secondLevelLocation = pathArray[4];
let newPathname = "";
for (i = 0; i < pathArray.length; i++) {
  newPathname += "/";
  newPathname += pathArray[i];
}


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
  width: 40%;
  border: 3px solid black;
  padding: 50px;
}
</style>