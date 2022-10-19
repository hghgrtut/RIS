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
    <book-form
        @create="createBook"
    />
    </my-dialog>        
    <book-list
        :books="books"
        @remove="removeBook"
    />
    
   
</div>
</template>

<script>
import BookForm from '@/components/BookForm';
import BookList from '@/components/BookList';
import MyDialog from '@/components/UI/MyDialog'
import MyButton from '@/components/UI/MyButton'
import axios from 'axios';

export default {
    components: {
        BookForm, BookList, MyDialog, MyButton
    },

    data() {
        return {
            books: [],
            dialogVisable: false
        }
    },
    methods: {
        showDialog() {
            this.dialogVisable = true;
        },

        async fetchBook(){
            try{
                const response = await axios.get('http://localhost:8081/api/v1/books');
                this.projects = response.data
            } catch(e) {
                console.log(e);
            }
        },
        async createBook(book) {
            const response = await axios.post('http://localhost:8081/api/v1/books', book);
            this.books.push(response.data);
            this.dialogVisable = false;
        },
        async removeBook(id) {
            await axios.delete(`http://localhost:8081/api/v1/books/${id}`)
            this.fetchBook();
        },
        async updateBook(id, book) {
            const response = await axios.put(`http://localhost:8081/api/v1/books/${id}`, book)
        }
    },
    mounted() {
            this.fetchBook();
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
