<template>
  <div class="card">
    <div class="card-header flex justify-between items-center">
      <h1 class="text-xl font-semibold text-gray-800">{{ day }}</h1>
      <h2 class="text-sm text-gray-600">{{ date }}</h2>
    </div>
    <div class="card-body">
      <div v-for="(task, index) in tasks" :key="index" class="p-3 flex items-start space-x-3">
        <div class="flex items-center space-x-2">
          <input
            type="checkbox"
            class="h-5 w-5 text-blue-600 rounded border-gray-300 focus:ring-blue-500 focus:ring-2"
            v-model="task.completed"
          />
          <span class="text-gray-700">{{ task.time }}</span>
        </div>
        <div
          class="text-gray-600 uppercase border-l border-gray-400 pl-2"
          :style="{ color: task.color }"
        >
          {{ task.activity }}
        </div>
      </div>
      <!-- <button onclick="" class="w-full main-bg p-4 rounded-md mt-5">See More</button> -->
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

const day = ref('Friday')
const date = ref('28/03/2025')

const tasks = ref([
  {
    time: '08:00 - 10:30',
    activity: 'Study',
    completed: false,
    color: '#96d626',
  },
  {
    time: '01:00 - 02:30 ',
    activity: 'Gym',
    completed: true,
    color: '#26b3d6',
  },
])
</script>
