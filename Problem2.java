import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a, b, c: ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        Rational h = new Rational(-b, 2 * a);
        Rational k = new Rational((a * h.getNumerator() * h.getNumerator() + b * h.getNumerator() + c) * 4 * a * a, 4 * a * a);
        
        System.out.println("h is " + h);
        System.out.println("k is " + k);
    }

    static class Rational extends Number implements Comparable<Rational> {
        // Data fields for numerator and denominator
        private long[] r = new long[2];

        /**Default constructor*/
        public Rational() {
            this(0, 1);
        }

        /**Construct a rational with specified numerator and denominator*/
        public Rational(long numerator, long denominator) {
            long gcd = gcd(numerator, denominator);
            this.r[0] = numerator/gcd;
            this.r[1] = denominator/gcd;
        }

        /**Find GCD of two numbers*/
        private long gcd(long n, long d) {
            long t1 = Math.abs(n);
            long t2 = Math.abs(d);
            long remainder = t1%t2;

            while (remainder != 0) {
                t1 = t2;
                t2 = remainder;
                remainder = t1%t2;
            }

            return t2;
        }

        /**Return numerator*/
        public long getNumerator() {
            return r[0];
        }

        /**Return denominator*/
        public long getDenominator() {
            return r[1];
        }

        @Override
        public String toString() {
            if (r[1] == 1)
                return r[0] + "";
            else
                return r[0] + "/" + r[1];
        }

        /**Override the equals method*/
        public boolean equals(Object parm1) {
            /**@todo: Override this java.lang.Object method*/
            if ((this.subtract((Rational)(parm1))).getNumerator() == 0)
                return true;
            else
                return false;
        }

        /**Override the intValue method*/
        public int intValue() {
            /**@todo: implement this java.lang.Number abstract method*/
            return (int)doubleValue();
        }

        /**Override the floatValue method*/
        public float floatValue() {
            /**@todo: implement this java.lang.Number abstract method*/
            return (float)doubleValue();
        }

        /**Override the doubleValue method*/
        public double doubleValue() {
            /**@todo: implement this java.lang.Number abstract method*/
            return r[0]*1.0/r[1];
        }

        /**Override the longValue method*/
        public long longValue() {
            /**@todo: implement this java.lang.Number abstract method*/
            return (long)doubleValue();
        }

        @Override
        public int compareTo(Rational o) {
            /**@todo: Implement this java.lang.Comparable method*/
            if ((this.subtract((Rational)o)).getNumerator() > 0)
                return 1;
            else if ((this.subtract((Rational)o)).getNumerator() < 0)
                return -1;
            else
                return 0;
        }
    }

}
