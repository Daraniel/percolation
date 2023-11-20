import java.math.BigInteger;

public class Combination {

    /**
     * calculates combination of k from n
     * @param n Number to combine from
     *@param k Number to combine
     * @return  combination
     */

    public static BigInteger combination(BigInteger n, BigInteger k){
        // stop condition
        if(k.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        // invoking its self, calculating and then returning the value
        return combination(n.subtract(BigInteger.ONE),k.subtract(BigInteger.ONE)).multiply(n).divide(k);
    }

    // test client
    public static void main(String args[]){
        // get the numbers

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        if(k > n){
            System.out.println("Error! \nk must be smaller than n!");
            return;
        }
        else if(k > n/2){
            // speed optimization
            k = n-k;
        }
        // converting to BigInteger in order to calculate bigger numbers
        BigInteger N = BigInteger.valueOf(n);
        BigInteger K = BigInteger.valueOf(k);
        // calling the combination function
        // first checking if N is small enough to fit in memory
        if(n<9999) {
            System.out.println("calculation with recursive function: \n" + combination(N, K));
        }
        else{
            System.out.println("N is too big!\ndisabling recursive mode!");
        }

        // calculating with for
        // initializing the values
        N = N.subtract(K).add(BigInteger.ONE);
        K = BigInteger.ONE;
        // initializing overflow detector variables
        BigInteger result = BigInteger.ONE;
        BigInteger over_flow_detector = BigInteger.ONE;
        int detection;
        // starting for
        for(int i = 0; i<k; i++){
            // calculating
            result = (result.multiply(N)).divide(K);
            N = N.add(BigInteger.ONE);
            K = K.add(BigInteger.ONE);
            // comparing previous value with the new one for overflow detection
            // if prev>=new then overflow happened
            detection = result.compareTo(over_flow_detector);
            switch (detection){
                case 0:
                case -1: {
                    System.out.println("overflow!\nnumber out of range!");
                    return;
                }
            }
            // updating detector value
            over_flow_detector = result;
        }
        // printing the result
        System.out.println("\n\ncalculation with for: \n" + result);
    }
}
