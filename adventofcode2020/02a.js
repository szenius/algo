const fs = require("fs");

const lines = fs
  .readFileSync("./02.input.txt", "utf-8")
  .split("\n")
  .filter(Boolean);

const numValidPolicies = lines.reduce((numValidPoliciesSoFar, currentLine) => {
  const args = currentLine.split(" ");
  const [min, max] = args[0].split("-");
  const alphabet = args[1].replace(":", "");
  const password = args[2];

  const regex = new RegExp(alphabet, "g");
  const count = (password.match(regex) || []).length;
  if (count >= min && count <= max) {
    return numValidPoliciesSoFar + 1;
  }
  return numValidPoliciesSoFar;
}, 0);

console.log(numValidPolicies);
