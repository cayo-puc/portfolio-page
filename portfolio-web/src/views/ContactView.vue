<template>
  <main class="contact-container">
    <SectionHeading
      eyebrow="Contato"
      title="Vamos construir algo juntos"
      description="Sinta-se à vontade para me mandar um e-mail ou se conectar através das redes sociais. Respondo em até um dia útil."
    />

    <div class="channels-wrapper">
      <GlassCard class="channels-card animate-rise">
        <h2 class="card-title">Canais disponíveis</h2>
        
        <ul class="channels-list">
          <li v-for="channel in contactChannels" :key="channel.label">
            <p class="channel-label">{{ channel.label }}</p>
            <a 
              :href="channel.href" 
              target="_blank" 
              rel="noopener noreferrer" 
              class="channel-link"
            >
              {{ channel.value }}
            </a>
          </li>
        </ul>
        
        <p class="availability-text">
          Disponível para colaborações remotas — fuso de São Paulo (UTC−3).
        </p>
      </GlassCard>
    </div>
  </main>
</template>

<script setup>
import SectionHeading from '../components/ui/SectionHeading.vue';
import GlassCard from '../components/ui/GlassCard.vue';
import { contactChannels } from '../data/contact-content.js';
</script>

<style scoped lang="scss">
.contact-container {
  max-width: 1024px;
  margin: 0 auto;
  padding: 3.5rem 1rem;
}

.channels-wrapper {
  margin-top: 2.5rem;
  display: flex;
  justify-content: flex-start;
}

.channels-card {
  width: 100%;
  max-width: 28rem; /* Limita a largura do card para não esticar muito sem o formulário */
}

.card-title {
  font-family: var(--font-display);
  font-size: 1.125rem;
  font-weight: 600;
  color: var(--foreground);
}

.channels-list {
  margin-top: 1.5rem;
  display: flex;
  flex-direction: column;
  gap: 1.25rem;
  list-style: none;
}

.channel-label {
  font-size: 0.75rem;
  text-transform: uppercase;
  letter-spacing: 0.16em;
  color: var(--muted-foreground);
}

.channel-link {
  display: inline-block;
  margin-top: 0.25rem;
  font-size: 0.875rem;
  color: var(--accent);
  text-decoration: underline;
  text-underline-offset: 4px;
  transition: opacity 0.2s;

  &:hover {
    opacity: 0.8;
  }
}

.availability-text {
  margin-top: 2rem;
  font-size: 0.875rem;
  line-height: 1.625;
  color: var(--muted-foreground);
}
</style>