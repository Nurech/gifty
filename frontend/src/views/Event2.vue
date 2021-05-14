<template xmlns="http://www.w3.org/1999/html">
  <div class="event" align="center" :style="{ backgroundImage: 'url(' + image + ')' }">
    <div class="container" style="opacity: 0.88">
      <div class="shadow-lg p-3 mb-5 bg-body rounded"><h1>Create Your Gifter event</h1>
        <br>
        <br>
        <span class="table_heading">Add your event info</span>
        <br><br>
        <table class="table table-bordered">
          <thead>
          <th>Event name</th>
          <th>Description</th>
          <th width="22%">Event date</th>
          <th width="23%">Event author</th>
          </thead>
          <tbody>
          <tr>
            <td><input v-model="event.eventName" placeholder="Event name"></td>
            <td><input v-model="event.eventDescription" placeholder="Description"/></td>
            <td>
              <b-form-datepicker id="datepicker-sm" size="sm" v-model="event.eventDate" class="mb-2" start-weekday="1"
                                 :date-format-options="{ year: 'numeric', month: 'numeric', day: 'numeric' }"
              ></b-form-datepicker>
            </td>
            <td><input v-model="event.eventAuthor" placeholder="Event author"/></td>
          </tr>
          </tbody>
        </table>
        <br>
        <span class="table_heading">Add your guests</span>
        <br>
        <br>
        <table class="table table-bordered">
          <thead>
          <th>#</th>
          <th>Host name</th>
          <th>E-mail</th>
          <th width="45%">Link for the Host</th>
          </thead>
          <tbody>
          <tr>
            <td>0</td>
            <td><input v-model="event.eventAuthor" placeholder="Host name"/></td>
            <td><input v-model="event.email" placeholder="E-mail"/></td>
            <td>{{ event.generateLink }}</td>
          </tr>
          </tbody>
        </table>
        <table class="table table-bordered">
          <thead>
          <th>#</th>
          <th>Guest name</th>
          <th>E-mail</th>
          <th width="31%">Link for the Guest</th>
          <th width="14%"></th>
          </thead>
          <tbody>
          <tr v-for="(item, user_index) in userRows" :item="item">
            <td>{{ user_index + 1 }}</td>
            <td><input v-model="item.guestName" placeholder="Guest name"/></td>
            <td><input v-model="item.email" placeholder="E-mail"/></td>
            <td>{{ item.generateLink }}</td>
            <td>
              <button @click='delUserTableRow(user_index)' class="btn btn-danger">Remove</button>
            </td>
          </tr>
          </tbody>
        </table>
        <span style="float: left; width: 25%;">
          <button @click='addUserTableRow()' class="btn btn-success">Add one more guest</button></span>
        <br><br>
        <span class="table_heading">Add your gifts</span>
        <br>
        <br>
        <table class="table table-bordered">
          <thead>
          <th>#</th>
          <th>Gift name</th>
          <th>Gifts available</th>
          <th>Description</th>
          <th></th>
          </thead>
          <tbody>
          <tr v-for="(item, gift_index) in giftRows" :item="item">
            <td>{{ gift_index + 1 }}</td>
            <td><input v-model="item.giftTitle" placeholder="Gift name"/></td>
            <td><input v-model="item.giftAmount" placeholder="Gifts available"/></td>
            <td><input v-model="item.giftDescription" placeholder="Description"/></td>
            <td>
              <button @click='delTableRow(gift_index)' class="btn btn-danger">Remove</button>
            </td>
          </tr>
          </tbody>
        </table>
        <span style="float: left; width: 23%;">
       <button @click='addTableRow()' class="btn btn-success">Add one more gift</button>
        </span>
        <br>
        <br>
        <br>
        <div class="wrapper">
          <div class="container" style="width: 90%">
            <span class="table_heading">Message to be sent by e-mail:</span>
            <br><br>
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
            <br>
            <button v-on:click="eventCreator()" class="btn btn-outline-success btn-lg btn-block"
                    :disabled="showResponse">Create Event
            </button>
            <br>
            <div v-if="showResponse">
              <div class="alert alert-success" role="alert">
                <h4 class="alert-heading">Well done!<p>
                  <p>Aww yeah, you successfully created an event!</p></h4>
              </div>
            </div>
          </div>
        </div>
        <br>
      </div>
    </div>
  </div>
</template>

<script>
import {post} from "axios";
import ResizeAuto from "@/components/ResizeAuto";

const eventId = getRandom(6);
let userId = getRandom(6);
let ownerId = getRandom(6);
export default {
  name: "Event2",
  components: {ResizeAuto},

  data: function () {
    return {
      showResponse: false,
      'userRows': [{userId, role: "user", generateLink: 'http://'+window.location.hostname+'/e/' + eventId + '/u/' + ownerId}],
      'giftRows': [{nr: 1, eventId}],
      'roleRows': [{userId, role: "user", eventId}],
      'messageEmail': "",
      image: "https://static-cdn.drawnames.com/Content/Assets/deco-sending.svg?nc=201910281040",

      'event': {
        eventId: eventId,
        eventName: '',
        eventDescription: '',
        eventDate: '',
        eventAuthor: '',
        messageEmail: '',
        giftId: '',
        email: '',
        generateLink: 'http://'+window.location.hostname+'/e/' + eventId + '/u/' + userId,
      }
    }
  },

  methods: {

    eventCreator: function () {
      let userObjects = {
        userId: ownerId,
        guestName: this.event.eventAuthor,
        role: 'owner',
        email: this.event.email,
        generateLink: this.event.generateLink
      };
      let rowObjects = {
        userId: ownerId,
        role: 'owner',
        eventId: eventId,
      };
      this.userRows.push(userObjects);
      this.roleRows.push(rowObjects);
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
      });
      this.showResponse = true;
      this.userRows.splice(this.userRows.length-1, 1);
    },
    // GIFT
    addTableRow: function () {
      this.giftTitle = "";
      this.giftAmount = "";
      this.giftDescription = "";
      let my_giftObjects = {
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
      this.generateLink = 'http://'+window.location.hostname+'/e/' + eventId + '/u/' + userId;

      let my_userObjects = {
        userId: this.userId,
        guestName: this.guestName,
        role: this.role,
        email: this.email,
        generateLink: this.generateLink
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
  },

}

function getRandom(length) {
  let random = '0123456789';
  let result = "";
  for (let i = 0; i < length; i++) {
    result += random.charAt(Math.floor(Math.random() * random.length));
  }
  return result;
}

</script>
<style>

</style>















