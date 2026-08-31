<template>
  <main class="about-container">
    <SectionHeading
      :eyebrow="$t('about.heading.eyebrow')"
      :title="$t('about.heading.title')"
      :description="$t('about.heading.description')"
    />

    <div class="values-grid">
    <GlassCard v-for="v in aboutValues" :key="v.titleKey">
        <h2 class="value-title">{{ $t(v.titleKey) }}</h2>
        <p class="value-text">{{ $t(v.textKey) }}</p>
    </GlassCard>
    </div>

    <GlassCard class="stack-card">
      <h2 class="stack-title">{{ $t('about.stackTitle') }}</h2>
      <div class="stack-grid">
        <div v-for="s in aboutSkillGroups" :key="s.groupKey">
        <p class="group-label">{{ $t(s.groupKey) }}</p>
        <ul class="skill-list">
            <li v-for="item in s.items" :key="item.key || item.label" class="skill-tag glass">
            {{ item.key ? $t(item.key) : item.label }}
            </li>
        </ul>
        </div>
        </div>

    </GlassCard>
  </main>
</template>

<script setup>
import SectionHeading from '../components/ui/SectionHeading.vue';
import GlassCard from '../components/ui/GlassCard.vue';
import { aboutValues, aboutSkillGroups } from '../data/about-content.js';
</script>

<style scoped lang="scss">
.about-container {
  max-width: 1024px;
  margin: 0 auto;
  padding: 3.5rem 1rem;
}

/* Grid de Valores (3 colunas) */
.values-grid {
  margin-top: 2.5rem;
  display: grid;
  gap: 1rem;
  grid-template-columns: 1fr;
  
  @media (min-width: 768px) {
    grid-template-columns: repeat(3, 1fr);
  }

  .value-title {
    font-family: var(--font-display);
    font-size: 1.125rem;
    font-weight: 600;
  }

  .value-text {
    margin-top: 0.5rem;
    font-size: 0.875rem;
    line-height: 1.625;
    color: var(--muted-foreground);
  }
}

/* Card de Stack */
.stack-card {
  margin-top: 1rem;

  .stack-title {
    font-family: var(--font-display);
    font-size: 1.25rem;
    font-weight: 600;
  }
}

/* Grid da Stack (3 colunas) */
.stack-grid {
  margin-top: 1.5rem;
  display: grid;
  gap: 1.5rem;
  grid-template-columns: 1fr;
  
  @media (min-width: 640px) {
    grid-template-columns: repeat(3, 1fr);
  }

  .group-label {
    font-size: 0.75rem;
    text-transform: uppercase;
    letter-spacing: 0.18em;
    color: var(--accent);
  }

  .skill-list {
    margin-top: 0.75rem;
    display: flex;
    flex-wrap: wrap;
    gap: 0.5rem;
    list-style: none;
  }

  .skill-tag {
    border-radius: 9999px;
    padding: 0.25rem 0.75rem;
    font-size: 0.75rem;
    color: var(--muted-foreground);
  }
}
</style>
