package codingdojo;


class Player extends Target {
    private final Inventory inventory;
    private Stats stats;

    Player(Inventory inventory, Stats stats) {
        this.inventory = inventory;
        this.stats = stats;
    }

    Damage calculateDamage(Target target) {
        int baseDamage = inventory.getBaseDamage();
        float damageModifier = inventory.getDamageModifier();
        int totalDamage = Math.round(baseDamage * damageModifier);
        int soak = getSoak(target, totalDamage);
        return new Damage(Math.max(0, totalDamage - soak));
    }

    private int getSoak(Target target, int totalDamage) {
        int soak = 0;
        if (target instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage;
        } else if (target instanceof SimpleEnemy) {
            SimpleEnemy simpleEnemy = (SimpleEnemy) target;
            soak = simpleEnemy.calculateSoak();
        }
        return soak;
    }

}
