import Month from "./month.js";
import Year from "./year.js";

const ws = new WebSocket("ws://localhost:8080");

let month1 = new Month(22);
let month2 = new Month(12);

let year = new Year(month1.month, month2.month);

ws.onopen = function() {
  ws.send(year.createYear());
};

ws.onmessage = function(event) {
  var incomingMessage = event.data;
  alert(incomingMessage);
};