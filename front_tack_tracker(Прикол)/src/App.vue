<template>
<div class="app">
    <h1>Страница с проектами</h1>
    <my-button 
        class="app__button" 
        @click="showDialog"
    >
    Создать проектов</my-button>
    <my-dialog
        v-model:show="dialogVisable"
    >
    <project-form
        @create="createProject"
    />
    </my-dialog>        
    <project-list
        :projects="projects"
        @remove="removeProject"
    />
    

   
</div>
</template>

<script>
import ProjectForm from '@/components/ProjectForm';
import ProjectList from '@/components/ProjectList';
import MyDialog from '@/components/UI/MyDialog'
import MyButton from '@/components/UI/MyButton'
import axios from 'axios';

export default {
    components: {
        ProjectForm, ProjectList, MyDialog, MyButton
    },

    data() {
        return {
            projects: [],
            dialogVisable: false
        }
    },
    methods: {
        showDialog() {
            this.dialogVisable = true;
        },

        async fetchProject(){
            try{
                const response = await axios.get('http://localhost:8081/api/v1/projects');
                this.projects = response.data
            } catch(e) {
                console.log(e);
            }
        },
        async createProject(project) {
            const response = await axios.post('http://localhost:8081/api/v1/projects', project);
            this.projects.push(response.data);
            this.dialogVisable = false;
        },
        async removeProject(id) {
            await axios.delete(`http://localhost:8081/api/v1/projects/${id}`)
            this.fetchProject();
        },
        async updateProject(id, project) {
            const response = await axios.put(`http://localhost:8081/api/v1/projects/${id}`, project)
        }
    },
    mounted() {
            this.fetchProject();
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
