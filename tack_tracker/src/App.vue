<template>
<div class="app">
    <h1>Страница с сообщен.</h1>
    <my-button 
        class="app__button" 
        @click="showDialog"
    >
    Создать проектов</my-button>
    <my-dialog
        v-model:show="dialogVisable"
    >
    <project-form
        @create="createMessage"
    />
    </my-dialog>        
    <project-list
        :messages="messages"
        @remove="removeMessage"
    />
    

   
</div>
</template>

<script>
import ProjectForm from '@/components/MessageForm';
import ProjectList from '@/components/MessageList';
import MyDialog from '@/components/UI/MyDialog'
import MyButton from '@/components/UI/MyButton'
import axios from 'axios';

export default {
    components: {
        ProjectForm, ProjectList, MyDialog, MyButton
    },

    data() {
        return {
            messages: [],
            dialogVisable: false
        }
    },
    methods: {
        showDialog() {
            this.dialogVisable = true;
        },

        async fetchMessage(){
            try{
                const response = await axios.get('http://localhost:8081/messages');
                this.projects = response.data
            } catch(e) {
                console.log(e);
            }
        },
        async createMessage(message) {
            const response = await axios.post('http://localhost:8081/messages', message);
            this.messages.push(response.data);
            this.dialogVisable = false;
        },
        async removeMessage(id) {
            await axios.delete(`http://localhost:8081/messages/${id}`)
            this.fetchMessage();
        },
        async updateMessage(id, message) {
            const response = await axios.put(`http://localhost:8081/messages${id}`, project)
        }
    },
    mounted() {
            this.fetchMessage();
        }
} 
</script>

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}
.app {
    padding: 10px;
}
.app__button {
    padding: 15px;
    margin-top: 15px;
    align-content: flex-start;
}

</style>
