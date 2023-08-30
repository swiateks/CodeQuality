import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrk on 4/7/14.
 */
public class EagleTest {
    @Test
    public void testItCanFly() {
        EagleModified eagle = new EagleModified(5);
        eagle.fly();
        assertEquals("in the air", eagle.currentLocation);
    }

    @Test
    public void testItLosesFeathers() {
    	EagleModified eagle = new EagleModified(5);
        eagle.molt();
        assertEquals(4, eagle.numberOfFeathers);
    }
}
