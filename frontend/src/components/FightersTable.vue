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
        <th>Number of Fights</th>
        <th>Weight Class</th>
        <th>Elo Ranking</th>
    </tr>
    <tr v-for="(row, index) in items">
        <td>{{ index + 1 }}</td>
        <td>{{ row.name }}</td>
        <td>{{ row.fightNum }}</td>
        <td>{{ row.weightClass }}</td>
        <td>{{ row.elo }}</td>
    </tr>
    
</table>
</template>

<style>

table {
  margin: 0 auto;
  border-collapse: collapse;
  margin-top: 20px;
  margin-bottom: 70px;
  background-color: #4ce1ecf1;
}

th, td {
  border: 2px solid #424458;
  padding: 8px;
  text-align: center;
}

th {
  background-color: #c4c2c2;
}

tr:nth-child(even) {
  background-color: #f9f9f9;
}

</style>