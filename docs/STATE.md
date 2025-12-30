# Pattern State – Explications détaillées (FR)

## 1) Idée centrale
Un objet change son comportement selon son **état interne**.
Au lieu d’encoder ça avec des `if/switch`, on encapsule chaque état dans une **classe**.

---

## 2) Rôles

### Interface `State`
Déclare toutes les actions possibles, même si certaines sont invalides selon l’état :
- insertQuarter()
- ejectQuarter()
- turnCrank()
- dispense()

### `GumballMachine` (contexte)
- possède un champ `state` : l’état courant
- possède souvent une instance de chaque état (NoQuarterState, HasQuarterState, etc.)
- délègue les appels au state courant :
  - `state.insertQuarter()`
  - `state.turnCrank()`
  - etc.

### États concrets
Chaque état :
- implémente `State`
- connaît la machine (référence vers `GumballMachine`)
- décide :
  - quoi afficher / faire
  - vers quel état passer (`gumballMachine.setState(...)`)

---

## 3) Transitions typiques
- NoQuarterState -> HasQuarterState (quand on insère une pièce)
- HasQuarterState -> SoldState (quand on tourne la manivelle)
- SoldState -> NoQuarterState (si encore des boules)
- SoldState -> SoldOutState (si plus de boules)

---

## 4) Avantages
- ajout d’un nouvel état sans casser toute la machine
- logique locale (chaque état gère ses règles)
- maintenable et testable

---

## 5) À ne pas confondre avec Strategy
- Strategy : on choisit une stratégie (souvent côté client)
- State : le comportement change automatiquement selon l’état

