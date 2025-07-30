import java.util.Scanner;

public class TheTallestStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入整数n表示班上同学的数量：");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("请输入第 " + (i + 1) + " 位同学的身高：");
            arr[i] = sc.nextInt();
        }
        // 调用 findMax 方法并接收返回值
        int tallestIndex = findMax(arr);
        // 输出最高同学的身高
        System.out.println("最高的同学身高为: " + arr[tallestIndex] + "cm");
        System.out.println("该同学被选为旗手。");
        sc.close(); // 关闭 Scanner 对象
    }

    /**
     * 找出数组中的最大值的索引
     * @param arr 整数数组
     */
    public static int findMax(int[] arr) {
        int maxIndex = 0; // 假设第一个元素是最大的
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i; // 更新最大值的索引
            }
        }
        return maxIndex; // 返回最大值的索引
    }
}