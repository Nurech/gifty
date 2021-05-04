<template>
  <div class = "eventBody">
    <input v-model="eventName" placeholder="Event name"/>
    <input v-model="eventDescription" placeholder="Description">
    <input v-model="eventDate" placeholder="Event date"/>
    <input v-model="eventAuthor" placeholder="Event author"/>

    <button v-on:click="createEvent()">Create Event</button>
    <div v-if="showResponse"><h6>You created new event with Id: {{eventName.id }}</h6></div>

  </div>
</template>

<script>
export default {
  name: "EventBody",

  data: function () {
    return {

      showResponse: false,

      eventName: '',
      eventDescription: '',
      eventDate: '',
      eventAuthor: '',

    }
  },


  methods: {
      'createEvent': function () {
        this.$http.put('event', {
          eventName: this.eventName, //button activate
          eventDescription: this.eventDescription,
          eventDate: this.eventDate,
          eventAuthor: this.eventAuthor,
        })
            .then((response) => {
              this.user.id = response.data;
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