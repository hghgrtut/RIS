import axios from "axios";
import React, { useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom"; //импорт библиотек

const Update = () => {
  const [operator, setOperator] = useState({
    name: "",
    desc: "",
    price: ""
  });
  const [error,setError] = useState(false)

  const location = useLocation();
  const navigate = useNavigate();

  const operatorId = location.pathname.split("/")[2];

  const handleChange = (e) => {
    setOperator((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleClick = async (e) => {
    e.preventDefault();

    try {
      await axios.put(`http://localhost:8800/operators/${operatorId}`, operator);
      navigate("/");
    } catch (err) {
      console.log(err);
      setError(true);
    } //обнаружение ошибок
  };

  return (
    <div className="form">
      <h1>Изменение тарифного плана</h1>
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
        placeholder="Абонентская плата"
        name="price"
        onChange={handleChange}
      />
      <button onClick={handleClick}>Изменить</button>
      {error && "Ошибка!"}
      <Link to="/">Вернуться обратно</Link>
    </div>
  );
};

export default Update;
