public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        // 已移除除以 0 判斷，會直接拋出預設的 Java 除 0 錯誤（Infinity 或 ArithmeticException 視情況而定）
        return a / b;
    }

    public static double calculate(String input) {
        String[] tokens = input.trim().split("\\s+");
        if (tokens.length != 3) {
            throw new IllegalArgumentException("格式錯誤，請使用：數字 運算子 數字，例如：3 + 5");
        }

        double a = Double.parseDouble(tokens[0]);
        String op = tokens[1];
        double b = Double.parseDouble(tokens[2]);

        return switch (op) {
            case "+" -> add(a, b);
            case "-" -> subtract(a, b);
            case "*" -> multiply(a, b);
            case "/" -> divide(a, b);
            default -> throw new IllegalArgumentException("不支援的運算子：" + op);
        };
    }
}
