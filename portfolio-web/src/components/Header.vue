Snippet de código
<template>
    <header class="site-header">
    <nav class="nav-container glass glass-sheen">
        <router-link to="/" class="brand">
        <span class="name">Anthony Santos</span>
        <span class="role">Full Stack Developer</span>
        </router-link>
        
        <ul class="nav-links">
        <!-- O slice(1) remove o link 'Home' para não duplicar, já que o nome/logo já leva para a Home -->
        <li v-for="item in primaryNavigationItems.slice(1)" :key="item.to">
            <router-link :to="item.to" class="nav-item" active-class="active">
            {{ item.label }}
            </router-link>
        </li>
        <li>
            <button @click="toggleLanguage" class="lang-toggle">
                {{ currentLocale === 'pt' ? 'EN' : 'PT' }}
            </button>
        </li>
        </ul>
    </nav>
    </header>
</template>

<script setup>
import { primaryNavigationItems } from '../data/navigation-items.js';
import { computed } from 'vue';
import { useI18n } from 'vue-i18n';

const { locale } = useI18n();

const currentLocale = computed(() => locale.value);

const toggleLanguage = () => {
  locale.value = locale.value === 'pt' ? 'en' : 'pt';
};
</script>

<style scoped lang="scss">
.site-header {
    position: sticky;
    top: 1rem;
    z-index: 30;
    max-width: 1024px;
    margin: 0 auto;
    padding: 0 1rem;
}

.nav-container {
    display: flex;
    flex-direction: column;
    gap: 0.75rem;
    border-radius: 9999px;
    padding: 0.75rem 1.25rem;
    
    @media (min-width: 640px) {
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    }
}

.brand {
    display: flex;
    align-items: baseline;
    gap: 0.5rem;
    text-decoration: none;
    color: var(--foreground);
    
    .name {
    font-family: var(--font-display);
    font-size: 1.125rem;
    font-weight: 600;
    }
  
    .role {
    font-size: 0.7rem;
    text-transform: uppercase;
    letter-spacing: 0.16em;
    color: var(--muted-foreground);
    }
}

.nav-links {
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    gap: 0.25rem;
    list-style: none;
    
    .nav-item {
    border-radius: 9999px;
    padding: 0.375rem 0.75rem;
    font-size: 0.875rem;
    text-decoration: none;
    color: var(--muted-foreground);
    transition: all 0.3s ease;
    
    &:hover {
        background-color: var(--glass-strong);
        color: var(--foreground);
    }
    
    &.active {
        background-color: var(--glass-strong);
        color: var(--foreground);
    }
    }
}
</style>