const BASE_URL = "http://localhost:5000";

const todosList = document.querySelector(".todos-container ul");
const todosInput = document.querySelector(".todos-container input");
const todosForm = document.querySelector(".todos-container form");

const getAllTodos = async () => {
  const data = await fetch(`${BASE_URL}`);
  return data.json();
}

const getTodoById = async (id) => {
  const data = await fetch(`${BASE_URL}/${id}`);
  return data.json();
}

const createTodo = async (todo) => {
  const data = await fetch(`${BASE_URL}`, {
    method: "POST",
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(todo)
  });
  return data.json();
}

const updateTodoById = async (id, todo) => {
  await fetch(`${BASE_URL}/${id}`, {
    method: "PATCH",
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(todo)
  });
  renderList();
}

const deleteAllTodos = async () => {
  const data = await fetch(`${BASE_URL}`, {
    method: "DELETE"
  });
  return data.json();
}

const deleteTodoById = async (id) => {
  await fetch(`${BASE_URL}/${id}`, {
    method: "DELETE"
  });
  renderList();
}

todosForm.addEventListener('submit', async (e) => {
  e.preventDefault();
  await createTodo({
    title: todosInput.value,
    isCompleted: false
  });

  todosInput.value = "";

  renderList();
});

const updateTodo = async (id) => {
  const newTitle = prompt("Новый текст: ");
  await updateTodoById(id, {
    title: newTitle,
    isCompleted: false
  })
}


const renderList = async () => {
  const todos = await getAllTodos();
  todosList.innerHTML = '';
  todos.forEach((todo, i) => {
    const li = document.createElement("li");
    const p = document.createElement("p");
    const buttonUpdate = document.createElement("button");
    const buttonDelete = document.createElement("button");

    buttonUpdate.addEventListener('click', () => updateTodo(i));
    buttonDelete.addEventListener('click', () => deleteTodoById(i));

    p.appendChild(document.createTextNode(todo.title));
    buttonUpdate.appendChild(document.createTextNode("Изменить"));
    buttonDelete.appendChild(document.createTextNode("Удалить"));
    li.appendChild(p);
    li.appendChild(buttonUpdate);
    li.appendChild(buttonDelete);
    todosList.appendChild(li);
  });
}

renderList();