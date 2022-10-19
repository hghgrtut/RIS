<template >
  <div>
    <form @submit.prevent>
        <h3>Создание проекта</h3>
        <my-input
        v-model="project.name" 
        placeholder="Название"
        />
        <my-button
        class="button"
        @click="createProject" 
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
            project: {
                name: ''
        
        }
        }
    },

    methods: {
        createProject() {
            this.$emit('create', this.project)
            this.project = {
                name: ''
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