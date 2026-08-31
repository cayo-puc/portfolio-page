import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import AboutView from '../views/AboutView.vue';
import ExperiencesView from '../views/ExperiencesView.vue'; // Nova importação
import ProjectsView from '../views/ProjectsView.vue';
import ContactView from '../views/ContactView.vue';

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/sobre', // Nova rota
    name: 'sobre',
    component: AboutView
  },
  {
    path: '/projetos',
    name: 'projetos',
    component: ProjectsView
  },
  {
    path: '/experiencias', // Nova rota mapeada
    name: 'experiencias',
    component: ExperiencesView
  },
  {
    path: '/contato',
    name: 'contato',
    component: ContactView
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;