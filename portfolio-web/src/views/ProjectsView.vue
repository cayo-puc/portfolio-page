<template>
  <main class="projects-container">
    <SectionHeading
      :eyebrow="$t('projects.heading.eyebrow')"
      :title="$t('projects.heading.title')"
      :description="$t('projects.heading.description')"
    />

    <ul class="projects-grid">
      <GlassCard
        as="li"
        v-for="(p, i) in projectsList"
        :key="p.name"
        class="project-card animate-rise"
        :style="{ animationDelay: `${i * 80}ms` }"
      >
        <div class="card-header">
          <h2 class="project-title">{{ p.nameKey ? $t(p.nameKey) : p.name }}</h2>
          <span class="project-year">{{ p.year }}</span>
        </div>
        
        <p class="project-summary">{{ $t(p.summaryKey) }}</p>
        
        <ul class="stack-list">
          <li v-for="s in p.stack" :key="s" class="stack-pill">
            {{ s }}
          </li>
        </ul>
      </GlassCard>
    </ul>
  </main>
</template>

<script setup>
import SectionHeading from '../components/ui/SectionHeading.vue';
import GlassCard from '../components/ui/GlassCard.vue';
import { projectsList } from '../data/projects-content.js';
</script>

<style scoped lang="scss">
.projects-container {
  max-width: 1024px;
  margin: 0 auto;
  padding: 3.5rem 1rem;
}

/* Grid de Projetos (2 colunas no desktop) */
.projects-grid {
  margin-top: 2.5rem;
  display: grid;
  gap: 1rem;
  grid-template-columns: 1fr;
  list-style: none;
  
  @media (min-width: 768px) {
    grid-template-columns: repeat(2, 1fr);
  }
}

/* Efeito de Hover idêntico ao React */
.project-card {
  transition: all 0.3s ease;
  
  &:hover {
    transform: translateY(-4px);
    background-color: var(--glass-strong);
  }
}

.card-header {
  display: flex;
  align-items: baseline;
  justify-content: space-between;
  gap: 0.75rem;
}

.project-title {
  font-family: var(--font-display);
  font-size: 1.25rem;
  font-weight: 600;
  color: var(--foreground);
}

.project-year {
  font-size: 0.75rem;
  color: var(--muted-foreground);
}

.project-summary {
  margin-top: 0.75rem;
  font-size: 0.875rem;
  line-height: 1.625;
  color: var(--muted-foreground);
}

.stack-list {
  margin-top: 1.25rem;
  display: flex;
  flex-wrap: wrap;
  gap: 0.5rem;
  list-style: none;
}

.stack-pill {
  border: 1px solid var(--glass-border);
  border-radius: 9999px;
  padding: 0.25rem 0.75rem;
  font-size: 0.75rem;
  color: var(--accent);
}
</style>
