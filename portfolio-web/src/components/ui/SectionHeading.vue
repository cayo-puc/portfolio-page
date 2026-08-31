<template>
  <header class="section-heading animate-rise">
    <p class="eyebrow">{{ eyebrow }}</p>
    <h1 class="title text-gradient">{{ title }}</h1>
    <p v-if="description" class="description">{{ description }}</p>
  </header>
</template>

<script setup>
defineProps({
  eyebrow: { type: String, required: true },
  title: { type: String, required: true },
  description: { type: String, default: '' }
});
</script>

<style scoped lang="scss">
.section-heading {
  max-width: 42rem;
}

.eyebrow {
  font-size: 0.75rem;
  font-weight: 600;
  text-transform: uppercase;
  letter-spacing: 0.22em;
  color: var(--accent);
}

.title {
  margin-top: 0.75rem;
  font-size: 1.875rem;
  line-height: 1.2;
  font-weight: 700;
  
  @media (min-width: 768px) {
    font-size: 3rem;
  }
}

.description {
  margin-top: 1rem;
  font-size: 1rem;
  line-height: 1.625;
  color: var(--muted-foreground);
}
</style>