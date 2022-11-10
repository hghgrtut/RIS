// подключение
import axios from "axios";
import React from "react";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

// функция для работы с данной страницей (создано автоматически)
const Add = () => {
  // переменаая для обработки состояния полей оператора 
  const [operator, setOperator] = useState({
    name: "",
    desc: "",
    price: "",
  }); 

  // для ошибок
  const [error,setError] = useState(false)
  
  // для навигации
  const navigate = useNavigate();

  // функция для изменения полей
  const handleChange = (e) => {
    setOperator((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  // пост запрос на сервер 8800
  const handleClick = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:8800/operators", operator);
      navigate("/");
    } catch (err) {
      console.log(err);
      setError(true)
    }
  };

  // разметка страницы
  return (
    <div className="form">
      <h1>Создание нового тарифного плана</h1>
      <input
        type="text"
        placeholder="Название тарифного плана"
        name="name"
        onChange={handleChange}
      />
      <input
        type="text"
        placeholder="Описание тарифного плана"
        name="desc"
        onChange={handleChange}
      />
      <input
        type="number"
        placeholder="Абоненская плата"
        name="price"
        onChange={handleChange}
      />
      <button onClick={handleClick}>Добавить</button>
      {error && "Ошибка!"}
      <Link to="/">Вернуться обратно</Link>
    </div>
  );
};

export default Add;
