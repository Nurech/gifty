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
export default {
  name: "EventBody",

  data: function () {
    return {
      // 'eventName': '',
      // 'eventDescription': '',
      // 'eventDate': '',
      // 'eventAuthor': '',

      showResponse: false,
      event: {
        id: (Math.random() * 10000000),
        eventName: '',
        eventDescription: '',
        eventDate: '',
        eventAuthor: '',
      }
    }
  },


  methods: {


    'createEvent': function () {
      this.$http.post('/api/event', {
        eventName: this.eventName, //button activate
        eventDescription: this.eventDescription,
        eventDate: this.eventDate,
        eventAuthor: this.eventAuthor,
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

</script>

<style scoped>

</style>