<template>
    <div class="project" @click.stop>
        <div class="project__body"> 
            <div>Название: {{project.name}}</div>
        </div>
        <div >
            <my-button
            @click="showUpdateDialog" 
            >
                Обновить
            </my-button>
            <my-button 
            @click="$emit('remove', project.id)"
            >Удалить
            </my-button>
        </div>
    </div>  
</template>

<script>
import MyButton from '@/components/UI/MyButton';
export default {
    components: {
        MyButton
    },
    props: {
        project: {
            type: Object, 
            require: true
        }
    },
    data(){
        return {
            dialogVisable: false
        }
    },
    methods: {
        showUpdateDialog() {
            this.dialogVisable = true;
        }
    }
}
</script>

<style scoped>
.project{
    margin-top: 20px;
    border: 2px solid green;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 15px;
}

.project__body{
    padding: 15px;
}
</style>