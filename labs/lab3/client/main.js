import Apartment from "./apartment.js"
import House from "./house.js"

const webSocket = new WebSocket("ws://localhost:8080")

let apartment1 = new Apartment(1, 1)
let apartment2 = new Apartment(2, 1)
let apartment3 = new Apartment(3, 1)

let house = new House(apartment1.number)
house.addApartment(apartment2.number)
house.addApartment(apartment3.number)

console.log(house.showHouse())

webSocket.onopen = function() {
  webSocket.send(house.showHouse())
};

webSocket.onmessage = function(event) {
  var incomingMessage = event.data
  alert(incomingMessage)
};