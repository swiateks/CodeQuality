import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrk on 4/8/14.
 */
public class BedroomAdderTest {
    @Test
    public void testAddsBedroomToPenthouse() {
        PenthouseSuiteModified penthouse = new PenthouseSuiteModified();
        BedroomAdder adder = new BedroomAdder();
        adder.addBedroom(penthouse);

        assertEquals(5, penthouse.numberOfBedrooms);
    }
}
