import { createRouter, createWebHistory } from 'vue-router'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/auth/LoginView.vue'),
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('../views/auth/RegisterView.vue'),
    },
    {
      path: '/panel',
      component: () => import('../views/panel/PanelLayout.vue'),
      children: [
        {
          path: '',
          name: 'home',
          component: () => import('../views/panel/HomeView.vue'),
        },
        {
          path: 'days',
          name: 'days',
          component: () => import('../views/panel/DayView.vue'),
        },
      ],
    },
  ],
})
export default router
