package personal.playWithAlg.class1_3;

import org.omg.CosNaming.BindingIterator;

import java.math.BigInteger;

/**
 * Karatsuba 算法实现
 */
public class Karatsuba {

    public static long karatsuba(long num1, long num2) {
        /** 递归三要素：退出机制 */
        if (num1 < 10 || num2 < 10) {
            return num1 * num2;
        }
        //计算拆分长度
        int size1 = String.valueOf(num1).length();
        int size2 = String.valueOf(num2).length();
        int halfN = Math.max(size1, size2) / 2; // 字符串折半

        /** 拆分为a，b，c，d */
        long a = Long.valueOf(String.valueOf(num1).substring(0, size1 - halfN));
        long b = Long.valueOf(String.valueOf(num1).substring(size1 - halfN));
        long c = Long.valueOf(String.valueOf(num2).substring(0, size2 - halfN));
        long d = Long.valueOf(String.valueOf(num2).substring(size2 - halfN));

        long z2 = karatsuba(a, c);
        long z0 = karatsuba(b, d); /** 次级拆分 */
        long z1 = karatsuba((a + b), (c + d)) - z0 - z2;

        return (long)(z2 * Math.pow(10, (2 * halfN)) + z1 * Math.pow(10, halfN) + z0); /** 同级组合 */
    }

    public static BigInteger karatsuba(BigInteger num1, BigInteger num2){
        if (num1.compareTo(BigInteger.valueOf(10)) < 0 || num2.compareTo(BigInteger.valueOf(10)) < 0) {
            return num1.multiply(num2);
        }
        int n = Math.max(num1.toString().length(), num2.toString().length());
        int halfN = n / 2 + n % 2; //分成两个数，前一个数大于等于后一个数

        //返回num1 / halfN 和 num1 % halfN
        BigInteger[] a_b = num1.divideAndRemainder(BigInteger.valueOf(10).pow(halfN));
        BigInteger a = a_b[0];
        BigInteger b = a_b[1];
        BigInteger[] c_d = num2.divideAndRemainder(BigInteger.valueOf(10).pow(halfN));
        BigInteger c = c_d[0];
        BigInteger d = c_d[1];

        BigInteger step1 = karatsuba(a, c);
        BigInteger step2 = karatsuba(b, d);
        BigInteger step3 = karatsuba(a.add(b), b.add(d));
        BigInteger step4 = step3.subtract(step2).subtract(step1); //step3 - step1 -step2
        BigInteger res = step1.multiply(BigInteger.valueOf(10).pow(2 * halfN)).add(step2).add(step4.multiply(BigInteger.valueOf(10).pow(halfN)));
        return res;
    }

}
