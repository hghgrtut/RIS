//@ts-checkts-check

(function () {
  const loadButton = document.getElementById('button');
  loadButton.addEventListener('click', (ev) => {
    ev.preventDefault();

    const url = 'http://localhost:5220/api/v1/users';
    fetch(url)
      .then((response) => {
        return response.json();
      })
      .then((response) => {
        if (response.length > 0) {
          const container = document.getElementById('container');
          const table = createTableFromArray(response);

          container.appendChild(table);
          console.log(Object.keys(response[0]));
        }
      });
  });

  function createTableFromArray(arr) {
    const table = document.createElement('table');
    table.style.width = '100%';
    if (arr.length > 0) {
      const thead = createTableHeaderForArray(arr);
      const tbody = createTableBodyFromArray(arr);
      table.appendChild(thead);
      table.appendChild(tbody);
    }

    return table;
  }

  function createTableHeaderForArray(arr) {
    const thead = document.createElement('thead');
    if (arr.length > 0) {
      const headRow = document.createElement('tr');
      for (props in arr[0]) {
        let col = document.createElement('th');
        col.innerHTML = props.toUpperCase();
        headRow.appendChild(col);
      }
      thead.appendChild(headRow);
    }
    return thead;
  }

  function createTableBodyFromArray(arr) {
    const tbody = document.createElement('tbody');
    for (obj of arr) {
      let row = document.createElement('tr');
      for (props in obj) {
        let col = document.createElement('td');
        col.innerHTML = obj[props];
        row.appendChild(col);
      }
      tbody.appendChild(row);
    }
    return tbody;
  }
})();
