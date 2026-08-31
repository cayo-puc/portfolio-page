<template>
  <main class="home-container">
    
    <!-- Hero Section -->
    <section class="hero-section animate-rise">
      <p class="subtitle">{{ $t('home.eyebrow', { year: currentYear }) }}</p>
      <h1 class="title">
        {{ $t('home.title.before') }} <span class="text-gradient">{{ $t('home.title.highlight') }}</span>,<br />
        {{ $t('home.title.after') }}
      </h1>
      <p class="description">{{ $t('home.description') }}</p>
      
      <div class="cta-group">
        <router-link to="/projetos" class="btn btn-primary glass-strong glass-sheen">
          {{ $t('home.actions.projects') }}
        </router-link>
        <router-link to="/contato" class="btn btn-secondary">
          {{ $t('home.actions.contact') }}
        </router-link>
      </div>
    </section>

    <!-- Atalhos -->
    <section class="shortcuts-grid">
      <router-link 
        v-for="(tile, index) in homeShortcutTiles" 
        :key="index" 
        :to="tile.to"
        class="shortcut-card glass glass-sheen animate-rise"
        :style="{ animationDelay: `${120 + index * 90}ms` }"
      >
        <div class="card-content">
          <p class="card-hint">{{ $t(tile.hintKey) }}</p>
          <p class="card-label">
            {{ $t(tile.labelKey) }} <span class="arrow">→</span>
          </p>
        </div>
      </router-link>
    </section>

    <!-- Números -->
    <section class="stats-container glass glass-sheen animate-rise">
      <div v-for="(stat, index) in homeStats" :key="index" class="stat-item">
        <p class="stat-value text-gradient">{{ stat.value }}</p>
        <p class="stat-label">{{ $t(stat.labelKey) }}</p>
      </div>
    </section>
    
  </main>
</template>

<script setup>
import { homeShortcutTiles, homeStats } from '../data/home-content.js';

const currentYear = new Date().getFullYear();
</script>

<style scoped lang="scss">
.home-container {
  max-width: 1024px;
  margin: 0 auto;
  padding: 3.5rem 1rem;
}

.hero-section {
  .subtitle {
    font-size: 0.75rem;
    font-weight: 600;
    text-transform: uppercase;
    letter-spacing: 0.24em;
    color: var(--accent);
  }
  
  .title {
    margin-top: 1rem;
    font-size: 3.5rem;
    line-height: 1.05;
    font-weight: 700;
  }
  
  .description {
    margin-top: 1.25rem;
    max-width: 36rem;
    font-size: 1.125rem;
    line-height: 1.6;
    color: var(--muted-foreground);
  }
}

.cta-group {
  margin-top: 1.75rem;
  display: flex;
  flex-wrap: wrap;
  gap: 0.75rem;

  .btn {
    padding: 0.75rem 1.5rem;
    border-radius: 9999px;
    font-size: 0.875rem;
    font-weight: 600;
    text-decoration: none;
    transition: all 0.3s ease;
    
    &.btn-primary {
      color: var(--foreground);
      &:hover { transform: translateY(-2px); }
    }
    
    &.btn-secondary {
      border: 1px solid var(--glass-border);
      color: var(--muted-foreground);
      &:hover { color: var(--foreground); }
    }
  }
}

.shortcuts-grid {
  margin-top: 3.5rem;
  display: grid;
  gap: 1rem;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));

  .shortcut-card {
    display: flex;
    flex-direction: column;
    justify-content: flex-end;
    min-height: 11rem;
    border-radius: 1.5rem;
    padding: 1.5rem;
    text-decoration: none;
    color: inherit;
    transition: all 0.3s ease;
    
    &:hover {
      transform: translateY(-4px);
      background-color: var(--glass-strong);
      .arrow { transform: translateX(4px); }
    }
    
    .card-hint {
      font-size: 0.75rem;
      text-transform: uppercase;
      letter-spacing: 0.18em;
      color: var(--muted-foreground);
    }
    
    .card-label {
      margin-top: 0.5rem;
      font-family: var(--font-display);
      font-size: 1.5rem;
      font-weight: 600;
      display: flex;
      align-items: center;
      gap: 0.5rem;
      
      .arrow {
        color: var(--accent);
        transition: transform 0.3s;
      }
    }
  }
}

.stats-container {
  margin-top: 1rem;
  display: grid;
  gap: 1.5rem;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  border-radius: 1.5rem;
  padding: 2rem;
  
  .stat-value {
    font-family: var(--font-display);
    font-size: 1.875rem;
    font-weight: 700;
  }
  
  .stat-label {
    margin-top: 0.25rem;
    font-size: 0.875rem;
    color: var(--muted-foreground);
  }
}
</style>
