<template>
  <div class="event" align="center">


    <!--    //Event-->
    <h1>Create event page</h1>

    <input v-model="event.eventName" placeholder="Event name"/>
    <input v-model="event.eventDescription" placeholder="Description">
    <input v-model="event.eventDate" placeholder="Event date"/>
    <input v-model="event.eventAuthor" placeholder="Event author"/>
    <br>
    <button v-on:click="eventCreator()">Create Event</button>
    <div v-if="showResponse"><h6>You created new event with Id: {{ event.id }}</h6></div>


    <!--//giftList-->
    <br>
    <h3>Add your gifts</h3>
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
    <!--    {{ infoks }}-->
    <br>
    <button @click='addTableRow()'>Add New Row</button>


    <!--    //Invite-->
    <br>
    <h3>Add your participants</h3>
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
        <td>{{ item.userId }}</td>
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
    <!--    {{ infoks1 }}-->
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
      'tableRows1': [{userId: getRandom(6), role1: "owner"}],
      'tableRows': [{nr: getOne(1)}],

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


    }
  },


  methods: {

    'eventCreator': function () {
      post('/api/creator/', {
        event: {
          eventId: getRandom(6),
          eventName: this.event.eventName,
          eventDescription: this.event.eventDescription,
          eventDate: this.event.eventDate,
          eventAuthor: this.event.eventAuthor
        },
        gifts: this.tableRows,

        users: this.tableRows1,

        roles: {
          userId: this.userId,
          eventId: this.eventId,
          role: this.role
        }
      })
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
    addUserTableRow: function () {
      this.userId = getRandom(6);
      this.guestName = "";
      this.role1 = "user";
      this.email1 = "";
      this.generateLink1 = "";
      this.deleteButton1 = "";
      let my_objects1 = {
        userId: this.userId,
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
  let random = '0123456789';
  let result = "";
  for (let i = 0; i < length; i++) {
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
/*// button design proovisin kujundust muutke kui tahate*/
/*button {*/
/*  width: 200px;*/
/*  height: 50px;*/
/*  padding: 10px 0;*/
/*  text-align: center;*/
/*  margin: 10px 20px;*/
/*  border-radius: 50px;*/
/*  font-weight: bold;*/
/*  border: 3px solid #113270;*/
/*  background: #eea15e;*/
/*  color: #000099;*/
/*  cursor: pointer;*/
/*  position: relative;*/
/*}*/
/*button:hover {*/
/*  color: #ffffff;*/
/*}*/

/*table{*/
/*  font-family: 'Times New Roman'*/
/*  , Times*/
/*  , serif;*/
/*  -webkit-font-smoothing: antialiased;*/
/*  -moz-osx-font-smoothing: grayscale;*/
/*  color: #0d0b0c;*/
/*  margin: 25px auto 0;*/
/*  width: 500px;*/
/*  background-color: #5490d1*/
/*}*/

/*body {*/
/*  background: #dd3a12; !* fallback for old browsers *!*/
/*  background: -webkit-linear-gradient(to right, #44f81c, #b53030); !* Chrome 10-25, Safari 5.1-6 *!*/
/*  background: linear-gradient(to right, #47f805, #a02318); !* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ *!*/
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















