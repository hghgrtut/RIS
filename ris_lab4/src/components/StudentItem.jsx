import React, {useState} from 'react';
import EditStudentForm from './EditStudentForm';
import MyButton from "./UI/button/MyButton";
import MyModal from './UI/MyModal/MyModal';

const StudentItem = (props) => {
    
    const [modalEdit, setModalEdit] = useState(false);

    return (
        <div className="stud">
            <div className="stud__content">
                <strong>
                    {props.student.id}. {props.student.firstName} {props.student.lastName} 
                    </strong>
                <div>
                    {props.student.group}, {props.student.phoneNumber}, {props.student.mail}
                </div>
            </div>
            <div className="stud__btns">
                <MyButton onClick={() => props.remove(props.student)}>
                    Удалить
                </MyButton>
                <MyButton onClick={() => setModalEdit(true)}>
                    Изменить
                </MyButton>
                <MyModal visible={modalEdit} setVisible={setModalEdit}>
                    <EditStudentForm edit={props.edit} student={props.student} setModal={setModalEdit}/>
                </MyModal>
            </div>
        </div>
    );
};

export default StudentItem;