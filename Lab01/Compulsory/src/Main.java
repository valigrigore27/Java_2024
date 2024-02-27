public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        System.out.println("Number n: "+ n);
        n = n * 3;
        String binary = "10101";
        int decimal = Integer.parseInt(binary, 2);
        System.out.println("Binary number 10101 to decimal: " + decimal);
        //add to n
        n = n + decimal;
        String hex = "FF";
        decimal = Integer.parseInt(hex, 16);
        //add to n
        n = n + decimal;
        System.out.println("Hexadecimal number FF to decimal: " + decimal);
        n = n * 6;
        System.out.println("Number n: " + n);

        while(n > 9){
            int sum = 0;
            int m = n;
            while(m > 0){
                sum += m % 10;
                m /= 10;
            }
            n = sum;
        }
        System.out.println("Sum of new n digits: "+ n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}