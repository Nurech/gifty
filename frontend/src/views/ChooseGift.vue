<template>
  <div align="center" class="table">
    <br>
    <h1> {{ eventInfo }}</h1>
    <br>
    <i> {{ eventDescription }}</i>
    <br>
    {{testInfo}}
    <h3>Please choose a gift to make</h3>
    <br>
    <v-table
        class="table-hover"
        :data="tableRows"
        selection-mode="single"
        selectedClass="table-info"
        @selectionChanged="selectedRow = $event"
    >
      <thead slot="head">
      <th>Nr</th>
      <th>Gift title</th>
      <th>Description</th>
      </thead>
      <tbody slot="body" slot-scope="{displayData}">
      <v-tr v-for="row in displayData" :key="row.giftId" :row="row">
        <td>{{ row.giftId }}</td>
        <td>{{ row.giftTitle }}</td>
        <td>{{ row.giftDescription }}</td>
      </v-tr>
      </tbody>
    </v-table>
    <br>
    <br>
    <br>
    <br>
    {{ infoks2 }}
    <br>
    {{ selectedRow }}
    <br>
  </div>
</template>
<script type="text/javascript">
import {get, post} from "axios";

export default {
  data: function () {
    return {
      testInfo: {},
      tableRows: [],
      infoks2: "",
      selectedRow: "",
      eventDescription: "",
      eventInfo: ""
    }
  },
  methods: {
    selTableRow: function (id) {
      let result = {
        'gift_id': id
      }
      post('/api/gift_was_chosen/', result);
      this.infoks2 = "Valiti kingitus, mille ID on " + id;
      this.selectedRow = id;
    }
  },

  mounted() {

    get('api/event/032860/user/682679')
        .then((response) => {
              this.testInfo = response.data;
              this.tableRows = response.data.gifts;
              this.selectedRow = this.tableRows.length;
            }
        ).catch((error) => {
      this.errors = error.response.data.message;
    });


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
  background: navajowhite; /* fallback for old browsers */
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
  color: darkseagreen;
}

table, th, td {
  border: 1px solid black;
}

/*table, tr:hover td {
  background-color: lightseagreen !important;
}*/

table {
  border-collapse: collapse;
  margin: auto;
  width: 40%;
  border: 3px solid black;
  padding: 50px;
}

th {
  color: black;
}

</style>