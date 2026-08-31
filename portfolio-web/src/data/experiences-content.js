export const experienceTimeline = [
  {
    roleKey: "experiences.items.intern.role",
    company: "Grupo Triex",
    periodKey: "experiences.items.intern.period",
    pointKeys: [1, 2, 3].map(number => `experiences.items.intern.points.${number}`)
  },
  {
    roleKey: "experiences.items.independent.role",
    companyKey: "experiences.items.independent.company",
    periodKey: "experiences.items.independent.period",
    pointKeys: [1, 2, 3].map(number => `experiences.items.independent.points.${number}`)
  }
];
