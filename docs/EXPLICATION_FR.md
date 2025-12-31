# Pattern State — Explication détaillée (FR)

## 1) Intention
Remplacer une logique à base de gros `if/else` ou `switch` par des **classes d’état**.
Le comportement de l’objet **change automatiquement** quand son état interne change.

## 2) Problème typique sans State
Dans `GumballMachine`, tu aurais :
- `if (state == NO_QUARTER) ...`
- `else if (state == HAS_QUARTER) ...`
- etc.
Résultat : code long, fragile, chaque modification casse autre chose.

## 3) Principe
- Un **contexte** (ici `GumballMachine`) possède un **état courant** (champ `State state`).
- Chaque état est une classe (`NoQuarterState`, `HasQuarterState`, `SoldState`, `SoldOutState`)
  qui implémente l’interface `State`.
- Le contexte **délègue** les actions à l’état courant :
  `insertQuarter()`, `turnCrank()`, `dispense()`, etc.

## 4) Structure des rôles
- `State` : contrat (méthodes = actions possibles)
- `GumballMachine` (Context) : possède l’état courant + les états concrets + la logique de transition
- États concrets : portent la logique “quoi faire dans CET état” + “vers quel état on bascule”.

## 5) Déroulé du run
Point d’entrée : `GumballMachineTestDrive`.
Scénario :
1) insertion de pièce
2) rotation de manivelle
3) distribution
4) passage en sold-out quand stock = 0

## 6) Avantages
- Plus de `switch` centralisé
- Ajout d’un état = nouvelle classe, impact limité
- Transitions lisibles et localisées

## 7) Inconvénients
- Plus de classes
- Il faut une discipline sur les transitions (sinon incohérence)

## 8) Erreurs classiques
- Mettre les transitions uniquement dans le contexte → on revient au “gros if”
- Oublier de gérer un cas (ex: tourner sans pièce)

