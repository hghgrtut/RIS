import React, {useEffect, useState} from 'react';
import './App.css';
import RestService from "./API/RestService";
import {useFetching} from "./hooks/useFetching";
import MyButton from "./components/UI/button/MyButton";
import AddStudentForm from "./components/AddStudentForm";
import MyModal from "./components/UI/MyModal/MyModal";
import StudentList from "./components/StudentList";

function App() {

  const [students, setStudents] = useState([]);
  const [modalAdd, setModalAdd] = useState(false);

  const [fetchStudents, isStudentsLoading, StudentError] = useFetching(async () => {
      const response = await RestService.getAll();
      setStudents([...response.data])
      console.log(...response.data)
  })

  const [fetchEditStudent, editStudentLoading, editStudentError] = useFetching(async (editedStudent) => {
    await RestService.editStudent(editedStudent)
    fetchStudents()
  })

  const [fetchRemoteStudent, editRemoteLoading, remoteStudentError] = useFetching(async (removableStudent) => {
    await RestService.removeStudent(removableStudent)
    fetchStudents()
  })

  const [fetchAddStudent, editAddLoading, addStudentError] = useFetching(async (addStudent) => {
    await RestService.addStudent(addStudent)
    console.log(addStudent)
    fetchStudents()
  })

  useEffect(() => {
    fetchStudents()
  }, [])

  const editStudent = (editedStudent) => {
    fetchEditStudent(editedStudent)
  } 

  const createStudent = (newStudent) => {
      setModalAdd(false)
      fetchAddStudent(newStudent)
  }

  const removeStudent = (removableStudent) => {
      fetchRemoteStudent(removableStudent)
  }

  return (
    <div className="App">
      <MyButton style={{marginTop: 30}} onClick={() => setModalAdd(true)}>
          Создать студента
      </MyButton>
      <MyModal visible={modalAdd} setVisible={setModalAdd}>
          <AddStudentForm create={createStudent} count={students.count}/>
      </MyModal>
      <hr style={{margin: '15px 0'}}/>
      {StudentError &&
      <h1>Произошла ошибка ${StudentError}</h1>
      }
      <StudentList 
        key={124}
        remove={removeStudent} 
        edit={editStudent} 
        students={students} 
        title="Список студентов"
      />
    </div>
  );
}

export default App;
