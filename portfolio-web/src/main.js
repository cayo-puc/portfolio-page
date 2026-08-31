import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import i18n from './i18n';

// Importa o arquivo global de estilos que criaremos na próxima etapa
import './assets/scss/global.scss';

const app = createApp(App);

app.use(router);
app.mount('#app');
