import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long prime = sc.nextLong(), temp, reverse = 0;

        if (!BigInteger.valueOf(prime).isProbablePrime(1000)) {
            System.out.println("no");
            return;
        }

        while(prime > 0) {

            switch((int) (prime % 10)) {
                case 0:
                    temp = 0;
                    break;
                case 1:
                    temp = 1;
                    break;
                case 2:
                    temp = 2;
                    break;
                case 5:
                    temp = 5;
                    break;
                case 6:
                    temp = 9;
                    break;
                case 8:
                    temp = 8;
                    break;
                case 9:
                    temp = 6;
                    break;
                default:
                    System.out.println("no");
                    return;
            }

            reverse *= 10;
            reverse += temp;
            prime /= 10;
        }

        if (!BigInteger.valueOf(reverse).isProbablePrime(1000)) System.out.println("no");
        else System.out.println("yes");
    }

    private static boolean isPrime(long n) {
        if (n <= 1) return false;
        for (long i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}