package bridge;

// Clean Code: no magic numbers - damage values live in one place.
public final class AttackConstants {
    public static final int MELEE_DAMAGE = 30;
    public static final int RANGED_DAMAGE = 20;

    private AttackConstants() {
        // utility class, should not be instantiated
    }
}
