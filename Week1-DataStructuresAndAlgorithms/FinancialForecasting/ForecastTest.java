public class ForecastTest {
    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }

        return calculateFutureValue(currentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double presentValue = 10000.0;
        double annualGrowthRate = 0.10;
        int years = 3;

        double futureValue = calculateFutureValue(presentValue, annualGrowthRate, years);

        System.out.println("Recursion");
        System.out.println("Recursion is a method where a function calls itself to solve a smaller part of the problem.");
        System.out.println("It is useful when a problem can be broken into repeated smaller steps.");
        System.out.println();

        System.out.println("Financial Forecast");
        System.out.println("Present Value: " + presentValue);
        System.out.println("Annual Growth Rate: " + (annualGrowthRate * 100) + "%");
        System.out.println("Years: " + years);
        System.out.printf("Predicted Future Value: %.2f%n", futureValue);
        System.out.println();

        System.out.println("Analysis");
        System.out.println("Recursive Time Complexity: O(n)");
        System.out.println("The function makes one recursive call for each year.");
        System.out.println("This solution can be optimized by using a direct formula or memoization");
        System.out.println("to avoid repeated computation in larger recursive problems.");
    }
}
