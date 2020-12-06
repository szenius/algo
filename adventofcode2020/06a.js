const fs = require("fs");

const lines = fs
  .readFileSync("./06.input.txt", "utf-8")
  .split("\n\n")
  .filter(Boolean);

const getNumQuestions = (answers) => {
  const numQuestions = new Set();
  answers.split("\n").forEach((answer) => {
    const questions = answer.split("");
    questions.forEach(numQuestions.add, numQuestions);
  });
  return numQuestions.size;
};

const result = lines.reduce((accum, answers) => {
  const numQuestionsForLine = getNumQuestions(answers);
  return accum + numQuestionsForLine;
}, 0);
console.log(result);
