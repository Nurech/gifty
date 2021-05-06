<template>
  <div class="eventBody">
    <input v-model="event.eventName" placeholder="Event name"/>
    <input v-model="event.eventDescription" placeholder="Description">
    <input v-model="event.eventDate" placeholder="Event date"/>
    <input v-model="event.eventAuthor" placeholder="Event author"/>

    <button v-on:click="createEvent()">Create Event</button>
    <div v-if="showResponse"><h6>You created new event with Id: {{ event.id }}</h6></div>

  </div>
</template>

<script>

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
      }
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
</script>

<style scoped>
button {
  width: 150px;
  padding: 10px 0;
  text-align: center;
  margin: 20px 10px;
  border-radius: 25px;
  font-weight: bold;
  border: 2px solid #213b38;
  background: transparent;
  color: #009;
  cursor: pointer;
  position: relative;
}
</style>