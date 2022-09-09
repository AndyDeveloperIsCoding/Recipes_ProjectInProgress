import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

/*
class Main {
    public static void main(String[] args) {

     //   calculation(10);

    }
}

 */



class Operator {

    public static int a = 10;
    public static int b = 20;
    public static int c = 30;

    public static DoubleUnaryOperator unaryOperator = x -> 1.0 * (a * x * x + b * x + c);

    /*

    public static double result = -1;

    Function<Integer, Double> complexFormula = x -> {
        result = 1.0 * (a * x * x + b * x + c);
        return result;
    };

    private double calculation( Function<Integer, Double> complexFormula, int x) {
        return result;
        //
    }

     */
}