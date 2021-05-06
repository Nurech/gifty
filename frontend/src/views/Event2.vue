<template>
  <div class="event" align="center">


    <!--    //Event-->
    <h1>Create event page</h1>

    <input v-model="event.eventName" placeholder="Event name"/>
    <input v-model="event.eventDescription" placeholder="Description">
    <input v-model="event.eventDate" placeholder="Event date"/>
    <input v-model="event.eventAuthor" placeholder="Event author"/>

    <button v-on:click="createEvent()">Create Event old</button>
    <button v-on:click="eventCreator()">Create Event</button>
    <div v-if="showResponse"><h6>You created new event with Id: {{ event.id }}</h6></div>


    <!--//giftList-->
    <br>
    <h3>Add your gifts</h3>
    <button v-on:click="postGiftList()">TEST</button>
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


    <!--    //Invite-->
    <br>
    <h3>Add your participants</h3>
    <button v-on:click="postUserList()">TEST</button>
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
      <tr v-for="(item, index1) in tableRows1" :item="item">
        <td>{{ item.guestId }}</td>
        <td><input v-model="item.guestName" placeholder="Guest name"/></td>
        <td>{{ item.role1 }}</td>
        <td><input v-model="item.email1" placeholder="E-mail"/></td>
        <td>{{ item.generateLink1 }}</td>
        <td>
          <button @click='delUserTableRow(index1)'>Remove</button>
        </td>
      </tr>
      </tbody>
    </table>
    <br>
    {{ infoks1 }}
    <br>
    <button @click='addUserTableRow()'>Add New Row</button>


  </div>
</template>

<script>

import {post} from "axios";

export default {
  name: "Event2",

  data: function () {

    return {
      showResponse: false,

      aadTableRows:{

      },

      CreateEvent: {
        eventId: '',
        eventName: '',
        eventDescription: '',
        eventDate: '',
        eventAuthor: '',

        giftId: '',
        giftTitle: '',
        giftAmount: '',
        giftDescription: '',

        userId: '',
        guestName: '',
        username: '',
        password: '',
        firstName: '',
        lastName: '',
        email: '',

      },

      event: {
        id: '',
        eventName: '',
        eventDescription: '',
        eventDate: '',
        eventAuthor: '',
      },
// user
      'guestId': "",
      'guestName': "",
      'email1': "",
      'generateLink1': "",
      'deleteButton1': "",
      'randomNumber1': "",
      'tableRows1': [{guestId: getRandom(6), role1: "owner"}],
      'infoks1': "Infopunkt1",
// gift
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

    'eventCreator': function () {
      post('/api/creator/', {

        eventId: getRandom(6),
        eventName: this.event.eventName,
        eventDescription: this.event.eventDescription,
        eventDate: this.event.eventDate,
        eventAuthor: this.event.eventAuthor,

        giftId: getOne(1),
        giftTitle: this.giftTitle,
        giftAmount: this.giftAmount,
        giftDescription: this.giftDescription,

        userId: getRandom(6),
        guestName: this.guestName,
        username:  this.role1 = "user",
        password: this.password,
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email1,


      })
    },


    // EVENT
    'createEvent': function () {
      post('/api/event/', {
        eventId: getRandom(6),
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


    // GIFT
    postGiftList: function () {
      post('/api/gift/', this.tableRows
      )
          .then((response) => {
            this.showResponse = true
          }).catch((error) => {
        this.errors = error.response.data.message;
      });
      this.infoks = this.tableRows;
    },


    // GIFT
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
    },


    // USER
    postUserList: function () {
      post('/api/user/', this.tableRows1
      ),
          this.infoks1 = this.tableRows1;
    },

    // USER
    addUserTableRow: function () {
      this.guestId = getRandom(6);
      this.guestName = "";
      this.role1 = "user";
      this.email1 = "";
      this.generateLink1 = "";
      this.deleteButton1 = "";
      let my_objects1 = {
        guestId: this.guestId,
        guestName: this.guestName,
        role1: this.role1,
        email1: this.email1,
        generateLink1: this.generateLink1,
        deleteButton1: this.deleteButton1
      };
      this.tableRows1.push(my_objects1);
    },

    delUserTableRow: function (id) {
      this.tableRows1.splice(id, 1);
    }
  }
}

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
/*// button design muutke kui tahate*/
/*button {*/
/*  width: 200px;*/
/*  height: 50px;*/
/*  padding: 10px 0;*/
/*  text-align: center;*/
/*  margin: 10px 20px;*/
/*  border-radius: 50px;*/
/*  font-weight: bold;*/
/*  border: 3px solid #113270;*/
/*  background: #5fcabf;*/
/*  color: #000099;*/
/*  cursor: pointer;*/
/*  position: relative;*/
/*}*/

/*button:hover {*/
/*  color: #ffffff;*/
/*}*/


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















