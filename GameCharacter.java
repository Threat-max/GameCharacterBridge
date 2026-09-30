package bridge;

// Abstraction. Holds a reference to an AttackBehavior (the bridge) and
// delegates the actual attack logic to it instead of implementing attack
// mechanics itself. This class knows WHAT a character is, never HOW an
// attack is executed - that separation is the whole point of the pattern.
public abstract class GameCharacter {

    private final String name;
    private AttackBehavior attackBehavior;

    protected GameCharacter(String name, AttackBehavior attackBehavior) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Character name cannot be empty");
        }
        if (attackBehavior == null) {
            throw new IllegalArgumentException("Character must have an attack behavior");
        }
        this.name = name;
        this.attackBehavior = attackBehavior;
    }

    // Lets the client swap the implementation at runtime without ever
    // touching the Abstraction or Refined Abstraction classes.
    public void setAttackBehavior(AttackBehavior attackBehavior) {
        if (attackBehavior == null) {
            throw new IllegalArgumentException("Character must have an attack behavior");
        }
        this.attackBehavior = attackBehavior;
    }

    public void attack() {
        attackBehavior.performAttack(name);
    }

    // Each Refined Abstraction describes itself differently.
    public abstract String describe();

    protected String getName() {
        return name;
    }
}
