export default class Apartment {
  #number = 0
  #floor = 0

  constructor(number, floor) {
      this.#number = +JSON.stringify(number)
      this.#floor = +JSON.stringify(floor)
  }

  get number() {
      return JSON.parse(this.#number)
  }
 
  get floor() {
    return JSON.parse(this.#floor)
}
}