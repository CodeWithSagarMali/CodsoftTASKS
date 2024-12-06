# Auto detect text files and perform LF normalization
* text=auto
import java.util.Scanner;

public class SimpleCurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get the base and target currencies from the user
        System.out.print("Enter the base currency (e.g., USD, EUR, INR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter the target currency (e.g., USD, EUR, INR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Step 2: Get the amount to convert
        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        // Step 3: Use predefined exchange rates for demonstration
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

        // Step 4: Perform the conversion
        if (exchangeRate != -1) {
            double convertedAmount = amount * exchangeRate;
            System.out.println(amount + " " + baseCurrency + " = " + String.format("%.2f", convertedAmount) + " " + targetCurrency);
        } else {
            System.out.println("Conversion rate not available for the selected currencies.");
        }

        scanner.close();
    }

    // Method to get exchange rates (predefined for simplicity)
    public static double getExchangeRate(String base, String target) {
        if (base.equals("USD") && target.equals("INR")) return 83.25;
        if (base.equals("INR") && target.equals("USD")) return 0.012;
        if (base.equals("USD") && target.equals("EUR")) return 0.92;
        if (base.equals("EUR") && target.equals("USD")) return 1.08;
        if (base.equals("EUR") && target.equals("INR")) return 90.15;
        if (base.equals("INR") && target.equals("EUR")) return 0.011;
        return -1; // Return -1 if exchange rate is not available
    }
}