public class MemberDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double rawTotal) { 
        return rawTotal * 0.10; 
    }

    @Override
    public String getStrategyName() { 
        return "Premium Member Savings - 10% OFF"; 
    }
}