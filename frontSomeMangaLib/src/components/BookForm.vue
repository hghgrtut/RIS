<template >
  <div>
    <form @submit.prevent>
        <h3>Создание проекта</h3>
        <my-input
        v-model="book.name"
        type="text" 
        placeholder="Название"
        required
        />
        <my-input
        v-model="book.author"
        type="text" 
        placeholder="Автор"
        required
        />
        <my-input
        v-model="book.coutPages"
        placeholder="Количество страниц"
        required
        />
        <my-button
        class="button"
        @click="createBook" 
        >
        Добавить</my-button
        >
    </form>
  </div>
</template>

<script>
import MyButton from '@/components/UI/MyButton';
import MyInput from '@/components/UI/MyInput'
export default {
    components: {
        MyButton, MyInput
    },

    data() {
        return {
            book: {
                name: '',
                author: '',
                coutPages: 0
        
        }
        }
    },

    methods: {
        createBook() {
            this.$emit('create', this.book)
            this.book = {
                name: '',
                author: '',
                coutPages: 0
            }
        }
    }
}
</script>

<style scoped>

form{
    display: flex;
    flex-direction: column;
    
}
.button{
    padding: 15px;
    margin-top: 15px;
    align-self: flex-end;
}
</style>