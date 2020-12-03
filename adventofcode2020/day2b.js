const fs = require("fs");

const lines = fs
  .readFileSync("./day2.input.txt", "utf-8")
  .split("\n")
  .filter(Boolean);

const numValidPolicies = lines.reduce((numValidPoliciesSoFar, currentLine) => {
  const args = currentLine.split(" ");
  const [first, second] = args[0].split("-");
  const alphabet = args[1].replace(":", "");
  const password = args[2];

  if (password.length < second - 1) {
    return numValidPoliciesSoFar;
  }

  const alphabetAtFirst = password[first - 1];
  const alphabetAtSecond = password[second - 1];

  if (alphabetAtFirst === alphabet && alphabetAtSecond === alphabet) {
    return numValidPoliciesSoFar;
  }

  if (alphabetAtFirst !== alphabet && alphabetAtSecond !== alphabet) {
    return numValidPoliciesSoFar;
  }

  return numValidPoliciesSoFar + 1;
}, 0);

console.log(numValidPolicies);
