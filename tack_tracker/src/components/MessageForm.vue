<template >
  <div>
    <form @submit.prevent>
        <h3>Создание сообщен.</h3>
        <my-input
        v-model="message.body" 
        placeholder="body"
        />
        <my-button
        class="button"
        @click="createMessage" 
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
            message: {
                body: ''
        
        }
        }
    },

    methods: {
        createMessage() {
            this.$emit('create', this.message)
            this.message = {
                body: ''
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