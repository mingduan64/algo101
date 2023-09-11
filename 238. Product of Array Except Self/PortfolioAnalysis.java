import java.util.ArrayList;
import java.util.List;

class Stock {
    String symbol;
    int shares;
    double purchasePrice;

    public Stock(String symbol, int shares, double purchasePrice) {
        this.symbol = symbol;
        this.shares = shares;
        this.purchasePrice = purchasePrice;
    }
}

public class PortfolioAnalysis {
    public static double getCurrentStockPrice(String symbol) {
        // Implement logic to fetch the current stock price for the given symbol
        // This might involve making an API request to a financial data provider
        // or querying a local database with real-time stock prices.

        // For the sake of this example, we'll use hardcoded prices.
        // In a real application, you would replace this with actual data retrieval.
        if (symbol.equals("AAPL")) {
            return 155.0; // Replace with the actual price
        } else if (symbol.equals("GOOGL")) {
            return 2550.0; // Replace with the actual price
        } else if (symbol.equals("MSFT")) {
            return 205.0; // Replace with the actual price
        } else {
            // Handle the case where the symbol is not found
            // You might return a default value or raise an exception.
            return 0.0; // Placeholder value
        }
    }

    public static double calculatePortfolioReturn(List<Stock> portfolio, String excludeStock) {
        double totalReturn = 0.0;

        for (Stock stock : portfolio) {
            if (!stock.symbol.equals(excludeStock)) {
                // Calculate the return for each stock and add it to the total
                double currentPrice = getCurrentStockPrice(stock.symbol);
                double stockReturn = (currentPrice - stock.purchasePrice) * stock.shares;
                totalReturn += stockReturn;
            }
        }

        return totalReturn;
    }

    public static void main(String[] args) {
        List<Stock> portfolio = new ArrayList<>();
        portfolio.add(new Stock("AAPL", 100, 150.0));
        portfolio.add(new Stock("GOOGL", 50, 2500.0));
        portfolio.add(new Stock("MSFT", 75, 200.0));

        String excludeStock = "AAPL"; // Stock to exclude

        // Calculate portfolio return with and without excluding a stock
        double portfolioReturnWithExclusion = calculatePortfolioReturn(portfolio, excludeStock);
        double portfolioReturnWithoutExclusion = calculatePortfolioReturn(portfolio, "");

        // Calculate risk as the difference in returns
        double risk = portfolioReturnWithoutExclusion - portfolioReturnWithExclusion;

        System.out.println("Portfolio Return without Exclusion: " + portfolioReturnWithoutExclusion);
        System.out.println("Portfolio Return with Exclusion: " + portfolioReturnWithExclusion);
        System.out.println("Risk (Change in Return): " + risk);
    }
}
