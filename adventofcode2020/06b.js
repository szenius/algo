const fs = require("fs");

const lines = fs
  .readFileSync("./06.input.txt", "utf-8")
  .split("\n\n")
  .filter(Boolean);

const getNumQuestions = (answers) => {
  const countByQuestion = {};
  const answerLines = answers.split("\n");
  answerLines.forEach((answer) => {
    const questions = answer.split("");
    questions.forEach((question) => {
      if (Object.prototype.hasOwnProperty.call(countByQuestion, question)) {
        countByQuestion[question] += 1;
      } else {
        countByQuestion[question] = 1;
      }
    });
  });
  return Object.values(countByQuestion).reduce((accum, curr) => {
    if (curr === answerLines.length) {
      return accum + 1;
    }
    return accum;
  }, 0);
};

const result = lines.reduce((accum, answers) => {
  const numQuestionsForLine = getNumQuestions(answers);
  return accum + numQuestionsForLine;
}, 0);
console.log(result);
