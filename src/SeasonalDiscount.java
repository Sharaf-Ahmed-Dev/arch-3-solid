public class SeasonalDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double rawTotal) { 
        return rawTotal * 0.15; 
    }

    @Override
    public String getStrategyName() { 
        return "Seasonal Book Festival Offer - 15% OFF"; 
    }
}