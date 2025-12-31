# Pattern State — Explication détaillée (FR)

## 1) Intention
Le pattern **State** permet à un objet de **changer de comportement** quand son **état interne** change.
On remplace des gros `if/else` ou `switch` par des **classes d’état** dédiées.

**Idée clé** : l’objet “contexte” délègue son comportement à un objet `State` courant.

## 2) Problème sans State (anti-pattern)
Une machine à bonbons (gumball) a plusieurs états :
- pas de pièce
- pièce insérée
- vente (distribution)
- rupture de stock

Sans State :
- tu fais un champ `state` + des tests partout
- chaque nouvelle règle = modifications risquées et partout dans le code
- le code devient fragile (effet domino)

## 3) Principe
- Une **interface** `State` définit les actions possibles (ex : `insertQuarter()`, `ejectQuarter()`, `turnCrank()`, `dispense()`).
- Chaque état concret (ex : `NoQuarterState`) implémente ces actions.
- Le **contexte** `GumballMachine` contient :
  - une référence vers l’état courant `State state`
  - des instances (ou création) de tous les états
  - des méthodes publiques qui délèguent au `state`

## 4) Structure (dans ce projet)
- `State` : interface des actions
- `GumballMachine` : contexte + transitions + stock (compteur de bonbons)
- `NoQuarterState` : aucune pièce → accepte insertion
- `HasQuarterState` : pièce OK → peut tourner la manivelle
- `SoldState` : distribue un bonbon et met à jour l’état suivant
- `SoldOutState` : stock = 0 → refuse actions

## 5) Déroulé du run
Point d’entrée : `GumballMachineTestDrive`
Scénario type :
1) insertion d’une pièce
2) rotation manivelle
3) distribution bonbon (stock décrémenté)
4) quand stock = 0 → bascule `SoldOutState`

## 6) Avantages
- Comportements regroupés par état (lisible)
- Ajout d’un état = nouvelle classe, impact limité
- Transitions contrôlées localement

## 7) Inconvénients
- Plus de classes (normal)
- Il faut une bonne modélisation des états/actions

## 8) Erreurs classiques
- Mettre toute la logique dans `GumballMachine` (retour au switch)
- États qui ne gèrent pas correctement les transitions (état impossible)
- Oublier de protéger les actions invalides par état

## 9) Liens avec d’autres patterns
- **Strategy** : variation d’algorithmes ; State = variation selon état interne
- **Command** : encapsuler des actions ; State peut influencer quelles actions sont possibles
- **Proxy** : contrôle d’accès ; State contrôle “mécaniquement” les transitions autorisées
