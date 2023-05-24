<script>
import FightersTable from '../components/FightersTable.vue';

export default {
  components: { FightersTable },
  data() {
    return {
      fighters: [
        {
          id: 1,
          name: 'Konnor',
          age: '34',
          country: 'Ireland',
          fightsNum: 56,
          elo: 1583,
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
          age: '34',
          country: 'Irland',
          fightsNum: 56,
          elo: 1583,
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
  }
}
</script>

<template>
  <FightersTable :items="fighters">
  </FightersTable>
</template>
