package bridge;

// Refined Abstraction #1. Adds character-specific flavor but still has
// zero knowledge of AttackBehavior's concrete classes.
public class Warrior extends GameCharacter {

    public Warrior(String name, AttackBehavior attackBehavior) {
        super(name, attackBehavior);
    }

    @Override
    public String describe() {
        return "Warrior " + getName();
    }
}
