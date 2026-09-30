# Bridge — Game Character Attack Styles

Simple game-character themed project for Assignment #3 (Bridge pattern).

## How to run

```
javac -d out $(find src -name "*.java")
java -cp out bridge.BridgeDemo
```

## How it works

Separates **what kind of character** it is from **how it attacks**, so
either side can change without touching the other.

| Role | Class(es) |
|---|---|
| Abstraction | `GameCharacter` — holds a reference to an `AttackBehavior`, never implements attack mechanics itself |
| Refined Abstraction | `Warrior`, `Mage` |
| Implementor | `AttackBehavior` |
| Concrete Implementor | `MeleeAttack`, `RangedAttack` |
| Client | `BridgeDemo` |

The two hierarchies vary independently: any character type can be paired
with any attack style, and `BridgeDemo` proves it by switching a `Warrior`
from `MeleeAttack` to `RangedAttack` **at runtime**, without changing a
single line in `GameCharacter` or `Warrior`.

Topic is intentionally different from the lecture's Shape/Renderer
example, to stay unique.

## Clean Code principles applied

**1. Clear separation of abstraction-side vs. implementation-side responsibilities**
`GameCharacter.attack()` only calls `attackBehavior.performAttack(name)` — it
never contains `if (weapon == "sword")`-style branching or damage numbers
itself. No implementor detail (like `AttackConstants.MELEE_DAMAGE`) ever
leaks into `GameCharacter`, `Warrior`, or `Mage`.

**2. Meaningful names distinguishing Abstraction vs. Implementor roles**
Abstraction-side classes are named after the domain (`GameCharacter`,
`Warrior`, `Mage`); Implementor-side classes are named after the
capability they provide and end in `...Attack` (`MeleeAttack`,
`RangedAttack`) — the suffix alone tells you which side of the bridge a
class belongs to.

**3. Small, focused classes on both sides of the bridge**
Each Concrete Implementor (`MeleeAttack`, `RangedAttack`) does exactly one
thing: print its own attack message. Each Refined Abstraction (`Warrior`,
`Mage`) only overrides `describe()` — all attack logic stays out of them.

**4. No duplicated logic between Concrete Implementors**
Before: both `MeleeAttack` and `RangedAttack` would each build their own
`characterName + " ... for " + damage + " damage!"` string.
After: that formatting lives once, as a default method on the
`AttackBehavior` interface (`formatAttackMessage`), and both implementors
call it instead of duplicating the string-building code.

**5. Backward-compatible design (Open/Closed Principle)**
Adding a new Concrete Implementor - e.g. `MagicAttack` - only means writing
one new class that implements `AttackBehavior`. `GameCharacter`, `Warrior`,
`Mage`, and `BridgeDemo`'s existing calls do not need a single line
changed, and any existing character can start using it immediately via
`setAttackBehavior(new MagicAttack())`.
