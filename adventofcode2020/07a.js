const fs = require("fs");

const lines = fs
  .readFileSync("./07.input.txt", "utf-8")
  .split("\n")
  .filter(Boolean);

class GraphNode {
  constructor(colour) {
    this.colour = colour;
    this.parents = new Set();
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
    const childColour = child
      .replace(/(no other)? bags?.?/, "")
      .trim()
      .split(" ")
      .slice(1)
      .join(" ")
      .trim();
    if (childColour) {
      if (!nodeByColour.hasOwnProperty(childColour)) {
        nodeByColour[childColour] = new GraphNode(childColour);
      }
      nodeByColour[childColour].parents.add(nodeByColour[rootColour]);
    }
  });
});

const countNumBags = (node) => {
  if (node.parents.size === 0) {
    return 0;
  }
  let count = 0;
  node.parents.forEach((parent) => {
    if (!parent.visited) {
      count++;
      count += countNumBags(parent);
      parent.visited = true;
    }
  });
  return count;
};
console.log(countNumBags(nodeByColour["shiny gold"]));
