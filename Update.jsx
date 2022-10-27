import axios from "axios";
import React, { useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";

const Update = () => {
  const [nail, setNail] = useState({
    name: "",
    desc: "",
    price: ""
  });
  const [error,setError] = useState(false)

  const location = useLocation();
  const navigate = useNavigate();

  const nailId = location.pathname.split("/")[2];

  const handleChange = (e) => {
    setNail((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleClick = async (e) => {
    e.preventDefault();

    try {
      await axios.put(`http://localhost:8800/nails/${nailId}`, nail);
      navigate("/");
    } catch (err) {
      console.log(err);
      setError(true);
    }
  };

  return (
    <div className="form">
      <h1>Обновление маникюра</h1>
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
      <button onClick={handleClick}>Обновить</button>
      {error && "Произошла фатальная ошибка!"}
      <Link to="/">Вернуться к списку маникюров</Link>
    </div>
  );
};

export default Update;
