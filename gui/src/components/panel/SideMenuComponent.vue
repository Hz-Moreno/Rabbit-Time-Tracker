<script setup>
import HomeIcon from '@/components/icons/HomeIconHero.vue'
import ProfileIcon from '@/components/icons/ProfileIconHero.vue'
import StudyIcon from '@/components/icons/StudyIconHero.vue'
import ChartIcon from '@/components/icons/ChartIconHero.vue'
</script>

<template>
  <aside class="w-64 bg-white p-4 md:w-20 lg:w-64 transition-all duration-300">
    <div class="flex items-center space-x-2">
      <img class="w-10 h-auto" src="/public/main_logo.png" alt="Logo" />
      <h1 class="ml-5 text-xl font-bold text-gray-800">RABBIT</h1>
    </div>
    <nav class="mt-[5rem]">
      <a href="#" class="block p-3 rounded-md menu-item selected flex items-center space-x-2">
        <HomeIcon class="w-6 h-6" />
        <span class="hidden lg:inline">Home</span>
      </a>
      <a href="#" class="block p-3 rounded-md menu-item flex items-center space-x-2">
        <StudyIcon class="w-6 h-6" />
        <span class="hidden lg:inline">Study</span>
      </a>
      <a href="#" class="block p-3 rounded-md menu-item flex items-center space-x-2">
        <ChartIcon class="w-6 h-6" />
        <span class="hidden lg:inline">Stats Overview</span>
      </a>
      <a href="#" class="block p-3 rounded-md menu-item flex items-center space-x-2">
        <ProfileIcon class="w-6 h-6" />
        <span class="hidden lg:inline">Profile</span>
      </a>
    </nav>
  </aside>
</template>
