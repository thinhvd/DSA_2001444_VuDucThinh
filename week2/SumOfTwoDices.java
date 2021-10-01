public class SumOfTwoDices {
    public static void main(String[] args) {
        int dice = 6;
        int a = 1 + (int) (Math.random() * dice);
        int b = 1 + (int) (Math.random() * dice);
        System.out.println(a + b);
    }
}
