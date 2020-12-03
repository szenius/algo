const fs = require("fs");

const INPUT = fs
  .readFileSync("./01.input.txt", "utf-8")
  .split("\n")
  .filter(Boolean)
  .map(Number);
const SUM = 2020;

const sortedInput = INPUT.sort((a, b) => a - b);

for (let i = 0; i < sortedInput.length; i++) {
  let j = i + 1;
  let k = sortedInput.length - 1;
  let found = false;
  while (j < k) {
    const currSum = sortedInput[i] + sortedInput[j] + sortedInput[k];
    if (currSum === SUM) {
      console.log(
        sortedInput[i],
        sortedInput[j],
        sortedInput[k],
        sortedInput[i] * sortedInput[j] * sortedInput[k]
      );
      found = true;
      break;
    }
    if (currSum < SUM) {
      j++;
    } else if (currSum > SUM) {
      k--;
    }
  }
  if (found) {
    break;
  }
}
