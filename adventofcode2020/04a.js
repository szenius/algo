const fs = require("fs");

const OPTIONAL_FIELDS = ["cid"];
const COMPULSORY_FIELDS = ["byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"];

const passports = fs
  .readFileSync("./04.input.txt", "utf-8")
  .split("\n\n")
  .filter(Boolean);

const numValid = passports.reduce((numValidSoFar, currPassport) => {
  const fields = currPassport.split(/ |\n/);
  if (fields.length < COMPULSORY_FIELDS.length) {
    return numValidSoFar;
  }
  if (fields.length === OPTIONAL_FIELDS.length + COMPULSORY_FIELDS.length) {
    return numValidSoFar + 1;
  }
  let isPassportValid = true;
  for (const field of fields) {
    if (field.split(":")[0] === OPTIONAL_FIELDS[0]) {
      isPassportValid = false;
      break;
    }
  }
  if (isPassportValid) {
    return numValidSoFar + 1;
  }
  return numValidSoFar;
}, 0);

console.log(numValid);
