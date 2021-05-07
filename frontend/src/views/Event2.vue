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
      <tr v-for="(item, gift_index) in giftRows" :item="item">
        <td>{{ item.nr }}</td>
        <td><input v-model="item.giftTitle" placeholder="Gift Title"/></td>
        <td><input v-model="item.giftAmount" placeholder="Amount"/></td>
        <td><input v-model="item.giftDescription" placeholder="Gift Description"/></td>
        <td>
          <button @click='delTableRow(gift_index)'>Remove</button>
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
      <tr v-for="(item, user_index) in userRows" :item="item">
        <td>{{ item.userId }}</td>
        <td><input v-model="item.guestName" placeholder="Guest name"/></td>
        <td>{{ item.role }}</td>
        <td><input v-model="item.email" placeholder="E-mail"/></td>
        <td>{{ item.generateLink }}</td>
        <td>
          <button @click='delUserTableRow(user_index)'>Remove</button>
        </td>
      </tr>
      </tbody>
    </table>
    <br>
    <!--    {{ infoks1 }}-->
    <br>
    <button @click='addUserTableRow()'>Add New Row</button>

    <div class="wrapper">
      <h3>Message to be sent by e-mail:</h3>
      <ResizeAuto>
        <template v-slot:default="{resize}">
        <textarea
            class="textarea"
            @input="resize"
            placeholder="Please insert Your message to the gift choosers"
            v-model="event.messageEmail"
        ></textarea>
        </template>
      </ResizeAuto>
    </div>

  </div>
</template>

<script>

import {post} from "axios";
import ResizeAuto from "@/components/ResizeAuto";

export default {
  name: "Event2",
  components: {ResizeAuto},

  data: function () {

    return {
      showResponse: false,
      'userRows': [{userId: getRandom(6), role1: "owner"}],
      'giftRows': [{nr: getOne(1)}],
      'messageEmail': "",

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
          eventAuthor: this.event.eventAuthor,
          messageEmail: this.event.messageEmail,
        },
        gifts: this.giftRows,

        users: this.userRows,

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
      let my_giftObjects = {
        nr: this.nr,
        giftTitle: this.giftTitle,
        giftAmount: this.giftAmount,
        giftDescription: this.giftDescription
      };
      this.giftRows.push(my_giftObjects);
    },
    delTableRow: function (id) {
      this.giftRows.splice(id, 1);
    },

    
    // USER
    addUserTableRow: function () {
      this.userId = getRandom(6);
      this.guestName = "";
      this.role = "user";
      this.email = "";
      this.generateLink = "";
      this.deleteButton = "";
      let my_userObjects = {
        userId: this.userId,
        guestName: this.guestName,
        role: this.role,
        email: this.email,
        generateLink: this.generateLink,
        deleteButton: this.deleteButton
      };
      this.userRows.push(my_userObjects);
    },

    delUserTableRow: function (id) {
      this.userRows.splice(id, 1);
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















