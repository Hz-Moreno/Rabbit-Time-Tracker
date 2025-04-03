<template>
  <!-- Form Section -->
  <div class="bg-white p-6 rounded-lg shadow-md mb-6">
    <h2 class="text-xl font-semibold text-gray-700 mb-4">Add a Task</h2>
    <form class="space-y-4">
      <!-- Day Select -->
      <div>
        <label for="day" class="block text-sm font-medium text-gray-700">Day</label>
        <select
          id="day"
          class="mt-1 block w-full p-2 border border-gray-300 rounded-md focus:ring-indigo-500 focus:border-indigo-500"
        >
          <option>Monday</option>
          <option>Tuesday</option>
          <option>Wednesday</option>
          <option>Thursday</option>
          <option>Friday</option>
          <option>Saturday</option>
          <option>Sunday</option>
        </select>
      </div>

      <!-- Task Title -->
      <div>
        <label for="title" class="block text-sm font-medium text-gray-700">Task Title</label>
        <input
          type="text"
          id="title"
          placeholder="e.g., Study Algorithms"
          class="mt-1 block w-full p-2 border border-gray-300 rounded-md focus:ring-indigo-500 focus:border-indigo-500"
        />
      </div>

      <!-- Start and End Hours -->
      <div class="flex space-x-4">
        <div class="w-1/2">
          <label for="start-hour" class="block text-sm font-medium text-gray-700">Start Hour</label>
          <input
            type="time"
            id="start-hour"
            class="mt-1 block w-full p-2 border border-gray-300 rounded-md focus:ring-indigo-500 focus:border-indigo-500"
          />
        </div>
        <div class="w-1/2">
          <label for="end-hour" class="block text-sm font-medium text-gray-700">End Hour</label>
          <input
            type="time"
            id="end-hour"
            class="mt-1 block w-full p-2 border border-gray-300 rounded-md focus:ring-indigo-500 focus:border-indigo-500"
          />
        </div>
      </div>

      <!-- Category Select -->
      <div>
        <label for="category" class="block text-sm font-medium text-gray-700">Category</label>
        <select
          id="category"
          class="mt-1 block w-full p-2 border border-gray-300 rounded-md focus:ring-indigo-500 focus:border-indigo-500"
        >
          <option>Study</option>
          <option>Gym</option>
          <option>Work</option>
          <option>Personal</option>
          <option>Other</option>
        </select>
      </div>

      <!-- Add Task Button -->
      <button
        type="submit"
        class="w-full bg-indigo-600 text-white p-2 rounded-md hover:bg-indigo-700"
      >
        Add Task
      </button>
    </form>
  </div>
</template>
