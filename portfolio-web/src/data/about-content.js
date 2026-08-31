export const aboutValues = [
  {
    titleKey: "about.values.architecture.title",
    textKey: "about.values.architecture.text"
  },
  {
    titleKey: "about.values.automation.title",
    textKey: "about.values.automation.text"
  },
  {
    titleKey: "about.values.reliability.title",
    textKey: "about.values.reliability.text"
  }
];

export const aboutSkillGroups = [
  {
    groupKey: "about.skills.backend",
    items: ["Java", "Spring Boot", "Python", "Flask", "C", "C++"].map(label => ({ label }))
  },
  {
    groupKey: "about.skills.engineering",
    items: [{ label: "SOLID" }, { label: "Design Patterns" }, { key: "about.terms.oop" }, { key: "about.terms.modularArchitecture" }]
  },
  {
    groupKey: "about.skills.database",
    items: [{ label: "SQL" }, { key: "about.terms.relationalDatabase" }, { label: "Scrum" }, { key: "about.terms.processModeling" }]
  }
];
