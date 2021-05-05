<template>
  <div class="event2" align="center">

    <!--    //Event-->


    <h1>Create event page</h1>

    <input v-model="event.eventName" placeholder="Event name"/>
    <input v-model="event.eventDescription" placeholder="Description">
    <input v-model="event.eventDate" placeholder="Event date"/>
    <input v-model="event.eventAuthor" placeholder="Event author"/>

    <button v-on:click="createEvent()">Create Event</button>
    <div v-if="showResponse"><h6>You created new event with Id: {{ event.id }}</h6></div>


    <!--    //Invite-->


    <br>
    <h3>Add your participants</h3>
    <button v-on:click="testButton1()">TEST</button>
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
      <tr v-for="(item, index) in tableRows1" :item="item">
        <td>{{ item.guestId1 }}</td>
        <td><input v-model="item.guestName1" placeholder="Guest name"/></td>
        <td>{{ item.role1 }}</td>
        <td><input v-model="item.email1" placeholder="E-mail"/></td>
        <td>{{ item.generateLink1 }}</td>
        <td>
          <button @click='delTableRow1(index)'>Remove</button>
        </td>
      </tr>
      </tbody>
    </table>
    <br>
    {{ infoks1 }}
    <br>
    <button @click='addTableRow1()'>Add New Row</button>


    <!--//giftList-->


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

<script>


// Event


import {post} from "axios";

export default {
  name: "EventBody",

  data: function () {

    return {
      showResponse: false,
      event: {
        id: '',
        eventName: '',
        eventDescription: '',
        eventDate: '',
        eventAuthor: '',
      },
      'guestId1': "",
      'guestName1': "",
      'role1': "",
      'email1': "",
      'generateLink1': "",
      'deleteButton1': "",
      'randomNumber1': "",
      'tableRows1': [{guestId1: getRandom(6), role: "owner1"}],
      'infoks1': "Infopunkt1",

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

    'createEvent': function () {
      post('/api/event/', {
        id: getRandom(6),
        eventName: this.event.eventName, //button activate
        eventDescription: this.event.eventDescription,
        eventDate: this.event.eventDate,
        eventAuthor: this.event.eventAuthor,
      })
          .then((response) => {
            this.event = response.data;
            console.log('Created new event with Id ' + response.data);
            this.showResponse = true
          }).catch((error) => {
        this.errors = error.response.data.message;
      })
    },

    'testButton1': function () {
      post('/api/user/', this.tableRows1
      ),
          this.infoks = this.tableRows1;
    },


    addTableRow1: function () {
      this.guestId1 = getRandom(6);
      this.guestName1 = "";
      this.role1 = "user";
      this.email1 = "";
      this.generateLink1 = "";
      this.deleteButton1 = "";
      let my_objects1 = {
        guestId1: this.guestId1,
        guestName1: this.guestName1,
        role1: this.role1,
        email1: this.email1,
        generateLink1: this.generateLink1,
        deleteButton1: this.deleteButton1
      };
      this.tableRows1.push(my_objects1);
    },
    delTableRow1: function (id) {
      this.tableRows1.splice(id, 1);
    },


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


function getRandom(length) {
  var random = '0123456789';
  var result = "";
  for (var i = 0; i < length; i++) {
    result += random.charAt(Math.floor(Math.random() * random.length));
  }

  return result;
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















