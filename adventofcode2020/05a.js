const fs = require("fs");

const lines = fs
  .readFileSync("./05.input.txt", "utf-8")
  .split("\n")
  .filter(Boolean);

const getSeatId = (sequence) => {
  const rowSequence = sequence.slice(0, 7);
  let rowMin = 0;
  let rowMax = 127;
  for (const letter of rowSequence) {
    const spread = Math.ceil((rowMax - rowMin) / 2);
    if (letter === "F") {
      rowMax -= spread;
    } else if (letter === "B") {
      rowMin += spread;
    }
  }

  const colSequence = sequence.slice(7, 10);
  let colMin = 0;
  let colMax = 7;
  for (const letter of colSequence) {
    const spread = Math.ceil((colMax - colMin) / 2);
    if (letter === "L") {
      colMax -= spread;
    } else if (letter === "R") {
      colMin += spread;
    }
  }

  return rowMin * 8 + colMin;
};

let maxSeatId = 0;
for (const line of lines) {
  maxSeatId = Math.max(maxSeatId, getSeatId(line));
}
console.log(maxSeatId);
