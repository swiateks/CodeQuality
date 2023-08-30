import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrk on 4/7/14.
 */
public class PenguinTest {
    @Test
    public void testItCanSwim() {
    	PenguinModified penguin = new PenguinModified(5);
        penguin.swim();
        assertEquals("in the water", penguin.currentLocation);
    }

    @Test
    public void testItLosesFeathersQuickly() {
    	PenguinModified penguin = new PenguinModified(5);
        penguin.molt();
        assertEquals(1, penguin.numberOfFeathers);
    }
}
