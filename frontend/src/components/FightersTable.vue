<script>
export default {
  props: {
    items: Array
  },
}


</script>

<template>
  <table id="fighter-table" >
    <tr>
        <th>Rank</th>
        <th>Name</th>
        <!-- <th>Country</th> -->
        <th>Number of Fights</th>
        <!-- <th>Age</th> -->
        <th>Weight Class</th>
        <th>Elo Ranking</th>
    </tr>
    <tr v-for="(row, index) in items">
        <td>{{ index + 1 }}</td>
        <td>{{ row.name }}</td>
        <!-- <td>{{ row.country}}</td> -->
        <td>{{ row.fightsNum }}</td>
        <!-- <td>{{ row.age }}</td> -->
        <td>{{ row.weightClass }}</td>
        <td>{{ row.elo }}</td>
    </tr>
    
    <!-- Add more rows for other fighters and their rankings -->
</table>
</template>
