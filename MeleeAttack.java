package bridge;

// Concrete Implementor #1. Knows only HOW a melee hit happens - nothing
// about what kind of character is using it.
public class MeleeAttack implements AttackBehavior {
    @Override
    public void performAttack(String characterName) {
        System.out.println(formatAttackMessage(characterName, "swings a blade", AttackConstants.MELEE_DAMAGE));
    }
}
