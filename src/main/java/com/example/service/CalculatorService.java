package com.example.service;

public class CalculatorService {


    public int addOrSubtract(int a, int b) {
        int result =  a+b;
        logResult(result);
        return result;
    }

    public int calculate(int a, int b, String operation) {
        int result;
        switch (operation) {
            case "add":
                //[icon] This code is dead as add API calls addOrSubtract function.
                result = a + b;
                break;
            case "subtract":
                //[icon] This code is dead as subtract API calls addOrSubtract function.
                result = a - b;
                break;
            case "multiply":
                result = a * b;
                break;
            case "divide":
                if (b == 0) {
                    throw new IllegalArgumentException("Division by zero");
                }
                result = a / b;
                break;
            case "modulus":
                result = a % b;
                break;
            default:
                throw new UnsupportedOperationException("Operation not supported");
        }

        logResult(result);
        return result;
    }

    //[icon] 20qps - 2% overall.
    public double calculateUnary(double value, String operation) {
        double result;
        switch (operation) {
            case "sine":
                //[icon] 10qps - (1% overall), (50% method level)
                result = Math.sin(value);
                break;
            case "cosine":
                //[icon] 9qps - (1% overall), (45% method level)
                result = Math.cos(value);
                break;
            case "tangent":
                //[icon] 1qps - (0.1% overall), (5% method level)
                result = Math.tan(value);
                break;
            default:
                //[icon] 0qps- Dead code
                throw new UnsupportedOperationException("Operation not supported");
        }
        //[icon] 20qps - (2% overall), (100% method level)
        logResult(result);
        return result;
    }

    //[icon] 120qps - 98% overall.
        //addOrSubtract - 1200qps - 60%
        //calculate - 390 qps - 38%
        //calculateUnary - 20qpx - 2%
    private void logResult(Object result) {
        System.out.println("Result: " + result);
    }
}