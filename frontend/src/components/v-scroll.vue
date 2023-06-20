<template>
    
    <div class="scrollTop" @click="scrollTopTop()" v-if="buttonShow">
        <i class="fa-solid fa-circle-arrow-up" style="color: #4ce1ec;" ></i>
    </div> 
</template>

<script>
export default {
    name: "v-scroll",
    data() {
 
        return {
            buttonShow: false
        }
    },

    mounted: function () {
        // this.checkScrollPosition();
        window.addEventListener('scroll', this.checkScrollPosition);
    },

   
    methods: {
        checkScrollPosition() {
            this.buttonShow = window.scrollY > 300;
        },
        
      
      scrollTopTop() {
        window.scrollTo(0,0)

      }
    }
}
    
</script>

<style>
.scrollTop{
    position: fixed;
    bottom: 50px;
    right: 10%;
    font-size: 50px;
    z-index: 999;
    cursor: pointer;
    visibility: visible;
    opacity: 1;
    transition: 0.5s;
  } 
  

</style>