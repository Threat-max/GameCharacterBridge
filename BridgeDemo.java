package bridge;

// Client. Composes a Refined Abstraction with a Concrete Implementor at
// runtime, and demonstrates switching the implementation WITHOUT touching
// the Abstraction/Refined Abstraction classes at all.
public class BridgeDemo {
    public static void main(String[] args) {
        GameCharacter warrior = new Warrior("Conan", new MeleeAttack());
        System.out.println(warrior.describe() + " is ready.");
        warrior.attack();

        GameCharacter mage = new Mage("Gandalf", new RangedAttack());
        System.out.println(mage.describe() + " is ready.");
        mage.attack();

        // Switch the Warrior's attack style at runtime - proves the two
        // hierarchies (character type and attack style) vary independently.
        System.out.println(warrior.describe() + " picks up a bow instead:");
        warrior.setAttackBehavior(new RangedAttack());
        warrior.attack();
    }
}
