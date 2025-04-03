<script setup>
import SideMenu from '@/components/panel/SideMenuComponent.vue'
</script>

<template>
  <div class="flex h-screen bg-gray-100">
    <!-- Sidebar -->
    <SideMenu />
    <!-- Main Content -->
    <main class="flex-1 p-6">
      Dashboard
      <div class="flex">
        <router-view></router-view>
      </div>
    </main>
  </div>
</template>
