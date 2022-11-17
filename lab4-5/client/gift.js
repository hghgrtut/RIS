export default class Gift {
  #count = 0;

  constructor(candy) {
      this.#count = +JSON.stringify(candy)
  }

  addCandy(candy) {
    this.#count += +JSON.stringify(candy)
  }

  showGift() {
    return "В подарке: " + JSON.parse(this.#count) + " конфет"
  }
}