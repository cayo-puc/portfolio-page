<template>
  <component :is="as" class="glass-card glass glass-sheen">
    <div class="content-wrapper">
      <slot></slot>
    </div>
  </component>
</template>

<script setup>
defineProps({
  as: {
    type: String,
    default: 'div'
  }
});
</script>

<style scoped lang="scss">
.glass-card {
  border-radius: 1.5rem;
  padding: 1.5rem;
  
  @media (min-width: 768px) {
    padding: 2rem;
  }
}

.content-wrapper {
  position: relative;
}
</style>