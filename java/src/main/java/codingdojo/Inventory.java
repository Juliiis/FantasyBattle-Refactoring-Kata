package codingdojo;

public class Inventory {
    private Equipment equipment;
    Stats stats;

    public Inventory(Equipment equipment) {
        this.equipment = equipment;
    }

    Equipment getEquipment() {
        return equipment;
    }

    public int getBaseDamage() {
        Equipment equipment = getEquipment();
        Item leftHand = equipment.getLeftHand();
        Item rightHand = equipment.getRightHand();
        Item head = equipment.getHead();
        Item feet = equipment.getFeet();
        Item chest = equipment.getChest();
        return leftHand.getBaseDamage() +
          rightHand.getBaseDamage() +
          head.getBaseDamage() +
          feet.getBaseDamage() +
          chest.getBaseDamage();
    }

    public float getDamageModifier() {
        Equipment equipment = getEquipment();
        Item leftHand = equipment.getLeftHand();
        Item rightHand = equipment.getRightHand();
        Item head = equipment.getHead();
        Item feet = equipment.getFeet();
        Item chest = equipment.getChest();
        float strengthModifier = stats.getStrength() * 0.1f;
        return strengthModifier +
          leftHand.getDamageModifier() +
          rightHand.getDamageModifier() +
          head.getDamageModifier() +
          feet.getDamageModifier() +
          chest.getDamageModifier();
    }
}
