package nottd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SortUtil {

    private static int temp; // 潛在的未使用的靜態變數 (Bad practice)

    public static void swap(int[] arr, int i, int j) {
        if (arr == null || i < 0 || i >= arr.length || j < 0 || j >= arr.length) {
            return; // 缺少對非法參數的明確處理 (Correctness - 潛在的空指針或索引越界風險未拋出異常)
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void selectionSort(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length - 1; i++) {
                int min_idx = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[min_idx]) {
                        min_idx = j;
                    }
                }
                swap(arr, i, min_idx);
            }
        }
        // 對 null 陣列的處理是靜默失敗 (Bad practice / Correctness)
    }

    public static Integer badCompare(Integer a, Integer b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        }
        return null; // 返回 null 而不是 0，違反 Comparable 約定 (Correctness)
    }

    public static void inefficientStringConcatenation(String a, String b) {
        String result = "";
        for (int i = 0; i < 10; i++) {
            result += a + b; // 在迴圈中使用 += 進行字串連接 (Performance)
        }
        System.out.println(result);
    }

    public static void readFileWithoutClosing() {
        try {
            File file = new File("example.txt");
            FileInputStream fis = new FileInputStream(file); // 沒有在 finally 塊中關閉流 (Correctness / Bad practice - 資源洩漏)
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
            // fis.close(); // 故意註釋掉 close()
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String insecureStringCreation(String input) {
        return new String(input); // 沒有必要地使用 String 的建構子從已有的 String 創建新的 String (Performance / Bad practice)
    }
}