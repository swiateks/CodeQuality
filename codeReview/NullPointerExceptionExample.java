public class NullPointerExceptionExample {
    private static void printLength(String str) {
        System.out.println(str.length());
    }

    public static void main(String args[]) {
        String myString = null;
        printLength(myString);
    }
}
