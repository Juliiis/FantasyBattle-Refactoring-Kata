package codingdojo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    // choose this one if you are familiar with mocks
    //@Disabled("Test is not finished yet")
    @Test
    void damageCalculationsWithMocks() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);
        when(inventory.getEquipment()).thenReturn(equipment());

        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(10, damage.getAmount());
    }

    // choose this one if you are not familiar with mocks
    @Disabled("Test is not finished yet")
    @Test
    void damageCalculations() {
        Inventory inventory = new Inventory(null);
        Stats stats = new Stats(0);
        SimpleEnemy target = new SimpleEnemy(null, null);
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(10, damage.getAmount());
    }

    Equipment equipment(){
        Item rightHand = new BasicItem("flashy sword of danger", 10, 1);
        Item leftHand = new BasicItem("round shield", 0,0);
        Item feet = new BasicItem("ten league boots", 0, 0);
        Item head = new BasicItem("helmet of swiftness", 0, 0);
        Item chest = new BasicItem("breastplate of steel", 0, 0);
        return new Equipment(rightHand, leftHand, feet, head, chest);
    }
}
