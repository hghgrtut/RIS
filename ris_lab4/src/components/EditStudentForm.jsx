import React, { useState } from 'react';
import MyInput from "./UI/input/MyInput";
import MyButton from "./UI/button/MyButton";

const EditStudentForm = ({ edit, student, setModal }) => {
    const [newStudent, setNewStudent] = useState(
        {
            id: student.id,
            firstName: student.firstName,
            lastName: student.lastName,
            age: student.age,
            group: student.group,
            phoneNumber: student.phoneNumber,
            mail: student.mail
        }
    )


    const EditStudent = (e) => {
        e.preventDefault()
        edit(newStudent)
        setNewStudent(
            {
                firstName: student.firstName,
                lastName: student.lastName,
                age: student.age,
                group: student.group,
                phoneNumber: student.phoneNumber,
                mail: student.mail
            }
        )
        setModal(false)
    }

    return (
        <form>
            <MyInput
                value={newStudent.firstName}
                onChange={e => setNewStudent({ ...newStudent, firstName: e.target.value })}
                type="text"
                placeholder="Имя"
            />
            <MyInput
                value={newStudent.lastName}
                onChange={e => setNewStudent({ ...newStudent, lastName: e.target.value })}
                type="text"
                placeholder="Фамилия"
            />
            <MyInput
                value={newStudent.age}
                onChange={e => setNewStudent({ ...newStudent, age: e.target.value })}
                type="text"
                placeholder="Возраст"
            />
            <MyInput
                value={newStudent.group}
                onChange={e => setNewStudent({ ...newStudent, group: e.target.value })}
                type="text"
                placeholder="Группа"
            />
            <MyInput
                value={newStudent.phoneNumber}
                onChange={e => setNewStudent({ ...newStudent, phoneNumber: e.target.value })}
                type="text"
                placeholder="Номер телефона"
            />
            <MyInput
                value={newStudent.mail}
                onChange={e => setNewStudent({ ...newStudent, mail: e.target.value })}
                type="text"
                placeholder="Почта"
            />
            <MyButton onClick={EditStudent}>Изменить cтудента</MyButton>
        </form>
    );
};

export default EditStudentForm;