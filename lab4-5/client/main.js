import Candy from "./candy.js"
import Gift from "./gift.js"

const webSocket = new WebSocket("ws://localhost:8080")

let candy1 = new Candy("Sweets", 7);
let candy2 = new Candy("Korovka", 23);
let candy3 = new Candy("lollipop", 34);
let candy4 = new Candy("Alenka", 8);
let candy5 = new Candy("Bee", 5);
let candy6 = new Candy("Wolf", 20);

let gift = new Gift(candy1.amount);
gift.addCandy(candy2.amount);
gift.addCandy(candy3.amount);
gift.addCandy(candy4.amount);
gift.addCandy(candy5.amount);
gift.addCandy(candy6.amount);


console.log(`${gift.showGift()}`)

webSocket.onopen = function() {
  webSocket.send(gift.showGift())
};

webSocket.onmessage = function(event) {
  var incomingMessage = event.data
  alert(incomingMessage)
};