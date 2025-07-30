import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println("Choose operation: 1 for add, 2 for subtract");
        int choice = scanner.nextInt();

        Calculator calculator = new SimpleCalculator();

        switch (choice) {
            case 1:
                int sum = calculator.add(a, b);
                System.out.println(a + " + " + b + " = " + sum);
                break;
            case 2:
                int difference = calculator.subtract(a, b);
                System.out.println(a + " - " + b + " = " + difference);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        scanner.close();
    }
}
/*public class Main {
    public static void main(String[] args) {
        Calculator calculator = new SimpleCalculator();

        // 测试加法
        int sum = calculator.add(5, 3);
        System.out.println("5 + 3 = " + sum);

        // 测试减法
        int difference = calculator.subtract(10, 4);
        System.out.println("10 - 4 = " + difference);
    }
}
*/