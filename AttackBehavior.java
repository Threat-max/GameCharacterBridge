package bridge;

// Implementor. Declares the low-level operation(s) that every
// "how it attacks" implementation must provide. The Abstraction
// (GameCharacter) only ever talks to this interface - it never
// knows which concrete implementor is behind it.
public interface AttackBehavior {

    void performAttack(String characterName);

    // Java 8 default method: shared formatting logic so Concrete
    // Implementors don't duplicate the same string-building code
    // (Clean Code: no duplicated logic between Concrete Implementors).
    default String formatAttackMessage(String characterName, String verb, int damage) {
        return characterName + " " + verb + " for " + damage + " damage!";
    }
}
