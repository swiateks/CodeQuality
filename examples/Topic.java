// Java program to illustrate 
// loose coupling concept
public interface Topic
{
    void understand();
}
class Topic1 implements Topic {
public void understand()
    {
        System.out.println("Got it");
    }
} class Topic2 implements Topic {
public void understand()
    {
        System.out.println("understand");
    }
} public class Subject {
public static void main(String[] args)
    {
        Topic t = new Topic1();
        t.understand();
    }
}

/*
In the above example, Topic1 and Topic2 objects are loosely coupled. 
It means Topic is an interface and we can inject any of the implemented classes at run time and we can provide service to the end user.
*/
