public class CountEven {
    public static void main(String[] args) {
        //计数器初始化
        int count = 0;
        //限定范围1·100内的整数
        for (int i = 1; i <= 100; i++) {
            //判断是否为偶数
            if (i % 2 == 0) {
                System.out.print(i + " ");//在两数间增加空格，更加美观
                count++;
                //每打印5个数，就打印一个换行符
                if (count % 5 == 0) {
                    System.out.println();
                }
            }
        }
    }
}
