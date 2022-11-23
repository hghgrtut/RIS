import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const Operators = () => {
  const [operators, setOperators] = useState([]);

  // асинхорнный гет запрос с проверкой на наличие ошибок на сервер 8800
  const fetchAllOperators = async () => {
    try {
      const res = await axios.get("http://localhost:8800/operators");
      setOperators(res.data);
      console.log(operators);
    } catch (err) {
      console.log(err);
    }
  };

  // eslint-disable-next-line react-hooks/exhaustive-deps 
  // функция при выполнении дествий с объектом [] - *с любым
  useEffect(() => { fetchAllOperators() }, []);
 
  // удаление данных с сервера
  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8800/operators/${id}`);
      fetchAllOperators();
    } catch (err) {
      console.log(err);
    }
    // закоментировать
    //window.location.reload()
  };

  // разметка страницы
  return (
    <div>
      <h1>Список тарифов "Название оператора связи"</h1>
      <div className="operators">
        {operators.map((operator) => (
          <div key={operator.id} className="operator">
            <h2>{operator.name}</h2>
            <p>{operator.desc}</p>
            <span>{operator.price} у.е.</span>
            <button onClick={() => handleDelete(operator.id)}>Удалить</button>
            <button>
              <Link
                to={`/update/${operator.id}`}
                style={{ color: "inherit", textDecoration: "none" }}
              >
                Изменить
              </Link>
            </button>
          </div>
        ))}
      </div>
      <div>
        <hr/>
        <h4>Подвал</h4>
      </div>
      <div>
        <button className="fetch" onClick={() => fetchAllOperators()} >Обновить базу</button>
        <button>
        <Link to="/add" style={{ color: "inherit", textDecoration: "none" }}>
          Добавить тариф в список
        </Link>
      </button>
      </div>
    </div>
  );
};

export default Operators;