import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const Books = () => {
  const [books, setBooks] = useState([]);

  const fetchAllBooks = async () => {
    try {
      const res = await axios.get("http://localhost:8800/books");
      setBooks(res.data);
    } catch (err) {
      console.log(err);
    }
  };

  useEffect(() => { fetchAllBooks(); }, []);

  console.log(books);

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:8800/books/${id}`);
      fetchAllBooks();
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <div>
      <h1>Lab5 ajax CRUD Vouk</h1>
      <div className="books">
        {books.map((book) => (
          <div key={book.id} className="book">
            <img src={require('./img/book.jpg')} alt="Книга" />
            <h2>{book.title}</h2>
            <p>{book.desc}</p>
            <span>{book.price} byn</span>
            <button className="delete" onClick={() => handleDelete(book.id)}>Delete</button>
            <button className="update">
              <Link
                to={`/update/${book.id}`}
                style={{ color: "inherit", textDecoration: "none" }}
              >
                Update
              </Link>
            </button>
          </div>
        ))}
      </div>
      <div>
        <button className="fetch" onClick={() => fetchAllBooks()}>Fetch</button>
      </div>
      <button className="addHome">
        <Link to="/add" style={{ color: "inherit", textDecoration: "none" }}>
          Add
        </Link>
      </button>
    </div>
  );
};

export default Books;