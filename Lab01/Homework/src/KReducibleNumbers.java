
public class KReducibleNumbers {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java KReducibleNumbers <a> <b> <k>");
            return;
        }

        long startTime = System.nanoTime();
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        if (a > b) {
            System.out.println("a must be less than or equal to b");
            return;
        }

        if (k <= 0) {
            System.out.println("k must be a positive integer");
            return;
        }

        String result = new String();

        for (int num = a; num <= b; num++) {
            if (isKReducible(num, k)) {
            result += num + " ";
            }
        }
        long endTime = System.nanoTime();
        long executionTimeNano = endTime - startTime;

        System.out.println(result);
        System.out.println(executionTimeNano + " nanoseconds ");
    }

    public static boolean isKReducible(int num, int k) {
        while (num > 9) {
            int num1 = num;
            int s = 0;
            while (num1 != 0) {
                int last_digit = num1 % 10;
                s = s + last_digit * last_digit;
                num1 = num1 / 10;
            }
            num = s;
        }
        return num == k;
    }
}
