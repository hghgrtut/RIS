export default class Year {
  #year = 0;

  constructor(month1, month2) {
      this.#year = +JSON.stringify(Math.floor((month1 + month2) / 12));
  }

  createYear() {
      return "Получившийся год: " + JSON.parse(this.#year);
  }
}