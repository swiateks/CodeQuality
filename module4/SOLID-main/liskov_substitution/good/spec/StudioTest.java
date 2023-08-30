import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrk on 4/8/14.
 */
public class StudioTest {
    @Test
    public void testInitializedWithZeroBedrooms() {
    	StudioModified studio = new StudioModified();
        assertEquals(0, studio.numberOfRooms);
    }

    @Test
    public void testSetsSquareFootage() {
    	StudioModified studio = new StudioModified();
        studio.setSquareFootage(550);

        assertEquals(550, studio.squareFootage);
    }
}
