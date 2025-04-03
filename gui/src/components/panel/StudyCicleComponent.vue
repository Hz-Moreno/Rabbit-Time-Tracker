<script setup>
import PencilIcon from '@/components/icons/PencilIconHero.vue'

const weekGoals = [
  {
    title: 'Gym',
    goals: [{ checked: true }, { checked: false }],
  },
  {
    title: 'Study',
    goals: [{ checked: false }, { checked: true }, { checked: false }],
  },
  {
    title: 'Reading',
    goals: [{ checked: true }, { checked: false }],
  },
]
</script>

<template>
  <div class="card">
    <div class="card-header flex justify-between items-center">
      <h1 class="text-2xl font-bold text-gray-800">Week Goals</h1>
      <div class="flex space-x-4">
        <button class="flex items-center space-x-1 text-gray-700 hover:text-gray-900">
          <span>View More</span>
        </button>
        <button class="button-danger flex items-center space-x-1 text-gray-700 hover:text-gray-900">
          <PencilIcon class="w-5 h-5" />
          <span>Edit</span>
        </button>
      </div>
    </div>
    <div class="card-body space-y-4">
      <!-- for loop -->

      <div v-for="(goal, index) in weekGoals" :key="index" class="flex items-center">
        <div class="week-target-title-content text-center w-1/3 text-gray-700">
          <span class="week-target-title">{{ goal.title }}</span>
        </div>
        <div class="week-target-goals pl-2 w-2/3 flex space-x-2">
          <input
            v-for="(item, idx) in goal.goals"
            :key="idx"
            type="checkbox"
            class="week-target-check h-5 w-5 rounded border-gray-300"
            :checked="item.checked"
          />
        </div>
      </div>
    </div>
  </div>
</template>
