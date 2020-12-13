const fs = require("fs");

const lines = fs
  .readFileSync("./08.input.txt", "utf-8")
  .split("\n")
  .filter(Boolean);

const execute = (lines) => {
  const isInstructionExecuted = new Array(lines.length).fill(false);
  let accum = 0;
  let j = 0;
  let terminated = true;
  while (j >= 0 && j < lines.length) {
    if (isInstructionExecuted[j]) {
      terminated = false;
      break;
    }
    isInstructionExecuted[j] = true;

    const [cmd, offset] = lines[j].split(" ");
    const offsetNum = Number(offset);

    switch (cmd) {
      case "acc":
        accum += offsetNum;
        j += 1;
        break;
      case "jmp":
        j += offsetNum;
        break;
      case "nop":
      default:
        j += 1;
        break;
    }
  }

  return { terminated, accum };
};

for (let i = 0; i < lines.length; i++) {
  if (lines[i].startsWith("acc")) {
    continue;
  }

  let newLine = lines[i];
  if (newLine.startsWith("jmp")) {
    newLine = newLine.replace("jmp", "nop");
  } else if (newLine.startsWith("nop")) {
    newLine = newLine.replace("nop", "jmp");
  }

  const linesCopy = [...lines.slice(0, i), newLine, ...lines.slice(i + 1)];

  const result = execute(linesCopy);
  if (result.terminated) {
    console.log(result.accum);
    break;
  }
}
