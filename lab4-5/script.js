class Gift {
  #candiesList = ""
  #candiesAmount = 0
  constructor(candies, candiesAmount) {
    this.#candiesList = +JSON.stringify(candies)
    this.#candiesAmount = +JSON.stringify(candiesAmount)
  }

  showGift() {
    return `Количество конфет в подарке: ${JSON.parse(this.#candiesAmount)}`
  }
}

class CandySmall {
  name = "Маленькая конфета"
  number = 0

  constructor(number) {
    this.number = number
  }

  get number() {
    return JSON.parse(this.number)
  }
}

class CandyChocolate extends CandySmall {
  name = "Шоколадная конфета"

  constructor(number) {
    super(number)
  }
}

class CandyLollipop extends CandySmall {
  name = "Леденец"

  constructor(number) {
    super(number)
  }
}


let candies = []
candies.push(new CandySmall(5))
candies.push(new CandyLollipop(10))
candies.push(new CandyChocolate(6))

let candiesList = ""
let candiesAmount = 0

for(let i = 0; i < 3; i++)
{
  candiesList += `${candies[i].name}: ${candies[i].number} шт\n`
  candiesAmount += candies[i].number
}

let gift = new Gift(candiesList, candiesAmount)

let res = JSON.stringify(candiesList)

console.log(gift.showGift())

console.log('JSON.stringify: ' + res)

console.log("Подарок состоит из:\n" + candiesList)