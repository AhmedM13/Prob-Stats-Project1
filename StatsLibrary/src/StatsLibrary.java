import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Ahmed Malik
 */
public class StatsLibrary
{

    //CHAPTER 1
    
	/**
	 * Calculates the mean of a set of doubles.
	 * 
	 * @param userInputNumbers The list of doubles.
	 * @return The mean of the list.
	 * @throws IllegalArgumentException if list is empty.
	 */
    public double findMean(ArrayList<Double> userInputNumbers)
    {
    	if(userInputNumbers.isEmpty()) 
    	{
            throw new IllegalArgumentException("List cannot be empty");
        }
        double sum = 0;
        for(double  singleElement : userInputNumbers)
        {
            sum = sum + singleElement;
        }
        //Storing a value for clarity
        double result = sum / userInputNumbers.size();
        return result;
    }
    
    
    /**
     * Calculates the mode of the set of doubles.
     * 
     * @param userInputNumbers The list of doubles.
     * @return The mode of the list.
     * @throws IllegalArgumentException if list is empty.
     */
    public double findMode(ArrayList<Double> userInputNumbers)
    {
    	if(userInputNumbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
    	 double maxNumber = 0;
    	 double maxAppearences = 0;
    	 for(int i=0; i <userInputNumbers.size(); i++) 
    	 {
    		 int count = 0;
    		 for(int j = 0; j < userInputNumbers.size(); j++) 
    		 {
    			 if(userInputNumbers.get(i) == userInputNumbers.get(j)) 
    			 {
    				 count++;
    			 }
    		 }
    		 if(count > maxAppearences) 
    		 {
    			 maxNumber = userInputNumbers.get(i);
    			 maxAppearences = count;
    		 }
    	 }
    	 return maxNumber;
    }
    
    
    /**
     * Calculates the median of the set of doubles.
     * 
     * @param userInputNumbers The list of doubles.
     * @return Median of the list.
     * @throws IllegalArgumentException if list is empty.
     */
    public double findMedian(ArrayList<Double> userInputNumbers)
    {
    	if(userInputNumbers.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
    	double result = 0;
    	//Sorts the ArrayList from least to greatest
    	Collections.sort(userInputNumbers);
		
		if (userInputNumbers.size()%2 != 0) 
		{
			result = userInputNumbers.get(userInputNumbers.size()/2);
		}
		else
			result = (((userInputNumbers.get(userInputNumbers.size()/2))+(userInputNumbers.get((userInputNumbers.size()/2)-1)))/2.0);
			
		return result;
    }
    
    
    /**
     * Calculates the standard deviation of a set of doubles.
     * 
     * @param userInputNumbers The list of doubles.
     * @return The standard deviation of the list.
     * @throws IllegalArgumentException if list is empty
     */
    public double standardD(ArrayList<Double> userInputNumbers) 
    {
    	if(userInputNumbers.isEmpty()) 
    	{
            throw new IllegalArgumentException("List cannot be empty");
        }
    	double sum = 0.0;
    	double standardDeviation = 0.0;
    	
    	for(double num : userInputNumbers) 
    	{
    		sum += num;
    	}
    	
    	double mean = sum/(userInputNumbers.size());
    	
    	for(double num : userInputNumbers) 
    	{
    		standardDeviation += Math.pow(num - mean, 2);
    	}
    	return Math.sqrt(standardDeviation/userInputNumbers.size());
    }
    
    
    
    
    //CHAPTER 2
    
    /**
     * Calculates the union of two sets.
     * 
     * @param arr1 First list of doubles.
     * @param arr2 Second list of doubles.
     * @return The union of the two lists.
     */
    public ArrayList<Double> union(ArrayList<Double> arr1, ArrayList<Double> arr2) 
    {
        ArrayList<Double> union = new ArrayList<>();

        // Adding all distinct elements from arr1
        for (Double num : arr1) 
        {
            if (!union.contains(num)) 
            {
                union.add(num);
            }
        }

        // Adding all distinct elements from arr2
        for (Double num : arr2) 
        {
            if (!union.contains(num)) 
            {
                union.add(num);
            }
        }
        return union;
    }
    
    
    /**
     * Calculates the intersection of two sets.
     * 
     * @param arr1 First list of doubles.
     * @param arr2 Second list of doubles.
     * @return The intersect of the two lists.
     */
    public ArrayList<Double> intersect(ArrayList<Double> arr1, ArrayList<Double> arr2) 
    {
        ArrayList<Double> intersection = new ArrayList<>();

        for (Double num : arr1) 
        {
            if (arr2.contains(num) && !intersection.contains(num)) 
            {
                intersection.add(num);
            }
        }

        return intersection;
    }
    
    
    /**
     * Calculates the complement of two sets.
     * 
     * @param arr1 First list of doubles.
     * @param arr2 Second list of doubles.
     * @return The complement of the two lists.
     */
    public ArrayList<Double> complement(ArrayList<Double> arr1, ArrayList<Double> arr2){
    	ArrayList<Double> complement = new ArrayList<>();
    	
    	for (Double num : arr1)
    	{
    		if(!arr2.contains(num) && !complement.contains(num))
    		{
    			complement.add(num);
    		}
    	}
    	return complement;
    }
    
    
    /**
     * Calculates the factorial of a number.
     * 
     * @param n The number being factorialed.
     * @return The factorial of n.
     * @throws IllegalArgumentException if n is negative.
     */
    public BigInteger factorial(BigInteger n)
    {
    	if(n.compareTo(BigInteger.ZERO) < 0) 
    	{
            throw new IllegalArgumentException("Number cannot be negative");
        }
		BigInteger result = BigInteger.valueOf(1);
		for (int i = 1; i <= n.intValue(); i++) 
		{
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
    
    
    /**
     * Calculates the permutation of n taken r at a time.
     *
     * @param n Total number of items.
     * @param r Number of items to choose.
     * @return The permutation value.
     * @throws IllegalArgumentException if n is less than r.
     */
    public BigInteger permutation(BigInteger n, BigInteger r)
    {
    	if(n.compareTo(r) < 0) 
    	{
            throw new IllegalArgumentException("n should be greater than or equal to r");
        }
		BigInteger result = (factorial(n)).divide(factorial(n.subtract(r)));
		return result;
	}
    
    
    /**
     * Calculates n choose r
     * 
     * @param n Number of distinct objects.
     * @param y The number of combinations.
     * @return The combination value.
     * @throws IllegalArgumentException if n is less than y.
     */
    public BigInteger combination(BigInteger n, BigInteger y)
    {
    	if(n.compareTo(y) < 0) 
    	{
            throw new IllegalArgumentException("n should be greater than or equal to y");
        }
		BigInteger result = (factorial(n)).divide((factorial(y)).multiply(factorial(n.subtract(y))));
		return result;
	}
    
    
    /**
     * Calculates the conditional probability of A given B.
     *
     * @param prob_of_AintersectB Probability of the intersection of A and B.
     * @param prob_of_B Probability of event B.
     * @return The conditional probability of A given B.
     * @throws IllegalArgumentException if prob_of_B is less than or equal zero.
     */
    public double conditionalProb(double prob_of_AintersectB, double prob_of_B)
    {
    	if(prob_of_B <= 0) 
    	{
            throw new IllegalArgumentException("Probability of B cannot be less than or equal to zero");
        }
    	double result = prob_of_AintersectB/prob_of_B;
    	return result;
    }
    
    
    /**
     * Applies Bayes' theorem to calculate the probability of B given A.
     *
     * @param prob_of_BintersectA Probability of the intersection of B and A.
     * @param prob_of_A Probability of event A.
     * @return The probability of B given A.
     * @throws IllegalArgumentException if prob_of_A is less than or equal to zero.
     */
    public double bayesTheorum(double prob_of_BintersectA, double prob_of_A)
    {
    	if(prob_of_A <= 0) 
    	{
            throw new IllegalArgumentException("Probability of A cannot be less than or equal to zero");
        }
    	double result = prob_of_BintersectA/prob_of_A;
    	return result;
    }
    
    
    /**
     * Checks if two events A and B are independent.
     *
     * @param prob_of_A Probability of event A.
     * @param prob_of_B Probability of event B.
     * @param probAIntersectB Probability of the intersection of A and B.
     * @return True if the events are independent, false otherwise.
     * @throws IllegalArgumentException if Probabilities are not within 0 and 1.
     */
    public boolean checkIndependence(double prob_of_A, double prob_of_B, double probAIntersectB) 
    {
    	if (prob_of_A < 0 || prob_of_A > 1 || prob_of_B < 0 || prob_of_B > 1 || probAIntersectB < 0 || probAIntersectB > 1) 
    	{
            throw new IllegalArgumentException("Probabilities must be between 0 and 1.");
        }
    	if(prob_of_A * prob_of_B == probAIntersectB)
    	{
    		return true;
    	}
    	return false;
    }
    
    
    
    
    //CHAPTER 3
    
    /**
     * Calculates the probability using the binomial distribution formula.
     *
     * @param n Number of trials.
     * @param y Number of successes.
     * @param p Probability of success on an individual trial.
     * @return The binomial probability.
     * @throws IllegalArgumentException if p is not between 0 and 1.
     */
    public double binomialDistribution(int n, int y, double p) 
    {
    	if(p < 0 || p > 1) 
    	{
            throw new IllegalArgumentException("Probability p should be between 0 and 1");
        }
		double q = 1 - p;
		
		//Combination
		BigInteger combination = combination(BigInteger.valueOf(n),BigInteger.valueOf(y));
		//(p)^y
		double pPower = Math.pow(p, y);

		//(q)^(n-y)
		double qPower = Math.pow((q), (n-y));
		
		double result = (combination.doubleValue() * pPower * qPower);
		return result;
	}
    
    
    /**
     * Calculates the expected value (mean) for a binomial distribution.
     * 
     * @param n Number of trials.
     * @param p Probability of success on an individual trial.
     * @return the expected value.
     * @throws IllegalArgumentException if p is not between 0 and 1.
     */
    public double expectedBD(int n, double p) 
    {
    	if(p < 0 || p > 1) 
    	{
            throw new IllegalArgumentException("Probability p should be between 0 and 1");
        }
        return n * p;
    }
    

    /**
     * Calculates the variance for a binomial distribution.
     * 
     * @param n Number of trials.
     * @param p Probability of success.
     * @return the variance.
     * @throws IllegalArgumentException if p is not between 0 and 1.
     */
    public double varianceBD(int n, double p) 
    {
    	if(p < 0 || p > 1) 
    	{
            throw new IllegalArgumentException("Probability p should be between 0 and 1");
        }
        return n * p * (1 - p);
    }
    
    
    /**
     * Calculates the probability using the geometric distribution formula.
     *
     * @param p Probability of success.
     * @param y Number of trials required to get the first success.
     * @return The geometric probability.
     * @throws IllegalArgumentException if y is less than 1 or p is out of bounds.
     */
    public double geometricDistribution(double p, double y) 
    {
    	if(y < 1 || p < 0 || p > 1) 
    	{
            throw new IllegalArgumentException("Invalid arguments");
        }
		double result = (Math.pow((1-p), (y-1))* p);
		return result;
	}
    
    
    /**
     * Calculates the expected value (mean) for a geometric distribution.
     * 
     * @param p Probability of success.
     * @return The expected value.
     * @throws IllegalArgumentException if p is not between 0 and 1.
     */
    public double expectedGeometric(double p) 
    {
        if (p <= 0 || p > 1) 
        {
            throw new IllegalArgumentException("Probability p should be between 0 and 1");
        }
        return 1.0 / p;
    }
    

    /**
     * Calculates the variance for a geometric distribution.
     * 
     * @param p Probability of success.
     * @return The variance.
     * @throws IllegalArgumentException if p is not between 0 and 1.
     */
    public double varianceGeometric(double p) 
    {
        if (p <= 0 || p > 1) 
        {
            throw new IllegalArgumentException("Probability p should be between 0 and 1");
        }
        return (1.0 - p) / (p * p);
    }
    
    
    /**
     * Calculates the probability using the hypergeometric distribution formula.
     *
     * @param r Number of success states in the population.
     * @param y Number of successes in the sample.
     * @param N Population size.
     * @param n Sample size.
     * @return The hyper-geometric probability.
     * @throws IllegalArgumentException if parameters are invalid.
     */
    public double hyperGeometricDistribution(int r, int y, int N, int n) 
    {
        if (y > r || y > n || n - y > N - r) 
        {
        	throw new IllegalArgumentException("Invalid parameters");
        }

        BigInteger num1 = combination(BigInteger.valueOf(r), BigInteger.valueOf(y));
        BigInteger num2 = combination(BigInteger.valueOf(N - r), BigInteger.valueOf(n - y));
        BigInteger denom = combination(BigInteger.valueOf(N), BigInteger.valueOf(n));

        BigInteger numeratorProduct = num1.multiply(num2);

        double probability = numeratorProduct.doubleValue() / denom.doubleValue();

        return probability;
    }
    
    
    /**
     * Calculates the expected value (mean) for a hypergeometric distribution.
     * 
     * @param N Population size.
     * @param r Number of success states in the population.
     * @param n Number of draws.
     * @return The expected value.
     * @throws IllegalArgumentException if parameters are invalid.
     */
    public double expectedHyperGeometric(int N, int r, int n) 
    {
        if (N <= 0 || r < 0 || r > N || n < 0 || n > N) 
        {
            throw new IllegalArgumentException("Invalid parameters");
        }
        return n * ((double) r / N);
    }
    

    /**
     * Calculates the variance for a hypergeometric distribution.
     * 
     * @param N Population size.
     * @param r Number of success.
     * @param n Number of draws.
     * @return The variance.
     * @throws IllegalArgumentException if parameters are invalid.
     */
    public double varianceHyperGeometric(int N, int r, int n) 
    {
        if (N <= 0 || r < 0 || r > N || n < 0 || n > N) 
        {
            throw new IllegalArgumentException("Invalid parameters");
        }
        double multiplier = ((double) n * r) / N;
        return multiplier * ((double) (N - r) / N) * ((double) (N - n) / (N - 1));
    }
    
    
    /**
     * Calculates the probability using the negative binomial distribution formula.
     *
     * @param y Number of trials until the r-th success.
     * @param r Number of successes required.
     * @param p Probability of success on an individual trial.
     * @return The negative binomial probability.
     * @throws IllegalArgumentException if y is less than r or p is not between 0 and 1.
     */
    public double negativeBinomial(int y, int r, double p) 
    {
    	if(y < r || p < 0 || p > 1) 
    	{
            throw new IllegalArgumentException("Invalid parameters");
        }
    	double q = 1 - p;
        
        // Calculate the combination
        BigInteger combination = combination(BigInteger.valueOf(y - 1), BigInteger.valueOf(r - 1));
        
        // Calculate the probabilities
        double pPower = Math.pow(p, r);
        double qPower = Math.pow(q, y - r);
        
        double probability = combination.doubleValue() * pPower * qPower;

        return probability;
    }

    
    /**
     * Calculates the expected value (mean) for a negative binomial distribution.
     *
     * @param r Number of successes required.
     * @param p Probability of success on an individual trial.
     * @return The expected value.
     * @throws IllegalArgumentException if r is less than or equal to 0 or p is not between 0 and 1.
     */
    public double expectedNegativeBinomial(int r, double p) 
    {
        if (r <= 0 || p <= 0 || p > 1) 
        {
            throw new IllegalArgumentException("Invalid parameters");
        }
        return r / p;
    }
    
    
    /**
     * Calculates the variance for a negative binomial distribution.
     * 
     * @param r Number of successes required.
     * @param p Probability of success on a single trial.
     * @return The variance.
     * @throws IllegalArgumentException if r is less than or equal to 0 or p is not between 0 and 1.
     */
    public double varianceNegativeBinomial(int r, double p) 
    {
        if (r <= 0 || p <= 0 || p > 1) 
        {
            throw new IllegalArgumentException("Invalid parameters");
        }
        return r * (1 - p) / (p * p);
    }
    
    
    /**
     * Calculates the probability using the Poisson distribution formula.
     *
     * @param y Number of successes in a fixed interval.
     * @param lambda The average rate of occurrence.
     * @return The Poisson probability.
     * @throws IllegalArgumentException if lambda or y is negative.
     */
    public double poissonDistribution(int y, double lambda) 
    {
    	if(lambda < 0 || y < 0) 
    	{
            throw new IllegalArgumentException("Both y and lambda should be non-negative");
        }
        // e is the base of the natural logarithm
        double ePower = Math.exp(-1 * lambda);
        double lambdaPower = Math.pow(lambda, y);
        
        // Calculating k factorial
        BigInteger kFactorial = factorial(BigInteger.valueOf(y));

        double probability = (ePower * lambdaPower) / kFactorial.doubleValue();

        return probability;
    }
    
    
    /**
     * Calculates the expected value (mean) and variance for a Poisson distribution.
     *
     * @param lambda The average rate of occurrence.
     * @return The expected and variance value.
     * @throws IllegalArgumentException if lambda is less than or equal to 0.
     */
    public double poissonEpectedAndVariance(double lambda) 
    {
        if (lambda <= 0)
        {
            throw new IllegalArgumentException("Invalid parameter for Poisson distribution");
        }
        return lambda;
    }
    
    
    /**
     * Calculates the probability using Chebyshev's Theorem.
     *
     * @param k Number of standard deviations from the mean.
     * @return The probability that a random variable is within k standard deviations of its mean.
     * @throws IllegalArgumentException if k is less than or equal to 1.
     */
    public double chebyshevsTheorem(double k) 
    {
        if (k <= 1) 
        {
            throw new IllegalArgumentException("k must be greater than 1 for Chebyshev's Theorem.");
        }
        return 1.0 - (1.0 / (k * k));
    }


}