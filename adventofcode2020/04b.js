const fs = require("fs");

const OPTIONAL_FIELDS = ["cid"];
const COMPULSORY_FIELDS = ["byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"];

const ECL_POSSIBLE_VALUES = new Set([
  "amb",
  "blu",
  "brn",
  "gry",
  "grn",
  "hzl",
  "oth",
]);

const passports = fs
  .readFileSync("./04.input.txt", "utf-8")
  .split("\n\n")
  .filter(Boolean);

const numValid = passports.reduce((numValidSoFar, currPassport) => {
  const fields = currPassport.split(/ |\n/);
  if (fields.length < COMPULSORY_FIELDS.length) {
    return numValidSoFar;
  }
  let isPassportValid = true;
  let isCidFound = false;
  for (const field of fields) {
    const [fieldName, fieldValue] = field.split(":");
    switch (fieldName) {
      case "cid":
        isCidFound = true;
        break;
      case "byr":
        if (
          Number.isNaN(Number(fieldValue)) ||
          Number(fieldValue) < 1920 ||
          Number(fieldValue) > 2002
        ) {
          isPassportValid = false;
        }
        break;
      case "iyr":
        if (
          Number.isNaN(Number(fieldValue)) ||
          Number(fieldValue) < 2010 ||
          Number(fieldValue) > 2020
        ) {
          isPassportValid = false;
        }
        break;
      case "eyr":
        if (
          Number.isNaN(Number(fieldValue)) ||
          Number(fieldValue) < 2020 ||
          Number(fieldValue) > 2030
        ) {
          isPassportValid = false;
        }
        break;
      case "hgt":
        if (fieldValue.endsWith("cm")) {
          const height = Number(fieldValue.replace("cm", ""));
          if (
            Number.isNaN(Number(height)) ||
            Number(height) < 150 ||
            Number(height) > 193
          ) {
            isPassportValid = false;
          }
        } else if (fieldValue.endsWith("in")) {
          const height = Number(fieldValue.replace("in", ""));
          if (
            Number.isNaN(Number(height)) ||
            Number(height) < 59 ||
            Number(height) > 76
          ) {
            isPassportValid = false;
          }
        } else {
          isPassportValid = false;
        }
        break;
      case "hcl":
        console.log(fieldValue);
        if (!fieldValue.match(/#([0-9a-f]){6}/)) {
          console.log("doesnt match");
          isPassportValid = false;
        }
        break;
      case "ecl":
        if (!ECL_POSSIBLE_VALUES.has(fieldValue)) {
          isPassportValid = false;
        }
        break;
      case "pid":
        if (fieldValue.length !== 9 || Number.isNaN(Number(fieldValue))) {
          isPassportValid = false;
        }
        break;
    }
    if (!isPassportValid) {
      break;
    }
  }
  if (isCidFound && fields.length - 1 !== COMPULSORY_FIELDS.length) {
    return numValidSoFar;
  }
  if (isPassportValid) {
    return numValidSoFar + 1;
  }
  return numValidSoFar;
}, 0);

console.log(numValid);
