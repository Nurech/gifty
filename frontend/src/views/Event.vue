<template>
  <div class="event" align="center">
    <h1>This is an Event page</h1>

    <EventBody/>
    <br><br><br>
        <GiftList/>
    <br><br><br>
        <Invite/>
    <br><br><br>

  </div>
</template>

<script>

import Invite from "@/components/Invite";
import GiftList from "@/components/GiftList";
import EventBody from "@/components/EventBody";

export default {
  components: {
    EventBody,
    Invite,
    GiftList
  }
}
</script>
