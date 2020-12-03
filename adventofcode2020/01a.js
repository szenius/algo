const fs = require("fs");

const INPUT = fs
  .readFileSync("./01.input.txt", "utf-8")
  .split("\n")
  .filter(Boolean)
  .map(Number);
const SUM = 2020;

const inputSet = new Set(INPUT);
for (let i = 0; i < INPUT.length; i++) {
  const curr = INPUT[i];
  if (inputSet.has(SUM - curr)) {
    console.log(curr, SUM - curr, curr * (SUM - curr));
    break;
  }
}
