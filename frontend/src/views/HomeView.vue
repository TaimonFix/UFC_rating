<script>
import FightersTable from '../components/FightersTable.vue';


export default {
  components: { FightersTable },
  data() {
    return {
      filterParams: {
        country: '',
        weightClass: ''
      },
      fighters: [
        {
          id: 1,
          name: 'Konnor',
          age: '34',
          country: 'Ireland',
          fightsNum: 56,
          elo: 1583,
          weightClass: 'Lightweight',
          fightStory: [
            {
              opponent: { id: 2, name: 'Khabib' },
              result: 'win',
              reason: 'tko'
            },
            {
              opponent: { id: 2, name: 'Khabib' },
              result: 'win',
              reason: 'tko'
            }
          ],
        },

        {
          id: 3,
          name: 'Konnor',
          age: '35',
          country: 'USA',
          fightsNum: 56,
          elo: 1583,
          weightClass: 'Welterweight',
          fightStory: [
            {
              opponent: { id: 2, name: 'Khabib' },
              result: 'win',
              reason: 'tko'
            },
            {
              opponent: { id: 2, name: 'Khabib' },
              result: 'win',
              reason: 'tko'
            }
          ],
        }
      ]
    }
  },

  computed: {
    filteredFighters() {
      return this.fighters.filter(x => {
        return (!this.filterParams.country.length || x.country === this.filterParams.country) &&
          (!this.filterParams.weightClass.length || x.weightClass === this.filterParams.weightClass)
      })
    },

    sortedAndFilteredFighters() {
      return this.filteredFighters.sort()
    }
  },

  async created() {
    // Sending request
    // const result = await fetch('myapi.com/data')
    // this.fighters = result.data
  }
}


// function filterTable() {
//     var countryFilter = document.getElementById('country-filter').value;
//     var weightFilter = document.getElementById('weight-filter').value;
//     var ratingFilter = document.getElementById('rating-filter').value;

//     var table = document.getElementById('fighter-table');
//     var rows = table.getElementsByTagName('tr');

//     for (var i = 1; i < rows.length; i++) {
//         var row = rows[i];
//         var country = row.getElementsByTagName('td')[2].innerText;
//         var weight = row.getElementsByTagName('td')[3].innerText;
//         var rating = row.getElementsByTagName('td')[5].innerText;

//         var countryMatch = countryFilter === '' || country === countryFilter;
//         var weightMatch = weightFilter === '' || weight === weightFilter;
//         var ratingMatch = ratingFilter === '' || parseInt(rating) >= parseInt(ratingFilter);

//         if (countryMatch && weightMatch && rating ) {
//             row.style.display = ''; // show the row
//             } else {
//             row.style.display = 'none'; // hide the row
//             }
//         }
//     }

</script>

<template>
  <!-- фильтр -->
  <div id="filter-container">
    <div class="filters">
      <div class="filt">
        <label for="country-filter">Country:</label>
        <select id="country-filter" v-model="filterParams.country">
            <option value="">All</option>
            <option value="Ireland">Ireland</option>
            <option value="USA">USA</option>
            <!-- Add more options for other countries -->
        </select>
      </div>
      
      <div class="filt">
        <label for="weight-filter">Weight Class:</label>
        <select id="weight-filter" v-model="filterParams.weightClass">
            <option value="">All</option>
            <option value="Lightweight">Lightweight</option>
            <option value="Welterweight">Welterweight</option>
            <!-- Add more options for other weight classes -->
        </select>
      </div>
      
      <div class="filt">
        <label for="rating-filter">Rating:</label>
        <input type="number" id="rating-filter" onchange="filterTable()" min="0" max="5000">
      </div>
    </div>
  </div>
    
    
  
  <FightersTable :items="filteredFighters">
  </FightersTable>
</template>
