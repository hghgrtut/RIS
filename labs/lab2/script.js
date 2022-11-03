class ApartmentOneRoom {
  number = 0
  float = 0
  
  constructor(float, number) {
    this.number = number
    this.float = float
    this.amountRoom = 1
  }

  get apartment() {
    return JSON.parse(this.number, this.float)
  }
}

class ApartmentTwoRoom extends ApartmentOneRoom {
  constructor(float, number) {
    super(float, number)
    this.amountRoom = 2
  }
}

class ApartmentThreeRoom extends ApartmentOneRoom {
  constructor(float, number) {
    super(float, number)
    this.amountRoom = 3
  }
}

let apartment1 = new ApartmentOneRoom(1, 1) 
let apartment2 = new ApartmentTwoRoom(1, 2)
let apartment3 = new ApartmentThreeRoom(1, 3)
let apartment4 = new ApartmentOneRoom(1, 4)
let apartment5 = new ApartmentTwoRoom(2, 5)
let apartment6 = new ApartmentThreeRoom(2, 6)
let apartment7 = new ApartmentOneRoom(2, 7)
let apartment8 = new ApartmentTwoRoom(2, 8)

let apartments = []

apartments.push(apartment1)
apartments.push(apartment2)
apartments.push(apartment3)
apartments.push(apartment4)
apartments.push(apartment5)
apartments.push(apartment6)
apartments.push(apartment7)
apartments.push(apartment8)

let res = JSON.stringify(apartments)

console.log('JSON.stringify: \n' + res)

console.log(apartments)