import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const Nails = () => {
  const [nails, setNails] = useState([]);

  const fetchAllNails = async () => {
    try {
      const res = await axios.get("http://localhost:8800/nails");
      setNails(res.data);
      console.log(nails);
    } catch (err) {
      console.log(err);
    }
  };

  // eslint-disable-next-line react-hooks/exhaustive-deps 
  useEffect(() => { fetchAllNails(); }, []);

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8800/nails/${id}`);
      fetchAllNails();
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <div>
      <h1>У меня самый плохой маникюр</h1>
      <div className="nails">
        {nails.map((nail) => (
          <div key={nail.id} className="nail">
            <h2>{nail.name}</h2>
            <p>{nail.desc}</p>
            <span>{nail.price} $</span>
            <button onClick={() => handleDelete(nail.id)}>Удалить</button>
            <button>
              <Link
                to={`/update/${nail.id}`}
                style={{ color: "inherit", textDecoration: "none" }}
              >
                Обновить
              </Link>
            </button>
          </div>
        ))}
      </div>
      <div>
        <hr />
        <h4>Страница для администратора</h4>
      </div>
      <div>
        <button className="fetch" onClick={() => fetchAllNails()}>Обновить базу</button>
        <button>
        <Link to="/add" style={{ color: "inherit", textDecoration: "none" }}>
          Добавить новый маникюр
        </Link>
      </button>
      </div>
    </div>
  );
};

export default Nails;