import React, {useEffect, useState} from 'react';
import MyInput from "./UI/input/MyInput";
import MyButton from "./UI/button/MyButton";
import { useInput } from '../hooks/useInput';



const AddStudentForm = ({create, count}) => {

    const firstName = useInput('', {isEmpty: true, minLength: 2, maxLength: 15, isLetters: true})
    const lastName = useInput('', {isEmpty: true, minLength: 2, maxLength: 30, isLettersAndLine: true})
    const age = useInput('', {isEmpty: true, minLength:1, maxLength: 3, isDigit: true})
    const group = useInput('', {isEmpty: true, minLength: 4, maxLength: 6, isLetterLineDigit: true})
    const phoneNumber = useInput('', {isEmpty: true, minLength:13, length: 13, isPN: true})
    const mail = useInput('', {isEmpty: true, minLength:5, isMail: true})
    
    const [student, setStudent] = useState(
        {
            id: '',
            firstName: '',
            lastName: '',
            age: '',
            group: '',
            phoneNumber: '',
            mail: ''
        }
    )    

    const addNewStudent = (e) => {
        e.preventDefault()
        const newStudent = (
            {
                id: count+1,
                firstName: firstName.value,
                lastName: lastName.value,
                age: age.value,
                group: group.value,
                phoneNumber: phoneNumber.value,
                mail: mail.value
            }
        )
        console.log(firstName)
        console.log(lastName)
        console.log(age)
        console.log(group)
        console.log(phoneNumber)
        console.log(mail)
        create(newStudent)
        setStudent(
            {
                id: '',
                firstName: '',
                lastName: '',
                age: '',
                group: '',
                phoneNumber: '',
                mail: ''
            }
        )
    }

    return (
        <form>
            {(firstName.isDirty && firstName.isEmpty) && <div style={{color:'red'}}>Поле не может быть пустым</div>}
            {(firstName.isDirty && firstName.minLengthError && !firstName.isEmpty) && <div style={{color:'red'}}>Поле короткое</div>}
            {(firstName.isDirty && firstName.maxLengthError) && <div style={{color:'red'}}>Поле длинное</div>}
            {(firstName.isDirty && firstName.isLettersError && !firstName.maxLengthError && !firstName.isEmpty) && <div style={{color:'red'}}>Поле содержит недопустимые символы</div>}
            <MyInput
                value={firstName.value}
                onChange={e => firstName.onChange(e)}
                onBlur={e => firstName.onBlur(e)}
                name='firstName'
                type="text"
                placeholder="Имя"
            />
            {(lastName.isDirty && lastName.isEmpty) && <div style={{color:'red'}}>Поле не может быть пустым</div>}
            {(lastName.isDirty && lastName.minLengthError && !lastName.isEmpty) && <div style={{color:'red'}}>Поле короткое</div>}
            {(lastName.isDirty && lastName.maxLengthError) && <div style={{color:'red'}}>Поле длинное</div>}
            {(lastName.isDirty && lastName.isLettersAndLineError && !lastName.maxLengthError && !lastName.isEmpty) && <div style={{color:'red'}}>Поле содержит недопустимые символы</div>}
            <MyInput
                value={lastName.value}
                onChange={e => lastName.onChange(e)}
                onBlur={e => lastName.onBlur(e)}
                name='lastName'
                type="text"
                placeholder="Фамилия"
            />
            {(age.isDirty && age.isEmpty) && <div style={{color:'red'}}>Поле не может быть пустым</div>}
            {(age.isDirty && age.maxLengthError) && <div style={{color:'red'}}>Поле длинное</div>}
            {(age.isDirty && age.isDigitError && !age.maxLengthError && !age.isEmpty) && <div style={{color:'red'}}>Поле содержит недопустимые символы</div>}
            <MyInput
                value={age.value}
                onChange={e => age.onChange(e)}
                onBlur={e => age.onBlur(e)}
                name='age'
                type="text"
                placeholder="Возраст"
            />
            {(group.isDirty && group.isEmpty) && <div style={{color:'red'}}>Поле не может быть пустым</div>}
            {(group.isDirty && group.minLengthError && !group.isEmpty) && <div style={{color:'red'}}>Поле короткое</div>}
            {(group.isDirty && group.maxLengthError) && <div style={{color:'red'}}>Поле длинное</div>}
            {(group.isDirty && group.isLetterLineDigitError && !group.maxLengthError && !group.isEmpty) && <div style={{color:'red'}}>Поле содержит недопустимые символы</div>}
            <MyInput
                value={group.value}
                onChange={e => group.onChange(e)}
                onBlur={e => group.onBlur(e)}
                name='group'
                type="text"
                placeholder="Группа"
            />
            {(phoneNumber.isDirty && phoneNumber.isEmpty) && <div style={{color:'red'}}>Поле не может быть пустым</div>}
            {(phoneNumber.isDirty && phoneNumber.lengthError && !phoneNumber.isEmpty) && <div style={{color:'red'}}>Поле неправильной длины</div>}
            {(phoneNumber.isDirty && phoneNumber.isPNError && !phoneNumber.lengthError && !phoneNumber.isEmpty) && <div style={{color:'red'}}>Поле содержит недопустимые символы</div>}
            <MyInput
                value={phoneNumber.value}
                onChange={e => phoneNumber.onChange(e)}
                onBlur={e => phoneNumber.onBlur(e)}
                name='phoneNumber'
                type="text"
                placeholder="Номер телефона"
            />
            {(mail.isDirty && mail.isEmpty) && <div style={{color:'red'}}>Поле не может быть пустым</div>}
            {(mail.isDirty && mail.mailError && !mail.isEmpty) && <div style={{color:'red'}}>Поле содержит недопустимые символы</div>}
            <MyInput
                value={mail.value}
                onChange={e => mail.onChange(e)}
                onBlur={e => mail.onBlur(e)}
                name='mail'
                type="text"
                placeholder="Эл.почта"
            />
            <MyButton 
                disabled={
                    !firstName.isInputValid || !lastName.isInputValid || !age.isInputValid 
                    || !group.isInputValid || !phoneNumber.isInputValid|| !mail.isInputValid
                }
                
                onClick={addNewStudent}
            >
                Создать cтудента
            </MyButton>
        </form>
    );
};

export default AddStudentForm;