package codingdojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
    // choose this one if you are familiar with mocks
    //@Disabled("Test is not finished yet")
    @Test
    void damageCalculationForFlashySwordOfDanger() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);

        when(target.getSoakCalculated()).thenReturn(5);
        when(inventory.getEquipment()).thenReturn(newEquipment());
        when(inventory.getBaseDamage()).thenReturn(10);
        when(inventory.getDamageModifier()).thenReturn(1.0f);

        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(5, damage.getAmount());
    }

    @Test
    void damageCalculationForExcalibur() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);

        when(target.getSoakCalculated()).thenReturn(5);
        when(inventory.getEquipment()).thenReturn(newEquipment());
        when(inventory.getBaseDamage()).thenReturn(20);
        when(inventory.getDamageModifier()).thenReturn(1.5f);

        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(25, damage.getAmount());
    }

    @Test
    void damageCalculationForRoundShield() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);

        when(target.getSoakCalculated()).thenReturn(5);
        when(inventory.getEquipment()).thenReturn(newEquipment());
        when(inventory.getBaseDamage()).thenReturn(0);
        when(inventory.getDamageModifier()).thenReturn(1.4f);

        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(0, damage.getAmount());
    }

    @Test
    void damageCalculationForTenLeagueBoots() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);

        when(target.getSoakCalculated()).thenReturn(5);
        when(inventory.getEquipment()).thenReturn(newEquipment());
        when(inventory.getBaseDamage()).thenReturn(0);
        when(inventory.getDamageModifier()).thenReturn(0.1f);

        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(0, damage.getAmount());
    }

    Equipment newEquipment(){
        Item rightHand = new BasicItem("flashy sword of danger", 10, 1);
        Item leftHand = new BasicItem("round shield", 0,0);
        Item feet = new BasicItem("ten league boots", 0, 0);
        Item head = new BasicItem("helmet of swiftness", 0, 0);
        Item chest = new BasicItem("breastplate of steel", 0, 0);
        return new Equipment(rightHand, leftHand, feet, head, chest);
    }
}
