public class SimpleCalculator implements Calculator {
    @Override
    public int add(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Inputs must be non-negative integers.");
        }
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Inputs must be non-negative integers.");
        }
        if (a < b) {
            throw new IllegalArgumentException("First number must be greater than or equal to the second number.");
        }
        return a - b;
    }
}


/*public class SimpleCalculator implements Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}
*/
