package codingdojo;
public class Inventory {
    private final Equipment equipment;
    private Stats stats;
    public Inventory(Equipment equipment) {
        this.equipment = equipment;
    }
    Equipment getEquipment() {
        return equipment;
    }
    public int getBaseDamage() {
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
        Item leftHand = equipment.getLeftHand();
        Item rightHand = equipment.getRightHand();
        Item head = equipment.getHead();
        Item feet = equipment.getFeet();
        Item chest = equipment.getChest();
        float strengthModifier = stats.getStrengthModifier();
        return strengthModifier +
          leftHand.getDamageModifier() +
          rightHand.getDamageModifier() +
          head.getDamageModifier() +
          feet.getDamageModifier() +
          chest.getDamageModifier();
    }

}
