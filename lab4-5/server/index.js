import express from "express";
import mysql from "mysql";
import cors from "cors";

const app = express();
app.use(cors());
app.use(express.json());

app.listen(8800, () => {
  console.log("not error")
})

const db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "mobile",
});

app.get("/", (req, res) => {
  res.json("go to /operators");
});

app.get("/operators", (req, res) => {
  const q = "SELECT * FROM operators";
  db.query(q, (err, data) => {
    if (err) return res.json(err);
    return res.json(data);
  });
});

app.post("/operators", (req, res) => {
  const q = "INSERT INTO operators(`name`, `desc`, `price`) VALUES (?)";

  const values = [
    req.body.name,
    req.body.desc,
    req.body.price
  ];

  db.query(q, [values], (err, data) => {
    if (err) return res.send(err);
    return res.json(data);
  });
});

app.delete("/operators/:id", (req, res) => {
  const operatorId = req.params.id;
  const q = " DELETE FROM operators WHERE id = ? ";

  db.query(q, [operatorId], (err, data) => {
    if (err) return res.send(err);
    return res.json(data);
  });
});

app.put("/operators/:id", (req, res) => {
  const operatorId = req.params.id;
  const q = "UPDATE operators SET `name`= ?, `desc`= ?, `price`= ? WHERE id = ?";

  const values = [
    req.body.name,
    req.body.desc,
    req.body.price
  ];

  db.query(q, [...values,operatorId], (err, data) => {
    if (err) return res.send(err);
    return res.json(data);
  });
});

