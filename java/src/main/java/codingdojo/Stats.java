package codingdojo;

public class Stats {
    // TODO add dexterity that will both help with soak and damage.
    //  but half of what strength gives.
    private final int strength;
    private Stats stats;
    public Stats(int strength) {
        this.strength = strength;
    }
    int getStrength() {
        return strength;
    }
    float getStrengthModifier() {
        return stats.getStrength() * 0.1f;
    }
}
