<template >
    <div v-if="books.length > 0" >
        <h3>Список постов</h3>
        <Book v-for="book in books"
        :project="book"
        :key="book.id"
        @click="$emit('remove', book.id)"
        />
    </div>
    <h2 v-else> Пусто</h2>
  
</template>

<script>
import Book from '@/components/Book'
export default {
    components: {
        Book
    },

    props: {
        books: {
            type: Array,
            required: true
        }
    }

}
</script>

<style scoped>
</style>