import java.util.ArrayList;
import java.math.BigInteger;
/**
 * Write a description of class TestStatsLibrary here.
 *
 * @author Ahmed Malik
 * @version 10/30/23
 */
public class TestStatsLibrary
{
    public static void main(String[] args){
        StatsLibrary test = new StatsLibrary();
        
        
        ArrayList<Double> testNumbers = new ArrayList<>();
        testNumbers.add(1.0);
        testNumbers.add(2.0);
        testNumbers.add(3.0);
        testNumbers.add(4.0);
        testNumbers.add(5.0);
        testNumbers.add(6.0);
        testNumbers.add(7.0);
        testNumbers.add(1.0);
        //Chapter 1
        double testMean = test.findMean(testNumbers);
        double testMode = test.findMode(testNumbers);
        double testMedian = test.findMedian(testNumbers);
        double testStandardDeviation = test.standardD(testNumbers);
        
        System.out.println("This is the average of testNumbers " + testMean);
        System.out.println("This is the mode of testNumbers " + testMode);
        System.out.println("This is the median of testNumbers " + testMedian);
        System.out.println("This is the standard deviation of testNumbers " + testStandardDeviation);
        
        ArrayList<Double> testNumbers2 = new ArrayList<>();
        testNumbers2.add(2.0);
        testNumbers2.add(5.0);
        testNumbers2.add(7.0);
        testNumbers2.add(10.0);
        testNumbers2.add(8.0);
        
        
        //Chapter 2
        ArrayList<Double> testUnion = test.union(testNumbers, testNumbers2);
        System.out.println("Union of the 2 arrays is: " + testUnion);
        
        ArrayList<Double> testIntersection = test.intersect(testNumbers, testNumbers2);
        System.out.println("Intersection of the 2 arrays is: " + testIntersection);
        
        ArrayList<Double> testComplement = test.complement(testNumbers, testNumbers2);
        System.out.println("Complement of the 2 arrays is: " + testComplement);
        
        BigInteger testFactorial = test.factorial(BigInteger.valueOf(5));
        System.out.println("Factorial of the 5 is: " + testFactorial);
        
        BigInteger testPermutation = test.permutation(BigInteger.valueOf(10), BigInteger.valueOf(5));
        System.out.println("Permutation of the 10 and 5 is: " + testPermutation);
        
        BigInteger testCombination = test.combination(BigInteger.valueOf(10), BigInteger.valueOf(5));
        System.out.println("Combination of the 10 and 5 is: " + testCombination);
        
        double testCondP = test.conditionalProb(1.0, 4.0);
        System.out.println("Condtional probability is: " + testCondP);
        
        double testBayes = test.bayesTheorum(1.0, 4.0);
        System.out.println("Probability by Bayes Theorum is: " + testBayes);
        
        
        //Chapter 3
        double testBD = test.binomialDistribution(18, 15, 0.85);
        System.out.println("Probability by Binomial Distribution is: " + testBD);
        
        double testExpectedBD = test.expectedBD(18, 0.5);
        System.out.println("Binomial expected is: " + testExpectedBD);
        
        double testVarianceBD = test.varianceBD(10, 0.25);
        System.out.println("Binomial variance is: " + testVarianceBD);
        
        double testGD = test.geometricDistribution(0.5, 2.0);
        System.out.println("Probability by Geometric Distribution is: " + testGD);
        
        double testExpectedGD = test.expectedGeometric(0.5);
        System.out.println("Geometric expected is: " + testExpectedGD);
        
        double testVarianceGD = test.varianceGeometric(0.5);
        System.out.println("Geometric variance is: " + testVarianceGD);
        
        double testHG = test.hyperGeometricDistribution(101, 7, 196, 10);
        System.out.println("Probability by Hyper Geometric Distribution: " + testHG);
        
        double testExpectedHG = test.expectedHyperGeometric(196, 101, 10);
        System.out.println("Hyper Geometric Expected is: " + testExpectedHG);
        
        double testVarianceHG = test.varianceHyperGeometric(196, 101, 10);
        System.out.println("Hyper Geometric Variance is: " + testVarianceHG);
        
        double testNB = test.negativeBinomial(5, 2, .2);
        System.out.println("Probability by Negative Binomial is: " + testNB);
        
        double testExpectedNB = test.expectedNegativeBinomial(3, 0.2);
        System.out.println("Negative Binomial Expected is: " + testExpectedNB);
        
        double testVarianceNB = test.varianceNegativeBinomial(3, 0.2);
        System.out.println("Negative Binomial Variance is: " + testVarianceNB);
        
        double testPoisson = test.poissonDistribution(0, 3.5);
        System.out.println("Probability by Poisson is: " + testPoisson);
        
        double testExpectedAndVariancePoisson = test.poissonEpectedAndVariance(3.5);
        System.out.println("Expected and Variance of Poisson is: " + testExpectedAndVariancePoisson);

        double testChebyshevsTheorem = test.chebyshevsTheorem(2.0);
        System.out.println("Probability by Chebyshevs Theorem is: " + testChebyshevsTheorem);
        
        
        
        
        
        
        
        
        
    }
}