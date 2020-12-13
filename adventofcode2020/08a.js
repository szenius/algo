const fs = require("fs");

const lines = fs
  .readFileSync("./08.input.txt", "utf-8")
  .split("\n")
  .filter(Boolean);

const isInstructionExecuted = new Array(lines.length).fill(false);
let accum = 0;
let i = 0;
while (i >= 0 && i < lines.length) {
  if (isInstructionExecuted[i]) {
    console.log(lines[i]);
    break;
  }
  isInstructionExecuted[i] = true;

  const [cmd, offset] = lines[i].split(" ");
  const offsetNum = Number(offset);

  switch (cmd) {
    case "acc":
      accum += offsetNum;
      i += 1;
      break;
    case "jmp":
      i += offsetNum;
      break;
    case "nop":
    default:
      i += 1;
      break;
  }
}

console.log(accum);
