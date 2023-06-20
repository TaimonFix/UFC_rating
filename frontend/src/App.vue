<script setup>
import { RouterView } from 'vue-router'

</script>


<template>
  
  <div class='hat' @click="scrollTopTop()">
    <h1>
      UFC Fighter Rankings
    </h1>
  </div>



<!-- сама таблица -->
<RouterView />
</template>



<style scoped>
.hat {
  position: sticky;

  top: 0;
  height: 70px; 
  background-color: #686b74f4;
  text-shadow: 2px 2px 2px red;
  margin-bottom: 10px;
  font-size: 120%;
  
}
h1 {
  text-align: center;
  margin: 0px;
  
  padding: 11px;
}
</style>


