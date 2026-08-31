<template>
  <footer class="site-footer">
    <div class="footer-container glass glass-sheen">
      <p>© {{ currentYear }} Anthony Santos</p>
      <p>Feito com atenção aos detalhes e muito vidro fosco.</p>
    </div>
  </footer>
</template>

<script setup>
const currentYear = new Date().getFullYear();
</script>

<style scoped lang="scss">
.site-footer {
  max-width: 1024px;
  margin: 0 auto;
  padding: 4rem 1rem 2.5rem;
}

.footer-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  gap: 0.75rem;
  border-radius: 1.5rem;
  padding: 1.25rem 1.5rem;
  font-size: 0.875rem;
  color: var(--muted-foreground);
  
  @media (min-width: 640px) {
    flex-direction: row;
  }
}
</style>