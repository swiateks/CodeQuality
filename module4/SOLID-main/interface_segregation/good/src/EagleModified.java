/**
 * Created by mrk on 4/7/14.
 */
public class EagleModified implements FlyingCreature, FeatheredCreature {
    String currentLocation;
    int numberOfFeathers;

    public EagleModified(int initialNumberOfFeathers) {
        this.numberOfFeathers = initialNumberOfFeathers;
    }

    public void fly() {
        this.currentLocation = "in the air";
    }

    public void molt() {
        this.numberOfFeathers -= 1;
    }
}
