package bridge;

// Concrete Implementor #2. A completely independent implementation of
// "how to attack" - it can be plugged into ANY Refined Abstraction below.
public class RangedAttack implements AttackBehavior {
    @Override
    public void performAttack(String characterName) {
        System.out.println(formatAttackMessage(characterName, "fires an arrow", AttackConstants.RANGED_DAMAGE));
    }
}
