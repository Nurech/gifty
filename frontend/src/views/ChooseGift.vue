<template>
  <div class="event" align="center"
       :style="{ backgroundImage: 'url(https://static-cdn.drawnames.com/Content/Assets/deco-sending.svg?nc=201910281040)' }">
    <div class="container" style="opacity: 0.88">
      <div class="shadow-lg p-3 mb-5 bg-body rounded">
        <br>
        <h1><strong>Welcome to choose the gift</strong></h1>
        <i> {{ eventDescription }}</i>
        <img src="https://i.gifer.com/KH8E.gif" class="gif">
        <br>
        <div v-if="showResponse === false">
           <br>
          <v-table
              class="table table-bordered"
              :data="tableRows"
              selection-mode="single"
              selectedClass="table-selected"
              @selectionChanged="selectedRow = $event">
            <thead slot="head" align="center">
            <th>#</th>
            <th>Gift title</th>
            <th>Description</th>
            </thead>
            <tbody slot="body" slot-scope="{displayData}">
            <v-tr v-for="(row, index) in displayData" :key="row.giftId" :row="row">
              <td>{{ index + 1 }}</td>
              <td>{{ row.giftTitle }}</td>
              <td>{{ row.giftDescription }}</td>
            </v-tr>
            </tbody>
          </v-table>
          <br>
          <div v-if="selectedRow.length > 0">
          <span v-for="selected in selectedRow" class="table_heading" style="font-weight: normal; color: forestgreen">You have selected to give as a <strong>gift
         {{ selected.giftTitle }}</strong>
          </span>

            <br><br>
            <button v-on:click="confirmButton()" class="btn btn-outline-success btn-lg btn-block"
                    :disabled="showResponse">Confirm gift
            </button>
          </div>
        </div>
        <br>
        <div v-if="showResponse">
          <div class="alert alert-success" role="alert">
            <h4 class="alert-heading">Thank You!<p>
              <p>You have chosen gift {{ selectedRow[0].giftTitle }}!</p></h4>
          </div>
        </div>
<!--        {{ infoks2 }}
        <br>
        {{ selectedRow }}<br>
        <br>
        Serverist: {{ testInfo }}-->
      </div>
    </div>
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
      selectedRow: [],
      eventDescription: "",
      eventInfo: "",
      chooseGift: {},
      showResponse: false
    }
  },
  methods: {
    confirmButton: function () {
      post('api/chooseGift', {
        userId: this.userId,
        eventId: this.eventId,
        itemNr: this.itemNr,
      });
      this.showResponse = true;
    },
  },

  mounted() {
    get('/api/event/' + this.$route.params.eventId + '/user/' + this.$route.params.userId)

        .then((response) => {
              this.testInfo = response.data;
              this.tableRows = response.data.gifts;
            }
        ).catch((error) => {
      this.errors = error.response.data.message;
    });


/*    this.eventInfo = "Welcome to choose gift for " + this.event_author + "´s " + this.event_date + " " + this.event_name;
    this.eventDescription = this.event_description;*/
  }
};

</script>
<style>

body {
  background: antiquewhite; /* fallback for old browsers */
  background: white(to right, white, white); /* Chrome 10-25, Safari 5.1-6 */
  background: white(to right, white, white); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  font-family: "Comic Sans MS", "Courier New", monospace;
}

h1 {
  font-weight: bold;
  font-family: "Comic Sans MS", "Courier New", monospace;
  font-size: 40px;
  color: hotpink;
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
  color: #163427;
}

th, td {
  background-color: white;
  color: black;
  text-align: center;
  padding: 0px;

}

.table_heading {
  font-weight: bold;
  color: black;
  font-size: 25px;
  font-style: normal;
  font-family: "Comic Sans MS", "Courier New", monospace;
}

.gif {
  height: 50%;
  width: auto;
  max-width: 200px;
  max-height: 200px;
}

tr:hover {
  background: ghostwhite;
}

.table-selected {
  background: #81ba86;
}
</style>