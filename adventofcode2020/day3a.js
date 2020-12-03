const fs = require("fs");

const lines = fs
  .readFileSync("./day3.input.txt", "utf-8")
  .split("\n")
  .filter(Boolean);

const numRows = lines.length;
const numCols = lines[0].length;

let colIdx = 0;
let rowIdx = 0;

let numTrees = 0;
while (rowIdx < numRows) {
  colIdx += 3;
  colIdx %= numCols;
  rowIdx += 1;

  if (rowIdx < numRows && lines[rowIdx].charAt(colIdx) === "#") {
    numTrees += 1;
  }
}

console.log(numTrees);
