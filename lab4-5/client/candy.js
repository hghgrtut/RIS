export default class Candy {
  #name = "small candy"
  #amount = 0

  constructor(name, amount) {
      this.#name = +JSON.stringify(name)
      this.#amount = +JSON.stringify(amount)
  }

  get name() {
      return JSON.parse(this.#name)
  }
 
  get amount() {
    return JSON.parse(this.#amount)
}
}