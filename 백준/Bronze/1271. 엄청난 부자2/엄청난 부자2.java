import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger N = new BigInteger(sc.next());
        BigInteger M = new BigInteger(sc.next());
        System.out.printf("%s %s", N.divide(M), N.remainder(M));
    }
}