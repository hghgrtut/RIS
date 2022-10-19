<template >
    <div v-if="messages.length > 0" >
        <h3>Список постов</h3>
        <Message v-for="message in messages"
        :message="message"
        :key="message.id"
        @click="$emit('remove', message.id)"
        />
    </div>
    <h2 v-else> Пусто</h2>
  
</template>

<script>
import Message from '@/components/Message'
export default {
    components: {
        Message
    },

    props: {
        messages: {
            type: Array,
            required: true
        }
    }

}
</script>

<style scoped>
</style>