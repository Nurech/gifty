<template>
  <div class="event" align="center">
    <h1>This is an Event page</h1>

    <EventBody/>

    <br><br><br>

    <GiftList/>

    <br><br><br>

    <Invite/>

    <br><br><br>

    <CreateEvent/>

  </div>
</template>

<script>

import Invite from "@/components/Invite";
import GiftList from "@/components/GiftList";
import EventBody from "@/components/EventBody";
import CreateEvent from "@/components/CreateEvent";

export default {
  components: {
    CreateEvent,
    EventBody,
    Invite,
    GiftList,

  }
}
</script>
