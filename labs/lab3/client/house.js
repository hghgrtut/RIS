export default class House {
  #house = 0;

  constructor(apartment) {
      this.#house = +JSON.stringify(apartment)
  }

  addApartment(apartment) {
    this.#house += +JSON.stringify(apartment)
  }

  showHouse() {
    return "Дом: " + JSON.parse(this.#house)
  }
}