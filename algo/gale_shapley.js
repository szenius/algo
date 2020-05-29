const males = {
  m1: ["f3", "f4", "f2", "f1"],
  m2: ["f2", "f3", "f1", "f4"],
  m3: ["f4", "f2", "f3", "f1"],
  m4: ["f4", "f3", "f1", "f2"],
};
const females = {
  f1: ["m4", "m1", "m2", "m3"],
  f2: ["m1", "m2", "m4", "m3"],
  f3: ["m1", "m3", "m4", "m2"],
  f4: ["m1", "m3", "m4", "m2"],
};

// Convert males to this format
// {m1: {ranking: ["f3", "f2", "f4", "f1"], engagedTo: null, lastProposedIndex: -1}, ...}
const tMales = {};
Object.entries(males).forEach(([id, ranking]) => {
  tMales[id] = { ranking, engagedTo: null, lastProposedIndex: -1 };
});

// Converts females to this format
// {f1: {ranking: {m3: 0, m2: 1, m4: 2, m1: 3}, engagedTo: null}, ...}
const tFemales = {};
Object.entries(females).forEach(([id, ranking]) => {
  const rankingObj = {};
  ranking.forEach((maleId, index) => {
    rankingObj[maleId] = index;
  });
  tFemales[id] = {
    ranking: rankingObj,
    engagedTo: null,
  };
});

let isAllEngaged = false;
while (!isAllEngaged) {
  Object.entries(tMales).forEach(([tMaleKey, tMaleValue]) => {
    if (!tMaleValue.engagedTo) {
      // This male is not engaged, he's going to propose
      const femaleCandKey =
        tMaleValue.ranking[tMaleValue.lastProposedIndex + 1];
      const femaleCand = tFemales[femaleCandKey];
      console.log(`${tMaleKey} tryna propose to ${femaleCandKey}`);

      if (!tFemales[femaleCandKey].engagedTo) {
        // Female is not engaged, so she accepts the proposal
        console.log(`==> ${tMaleKey} got engaged to ${femaleCandKey}`);
        femaleCand.engagedTo = tMaleKey;
        tMaleValue.engagedTo = femaleCandKey;
      } else if (
        femaleCand.ranking[tMaleKey] < femaleCand.ranking[femaleCand.engagedTo]
      ) {
        // Female was already engaged, but she prefers this male
        const femaleCandExKey = femaleCand.engagedTo;
        tMales[femaleCandExKey].engagedTo = null;
        femaleCand.engagedTo = tMaleKey;
        tMaleValue.engagedTo = femaleCandKey;
        console.log(
          `==> ${tMaleKey} got engaged to ${femaleCandKey} by kicking off ${femaleCandExKey}`
        );
      }
      tMaleValue.lastProposedIndex++;
    }
  });

  // Check if all males are engaged
  isAllEngaged = Object.values(tMales)
    .map((tMale) => tMale.engagedTo)
    .reduce((accum, curr) => accum && Boolean(curr));

  console.log("=================");
}

// Print results
Object.entries(tMales).forEach(([tMaleKey, tMaleValue]) => {
  console.log(`${tMaleKey} is married with ${tMaleValue.engagedTo}`);
});
