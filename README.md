# Pattern State — Gumball Machine (Machine à bonbons)

## Objectif
Le pattern **State** permet à un objet de **changer de comportement** lorsque son **état interne** change, sans multiplier les `if/else` ou `switch`.

Dans cet exemple, une machine à bonbons se comporte différemment selon qu’elle a :
- une pièce insérée ou non
- du stock ou non
- une vente en cours

## Structure
Principales classes :
- `State` : interface des actions disponibles
- `GumballMachine` : contexte (stock + état courant) ; délègue aux états
- `NoQuarterState`
- `HasQuarterState`
- `SoldState`
- `SoldOutState`
- `GumballMachineTestDrive` : scénario de test (main)

Arborescence :
```text
src/main/java/headfirst/designpatterns/state/
  State.java
  GumballMachine.java
  NoQuarterState.java
  HasQuarterState.java
  SoldState.java
  SoldOutState.java
  GumballMachineTestDrive.java
