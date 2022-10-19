<template >
    <div v-if="projects.length > 0" >
        <h3>Список постов</h3>
        <Post v-for="project in projects"
        :project="project"
        :key="project.id"
        @click="$emit('remove', project.id)"
        />
    </div>
    <h2 v-else> Пусто</h2>
  
</template>

<script>
import Post from '@/components/Project'
export default {
    components: {
        Post
    },

    props: {
        projects: {
            type: Array,
            required: true
        }
    }

}
</script>

<style scoped>
</style>