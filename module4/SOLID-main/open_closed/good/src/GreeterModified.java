/**
 * Created by mrk on 4/7/14.
 */
public class GreeterModified {
    private Personality personality;

    public GreeterModified(Personality personality) {
        this.personality = personality;
        }

    public String greet() {
        return this.personality.greet();
    }
}
