/*
In this scenario the below class can cause a potential memory leak due to heavy use of static variables.
In Java, static fields have a life that usually matches the entire lifetime of the running application (unless ClassLoader becomes eligible for garbage collection).
However, if we just drop the keyword static in line number 2 of the above program, then it'll bring a drastic change to the memory usage
*/

public class StaticTest {
    public static List<Double> list = new ArrayList<>();

    public void populateList() {
        for (int i = 0; i < 10000000; i++) {
            list.add(Math.random());
        }
        Log.info("Debug Point 2");
    }

    public static void main(String[] args) {
        Log.info("Debug Point 1");
        new StaticTest().populateList();
        Log.info("Debug Point 3");
    }
}

