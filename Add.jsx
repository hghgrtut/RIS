import axios from "axios";
import React from "react";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const Add = () => {
  const [nail, setNail] = useState({
    name: "",
    desc: "",
    price: "",
  });
  const [error,setError] = useState(false)

  const navigate = useNavigate();

  const handleChange = (e) => {
    setNail((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleClick = async (e) => {
    e.preventDefault();
    try {
      await axios.post("http://localhost:8800/nails", nail);
      navigate("/");
    } catch (err) {
      console.log(err);
      setError(true)
    }
  };

  return (
    <div className="form">
      <h1>Добавление</h1>
      <input
        type="text"
        placeholder="Название маникюра"
        name="name"
        onChange={handleChange}
      />
      <input
        type="text"
        placeholder="Описание маникюра"
        name="desc"
        onChange={handleChange}
      />
      <input
        type="number"
        placeholder="Цена маникюра"
        name="price"
        onChange={handleChange}
      />
      <button onClick={handleClick}>Добавить</button>
      {error && "Произошла фатальная ошибка!"}
      <Link to="/">Все маникюры</Link>
    </div>
  );
};

export default Add;
