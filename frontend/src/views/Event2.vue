<template>
  <div class="event" align="center" :style="{ backgroundImage: 'url(' + image + ')' }">
    <div class="container">
      <div class="shadow-lg p-3 mb-5 bg-body rounded"><h1>Create event</h1></div>
    </div>
    <divtable class="table table-bordered table-dark">
      <thead>
      <th>Event name</th>
      <th>Description</th>
      <th>Event date</th>
      <th>Event author</th>
      </thead>
      <tbody>
      <tr>
        <td><input v-model="event.eventName" placeholder="Event name" class="font-weight-bold"/></td>
        <td><input v-model="event.eventDescription" placeholder="Description"/></td>
        <td>
          <b-form-datepicker id="datepicker-sm" size="sm" v-model="event.eventDate" class="mb-2"
                             :date-format-options="{ year: 'numeric', month: 'numeric', day: 'numeric' }  "
          ></b-form-datepicker>
        </td>
        <td><input v-model="event.eventAuthor" placeholder="Event author"/></td>
      </tr>
      </tbody>
    </divtable>
    <br>
    <br>
    <h3>Add your participants</h3>
    <br>
    <br>
    <divtable class="table table-bordered table-dark">
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
          <button @click='delUserTableRow(user_index)' class="btn btn-danger">Remove</button>
        </td>
      </tr>
      </tbody>
    </divtable>
    <br>
    <!--    {{ infoks1 }}-->
    <br>
    <button @click='addUserTableRow()' class="btn btn-success">Add guest</button>
    <!--//giftList-->
    <br>
    <h3>Add your gifts</h3>
    <br>
    <br>
    <divtable class="table table-bordered table-dark">
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
          <button @click='delTableRow(gift_index)' class="btn btn-danger">Remove</button>
        </td>
      </tr>
      </tbody>
    </divtable>
    <br>
    <!--    {{ infoks }}-->
    <br>
    <button @click='addTableRow()' class="btn btn-success">Add gift</button>

    <div class="wrapper">
      <div class="container">
        <h3>Message to be sent by e-mail:</h3>
        <br>
        <ResizeAuto>
          <template v-slot:default="{resize}">
            <div class="mb-3">
        <textarea
            class="form-control" id="exampleFormControlTextarea1" rows="5"
            @input="resize"
            placeholder="Please insert your message to the gift choosers"
            v-model="event.messageEmail"
        ></textarea>
            </div>
          </template>
        </ResizeAuto>
      </div>
    </div>

    <!--    <div class="wrapper">-->
    <!--      <h3>Message to be sent by e-mail:</h3>-->
    <!--      <br>-->
    <!--      <ResizeAuto>-->
    <!--        <template v-slot:default="{resize}">-->
    <!--        <textarea-->
    <!--            class="textarea"-->
    <!--            @input="resize"-->
    <!--            placeholder="Please insert Your message to the gift choosers"-->
    <!--            v-model="event.messageEmail"-->
    <!--        ></textarea>-->
    <!--        </template>-->
    <!--      </ResizeAuto>-->
    <!--    </div>-->
    <!--    <input v-model="event.eventName" placeholder="Event name"/>-->
    <!--    <input v-model="event.eventDescription" placeholder="Description"/>-->
    <!--    <input v-model="event.eventDate" placeholder="Event date"/>-->
    <!--    <input v-model="event.eventAuthor" placeholder="Event author"/>-->
    <!--    <br>-->
    <!--    <br>-->
    <!--    <br>-->
    <br>
    <br>
    <button v-on:click="eventCreator()" class="btn btn-primary">Create Event</button>
    <div v-if="showResponse"><h6>You created new event with Id: {{ event.id }}</h6></div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
  </div>


</template>

<script>
import {post} from "axios";
import ResizeAuto from "@/components/ResizeAuto";

const eventId = getRandom(6);
let userId = getRandom(6);

export default {
  name: "Event2",
  components: {ResizeAuto},

  data: function () {
    return {
      showResponse: false,
      'userRows': [{userId, role: "owner", generateLink: "/event/" + eventId + "/user/" + userId}],
      'giftRows': [{nr: getOne(1), eventId}],
      'roleRows': [{userId, role: "owner", eventId}],
      'messageEmail': "",
      image: "https://static-cdn.drawnames.com/Content/Assets/deco-sending.svg?nc=201910281040",

      'event': {
        eventId: eventId,
        eventName: '',
        eventDescription: '',
        eventDate: '',
        eventAuthor: '',
        messageEmail: '',
        // mis see on? pole vaja?
        giftId: ''

      },
    }
  },

  methods: {
    'eventCreator': function () {
      post('/api/creator/', {
        event: {
          eventId: eventId,
          eventName: this.event.eventName,
          eventDescription: this.event.eventDescription,
          eventDate: this.event.eventDate,
          eventAuthor: this.event.eventAuthor,
          messageEmail: this.event.messageEmail,
        },
        gifts: this.giftRows,
        users: this.userRows,
        role: this.roleRows
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
        giftDescription: this.giftDescription,
        eventId: eventId
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
      this.generateLink = "/event/" + eventId + "/user/" + this.userId;
      this.deleteButton = "";

      let my_userObjects = {
        userId: this.userId,
        guestName: this.guestName,
        role: this.role,
        email: this.email,
        generateLink: this.generateLink,
        deleteButton: this.deleteButton
      };
      let my_rowObjects = {
        userId: this.userId,
        role: this.role,
        eventId: eventId,
      };

      this.userRows.push(my_userObjects);
      this.roleRows.push(my_rowObjects);

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

body {
  background: antiquewhite; /* fallback for old browsers */
  background: navajowhite(to right, white, white); /* Chrome 10-25, Safari 5.1-6 */
  background: navajowhite(to right, white, white); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
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
  color: #163427;
}

.mb-2 {
  width:200px
}

th {
  background-color: black;
  color: white;
}

</style>















