public class Test {
    public  int fee;
    public static int addFees(int x) {
    return x + fee;
    }
    public static void main(String[] args) {
    int y=10;
    Test.fee=5;
    y = Test.addFees(y);
    System.out.println(y);
    }
}