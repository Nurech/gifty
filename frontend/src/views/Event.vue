<template>
  <div class="event">
    <h1>This is an Event page</h1>
<EventBody/>


    <Invite/>

  </div>
</template>
<script>

import Invite from "@/components/Invite";
import EventBody from "@/components/EventBody";

export default {
  components: {
    Invite,
    EventBody
  }
}
</script>
