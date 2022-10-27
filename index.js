import express from "express";
import mysql from "mysql";
import cors from "cors";

const app = express();
app.use(cors());
app.use(express.json());

app.listen(8800, () => {
  console.log("connect")
})

const db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "beauty",
});

app.get("/", (req, res) => {
  res.json("req");
});

app.get("/nails", (req, res) => {
  const q = "SELECT * FROM nails";
  db.query(q, (err, data) => {
    if (err) {
      console.log(err);
      return res.json(err);
    }
    return res.json(data);
  });
});

app.post("/nails", (req, res) => {
  const q = "INSERT INTO nails(`name`, `desc`, `price`) VALUES (?)";

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

app.delete("/nails/:id", (req, res) => {
  const nailId = req.params.id;
  const q = " DELETE FROM nails WHERE id = ? ";

  db.query(q, [nailId], (err, data) => {
    if (err) return res.send(err);
    return res.json(data);
  });
});

app.put("/nails/:id", (req, res) => {
  const nailId = req.params.id;
  const q = "UPDATE nails SET `name`= ?, `desc`= ?, `price`= ? WHERE id = ?";

  const values = [
    req.body.name,
    req.body.desc,
    req.body.price
  ];

  db.query(q, [...values,nailId], (err, data) => {
    if (err) return res.send(err);
    return res.json(data);
  });
});

