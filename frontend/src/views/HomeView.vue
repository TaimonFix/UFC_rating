<script>
import FightersTable from '../components/FightersTable.vue';
import fighters from '../../../parsing/rating.json';
import vScroll from '../components/v-scroll.vue';



export default {
  components: {
    FightersTable,
    vScroll
    
  },
  data() {
    return {
      filterParams: {
        weightClass: ''
      },

      fighters

    }
  },

  
  computed: {
    filteredFighters() {
      return this.fighters.filter(x => {
        return (!this.filterParams.weightClass.length || x.weightClass === this.filterParams.weightClass)
      })
    },

    
    sortedAndFilteredFighters() {
      return this.filteredFighters.sort((a, b) => b.elo - a.elo)
    }
  },


}




</script>

<template>
  <!-- фильтр -->
  <div id="filter-container">
    <div class="filters">
 
      
      <div class="filt">
        <label class="wfiltText" for="weight-filter">Weight Class:</label>
        <select id="weight-filter" v-model="filterParams.weightClass">
            <option value="">All</option>
            <option value="Open Weight">Open Weight</option>
            <option value="Lightweight">Lightweight</option>
            <option value="Heavyweight">Heavyweight</option>
            <option value="Middleweight">Middleweight</option>
            <option value="Welterweight">Welterweight</option>
            <option value="Light Heavyweight">Light Heavyweight</option>
            <option value="Catch Weight">Catch Weight</option>
            <option value="Featherweight">Featherweight</option>
            <option value="Bantamweight">Bantamweight</option>
            <option value="Flyweight">Flyweight</option>
            <option value="Women's Bantamweight">Women's Bantamweight</option>
            <option value="Women's Strawweight">Women's Strawweight</option>
            <option value="Women's Flyweight">Women's Flyweight</option>
            <option value="Women's Featherweight">Women's Featherweight</option>
            <!-- Add more options for other weight classes -->
        </select>
      </div>
      
      <!-- <div class="filt">
        <label for="rating-filter">Rating:</label>
        <input type="number" id="rating-filter" onchange="filterTable()" min="0" max="5000">
      </div> -->
    </div>
  </div>
    
    
  
  <FightersTable :items="sortedAndFilteredFighters"></FightersTable>
  <vScroll></vScroll>
</template>
