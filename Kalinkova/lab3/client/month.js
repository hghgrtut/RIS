export default class Month {
  #month = 0;

  constructor(month) {
      this.#month = +JSON.stringify(month);
  }

  get month() {
      return JSON.parse(this.#month);
  }
}