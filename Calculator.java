// Calculator.java
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");

        System.out.println("歡迎使用進階計算機！");
        System.out.println("支援運算： +, -, *, /, 括號, 次方(^), 根號(sqrt 或 √)，負數");
        System.out.println("輸入 exit 可結束程式。");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("程式結束。");
                break;
            }

            if (!input.matches("[-+*/().\\d\\s^√a-zA-Z]+")) {
                System.out.println("錯誤：輸入包含非法字元！");
                continue;
            }

            try {
                Object result = evaluate(input);
                System.out.println("結果： " + result);
            } catch (ArithmeticException ae) {
                System.out.println("錯誤：" + ae.getMessage());
            } catch (ScriptException e) {
                System.out.println("錯誤：無法計算此表達式！");
            }
        }

        scanner.close();
    }

    public static String preprocess(String input) {
        input = input.replaceAll("\\s+", "");
        input = input.replaceAll("(\\d+(?:\\.\\d+)?|\\))\\^(-?\\d+(?:\\.\\d+)?|\\()", "Math.pow($1,$2)");
        input = input.replaceAll("sqrt\\(", "Math.sqrt(");
        input = input.replaceAll("√(-?\\d+(?:\\.\\d+)?)", "Math.sqrt($1)");
        return input;
    }

    public static Object evaluate(String input) throws ScriptException {
        String processed = preprocess(input);
        if (processed.matches(".*/\\s*0+(\\.0*)?(\\D|$).*")) {
            throw new ArithmeticException("除以 0");
        }
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
        return engine.eval(processed);
    }
}
