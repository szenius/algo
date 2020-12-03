const fs = require("fs");

const lines = fs
  .readFileSync("./03.input.txt", "utf-8")
  .split("\n")
  .filter(Boolean);

const numRows = lines.length;
const numCols = lines[0].length;

const COMBINATIONS = [
  { right: 1, down: 1 },
  { right: 3, down: 1 },
  { right: 5, down: 1 },
  { right: 7, down: 1 },
  { right: 1, down: 2 },
];

const result = COMBINATIONS.reduce((productSoFar, currCombination) => {
  const { right, down } = currCombination;

  let colIdx = 0;
  let rowIdx = 0;

  let numTrees = 0;
  while (rowIdx < numRows) {
    colIdx += right;
    colIdx %= numCols;
    rowIdx += down;

    if (rowIdx < numRows && lines[rowIdx].charAt(colIdx) === "#") {
      numTrees += 1;
    }
  }

  return productSoFar * numTrees;
}, 1);

console.log(result);
