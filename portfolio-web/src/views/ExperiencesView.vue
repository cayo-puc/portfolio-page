<template>
  <main class="experiences-container">
    <SectionHeading
      eyebrow="Experiências"
      title="Uma linha do tempo honesta"
      description="Onde trabalhei, o que era minha responsabilidade e o impacto que ficou depois que eu saí."
    />

    <ol class="timeline-list">
      <GlassCard
        as="li"
        v-for="job in experienceTimeline"
        :key="job.role + job.period"
        class="timeline-card animate-rise"
      >
        <div class="job-header">
          <h2 class="job-role">
            {{ job.role }} <span class="job-company">· {{ job.company }}</span>
          </h2>
          <span class="job-period">{{ job.period }}</span>
        </div>
        
        <ul class="job-points">
          <li v-for="p in job.points" :key="p" class="point-item">
            <span aria-hidden="true" class="bullet"></span>
            {{ p }}
          </li>
        </ul>
      </GlassCard>
    </ol>
  </main>
</template>

<script setup>
import SectionHeading from '../components/ui/SectionHeading.vue';
import GlassCard from '../components/ui/GlassCard.vue';
import { experienceTimeline } from '../data/experiences-content.js';
</script>

<style scoped lang="scss">
.experiences-container {
  max-width: 1024px;
  margin: 0 auto;
  padding: 3.5rem 1rem;
}

.timeline-list {
  margin-top: 2.5rem;
  display: flex;
  flex-direction: column;
  gap: 1rem;
  list-style: none;
}

.job-header {
  display: flex;
  flex-direction: column;
  gap: 0.25rem;
  
  @media (min-width: 640px) {
    flex-direction: row;
    align-items: baseline;
    justify-content: space-between;
  }
}

.job-role {
  font-family: var(--font-display);
  font-size: 1.125rem;
  font-weight: 600;
  color: var(--foreground);
}

.job-company {
  color: var(--muted-foreground);
}

.job-period {
  font-size: 0.75rem;
  text-transform: uppercase;
  letter-spacing: 0.16em;
  color: var(--accent);
}

.job-points {
  margin-top: 1rem;
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
  font-size: 0.875rem;
  line-height: 1.625;
  color: var(--muted-foreground);
  list-style: none;
}

.point-item {
  display: flex;
  gap: 0.75rem;
}

.bullet {
  margin-top: 0.5rem;
  height: 0.375rem;
  width: 0.375rem;
  flex-shrink: 0;
  border-radius: 9999px;
  background-color: var(--accent);
}
</style>