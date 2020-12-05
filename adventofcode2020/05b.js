const fs = require("fs");

const MAX_SEAT_ID = 994;

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
  if (rowMin !== rowMax) {
    console.error("rowMin !== rowMax", sequence, rowMin, rowMax);
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
  if (colMin !== colMax) {
    console.error("colMin !== colMax", sequence, colMin, colMax);
  }

  return rowMin * 8 + colMin;
};

const isSeatIdExist = {};
let minSeatId = MAX_SEAT_ID;
for (const line of lines) {
  const seatId = getSeatId(line);
  isSeatIdExist[seatId] = true;
  minSeatId = Math.min(minSeatId, seatId);
}

for (let i = minSeatId + 1; i < MAX_SEAT_ID - 1; i++) {
  if (isSeatIdExist[i - 1] && !isSeatIdExist[i] && isSeatIdExist[i + 1]) {
    console.log(i);
  }
}
