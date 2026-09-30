package bridge;

// Refined Abstraction #2. Any AttackBehavior can be paired with a Mage
// too - a Mage is not restricted to "magic" attacks, proving the two
// hierarchies (character type vs. attack style) really are independent.
public class Mage extends GameCharacter {

    public Mage(String name, AttackBehavior attackBehavior) {
        super(name, attackBehavior);
    }

    @Override
    public String describe() {
        return "Mage " + getName();
    }
}
