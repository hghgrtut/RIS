import React from 'react';
import StudentItem from "./StudentItem";

const StudentList = ({students, title, remove, edit}) => {

    if (!students.length) {
        return (
            <h1 style={{textAlign: 'center'}}>
                Студенты не найдены!
            </h1>
        )
    }

    return (
        <div>
            <h1 style={{textAlign: 'center'}}>
                {title}
            </h1>
                {students.map((student, index) =>
                    <StudentItem 
                        key={student.id}
                        remove={remove} 
                        edit={edit} 
                        number={index + 1} 
                        student={student} 
                    />
                )}
        </div>
    );
};

export default StudentList;