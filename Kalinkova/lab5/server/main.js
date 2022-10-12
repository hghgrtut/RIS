const app = require('express')();
const bodyParser = require('body-parser');

app.use(bodyParser.json());

// ----- Allow CORS

app.use(function (req, res, next) {
  res.header('Access-Control-Allow-Headers', 'Content-Type');
  res.header('Access-Control-Allow-Methods', 'GET,POST,PATCH,DELETE');
  res.header('Access-Control-Allow-Origin', '*');
  next();
});

// ----- The API implementation

let todos = [];

app.get('/', function (req, res) {
  console.log('getall');
  res.send(todos);
});

app.get('/:id', function (req, res) {
  console.log('getid');
  res.send(todos[req.params.id]);
});

app.post('/', function (req, res) {
  console.log('create');
  const newTodo = {
    title: req.body.title,
    isCompleted: req.body.isCompleted
  };

  todos.push(newTodo);
  res.send(newTodo);
});

app.patch('/:id', function (req, res) {
  console.log("patch", req.params.id, req.body);

  const updatedTodos = [
    ...todos.slice(0, +req.params.id),
    req.body,
    ...todos.slice(+req.params.id + 1)
  ];

  todos = updatedTodos;
  res.send(todos);
});

app.delete('/', function (req, res) {
  console.log('delete');
  todos = [];
  res.send(todos);
});

app.delete('/:id', function (req, res) {
  console.log('deleteid');
  const updatedTodos = [
    ...todos.slice(0, +req.params.id),
    ...todos.slice(+req.params.id + 1)
  ];

  todos = updatedTodos;
  res.send(todos);
});

console.log("Node server running and listening on the port:", Number(process.env.PORT || 5000));

app.listen(Number(process.env.PORT || 5000));