const fs = require("fs");

const lines = fs
  .readFileSync("./07.input.txt", "utf-8")
  .split("\n")
  .filter(Boolean);

class GraphNode {
  constructor(colour) {
    this.colour = colour;
    this.children = [];
  }
}

const nodeByColour = {};
lines.forEach((line) => {
  const [root, children] = line.split("bags contain");
  const rootColour = root.trim();
  if (!nodeByColour.hasOwnProperty(rootColour)) {
    nodeByColour[rootColour] = new GraphNode(rootColour);
  }
  children.split(",").forEach((child) => {
    const tokens = child
      .replace(/(no other)? bags?.?/, "")
      .trim()
      .split(" ");

    const childNum = Number(tokens[0].trim());
    const childColour = tokens.slice(1).join(" ").trim();

    if (childColour) {
      if (!nodeByColour.hasOwnProperty(childColour)) {
        nodeByColour[childColour] = new GraphNode(childColour);
      }
      for (let i = 0; i < childNum; i++) {
        nodeByColour[rootColour].children.push(nodeByColour[childColour]);
      }
    }
  });
});

const countNumBags = (node) => {
  if (node.children.size === 0) {
    return 0;
  }
  let count = 0;
  node.children.forEach((child) => {
    count++;
    count += countNumBags(child);
  });
  return count;
};
console.log(countNumBags(nodeByColour["shiny gold"]));
