import { createI18n } from 'vue-i18n';
import pt from './locales/pt.json';
import en from './locales/en.json';

const savedLocale = localStorage.getItem('portfolio-locale');
const initialLocale = savedLocale === 'en' ? 'en' : 'pt-BR';
const messages = { 'pt-BR': pt, en };

const i18n = createI18n({
  legacy: false,
  locale: initialLocale,
  fallbackLocale: 'pt-BR',
  messages
});

document.documentElement.lang = initialLocale;
document.title = messages[initialLocale].meta.title;
document
  .querySelector('meta[name="description"]')
  ?.setAttribute('content', messages[initialLocale].meta.description);

export default i18n;
