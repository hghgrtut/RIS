import {useState, useEffect} from "react";

const useValidation = (value, validations) => {
   
    const [isEmpty, setIsEmpty] = useState(true)
    const [minLengthError, setMinLengthError] = useState(true)
    const [maxLengthError, setMaxLengthError] = useState(false)
    const [lengthError, setLengthError] = useState(false)
    const [mailError, setMailError] = useState(false)
    const [isLettersError, setIsLettersError] = useState(false)
    const [isLettersAndLineError, setIsLettersAndLineError] = useState(false)
    const [isDigitError, setIsDigitError] = useState(false)
    const [isLetterLineDigitError, setIsLetterLineDigitError] = useState(false)
    const [isPNError, setIsPNError] = useState(false)
    const [isInputValid, setIsInputValid] = useState(false)

    useEffect(() => {
        for (const validation in validations) {
            switch (validation){
                case 'isEmpty':
                    value ? setIsEmpty(false) : setIsEmpty(true)
                    break
                case 'minLength':
                    value.length < validations[validation] ? setMinLengthError(true) : setMinLengthError(false)
                    break
                case 'maxLength':
                    value.length > validations[validation] ? setMaxLengthError(true) : setMaxLengthError(false)
                    break
                case 'length':
                    value.length !== validations[validation] ? setLengthError(true) : setLengthError(false)
                    break
                case 'isEmpty':
                    value ? setIsEmpty(false) : setIsEmpty(true)
                    break
                case 'isMail':
                    const re = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g;
                    re.test(String(value)) ? setMailError(false) : setMailError(true)
                    break
                case 'isLetters':
                    const reLet = /^[A-Za-zА-Яа-я]+$/;
                    reLet.test(String(value)) ? setIsLettersError(false) : setIsLettersError(true)
                    break
                case 'isLettersAndLine':
                    const reLetLine = /^[A-Za-zА-Яа-я\-]+$/;
                    reLetLine.test(String(value)) ? setIsLettersAndLineError(false) : setIsLettersAndLineError(true)
                    break
                case 'isDigit':
                    const reDig = /^[0-9]+$/;
                    reDig.test(String(value)) ? setIsDigitError(false) : setIsDigitError(true)
                    break
                case 'isLetterLineDigit':
                    const reLetterLineDigit = /^[0-9A-Za-zА-Яа-я\-]+$/;
                    reLetterLineDigit.test(String(value)) ? setIsLetterLineDigitError(false) : setIsLetterLineDigitError(true)
                    break 
                case 'isPN':
                    const rePN = /^\+[0-9]+$/;
                    rePN.test(String(value)) ? setIsPNError(false) : setIsPNError(true)
                    break
                }
        }
    }, [value])

    useEffect(() => {
        if (isEmpty || minLengthError || mailError || maxLengthError ||
            isLettersError || isLettersAndLineError || isDigitError || 
            isLetterLineDigitError || isPNError || lengthError) setIsInputValid(false)
        else {
            setIsInputValid(true)
        }
    }, [isEmpty,
        minLengthError,
        mailError,
        maxLengthError,
        isLettersError,
        isLettersAndLineError,
        isDigitError,
        isLetterLineDigitError,
        isPNError,
        lengthError])

    return {
        isEmpty,
        minLengthError,
        mailError,
        maxLengthError,
        isLettersError,
        isLettersAndLineError,
        isDigitError,
        isLetterLineDigitError,
        isPNError,
        lengthError,
        isInputValid
    }

}

export const useInput = (initialValue, validations) => {
    
    const [value, setValue] = useState(initialValue)
    const [isDirty, setIsDirty] = useState(false)
    const valid = useValidation(value, validations)

    const onChange = (e) => {
        setValue(e.target.value)
        console.log(valid.maxLengthError)
    }

    const onBlur = () => {
        setIsDirty(true)
    }

    return{
        value,
        onChange, 
        onBlur,
        isDirty,
        ...valid
    }

}