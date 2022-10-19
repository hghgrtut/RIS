import axios from "axios";

export default class RestService {
    static async getAll() {
        const response = await axios.get('http://localhost:3001/students/')
        return response;
    }

    static async removeStudent(removableStudent) {
        await axios.delete('http://localhost:3001/students/' + removableStudent.id)
    }

    static async addStudent(addStudent) {
        await axios.post('http://localhost:3001/students/', addStudent)
    }

    static async editStudent(editedStudent) {
        const data = editedStudent
        console.log(data)
        await axios.put('http://localhost:3001/students/' + data.id, data)
    }