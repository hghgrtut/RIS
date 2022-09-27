let button = document.getElementById('btn')
let valid = document.getElementById('valid')
let invalid = document.getElementById('invalid')


function check1() {
  const inputstr = document.getElementById('inputstring').value
  const re = /abcdefghijklmnopqrstuv5320736/
  
  valid.style.display = 'none'
  invalid.style.display = 'none' 
  
  (re.test(inputstr) === true) ? valid.style.display = 'block' : invalid.style.display = 'block' 
}

function check2() {
  const inputstr = document.getElementById('inputstring').value
  const re = /abcdefghijklmnopqrstuv5320736/;
  
  valid.style.display = 'none'
  invalid.style.display = 'none' 
  
  (re.test(inputstr) === true) ? valid.style.display = 'block' : invalid.style.display = 'block' 
}

button.addEventListener('click', check1)