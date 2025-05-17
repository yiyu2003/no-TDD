package nottd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SortUtilTest {

    @Test
    void testSwap() {
        int[] arr1 = {1, 2, 3};
        SortUtil.swap(arr1, 0, 2);
        assertArrayEquals(new int[]{3, 2, 1}, arr1);

        int[] arr2 = {10, 20};
        SortUtil.swap(arr2, 0, 1);
        assertArrayEquals(new int[]{20, 10}, arr2);

        int[] arr3 = {5};
        SortUtil.swap(arr3, 0, 0); // 自己跟自己 swap
        assertArrayEquals(new int[]{5}, arr3);

        int[] arr4 = {9, 8, 7, 6};
        SortUtil.swap(arr4, 1, 2);
        assertArrayEquals(new int[]{9, 7, 8, 6}, arr4);
    }
    @Test
    void testSelectionSort() {
        int[] arr1 = {64, 25, 12, 22, 11};
        SortUtil.selectionSort(arr1);
        assertArrayEquals(new int[]{11, 12, 22, 25, 64}, arr1);

        int[] arr2 = {5, 1, 4, 2, 8};
        SortUtil.selectionSort(arr2);
        assertArrayEquals(new int[]{1, 2, 4, 5, 8}, arr2);

        int[] arr3 = {1, 2, 3, 4, 5};  // 已排序
        SortUtil.selectionSort(arr3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr3);

        int[] arr4 = {9, 7, 5, 3, 1};  // 完全逆序
        SortUtil.selectionSort(arr4);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr4);

        int[] arr5 = {3, 3, 3};  // 所有元素相同
        SortUtil.selectionSort(arr5);
        assertArrayEquals(new int[]{3, 3, 3}, arr5);

        int[] arr6 = {2};  // 單一元素
        SortUtil.selectionSort(arr6);
        assertArrayEquals(new int[]{2}, arr6);

        int[] arr7 = {};  // 空陣列
        SortUtil.selectionSort(arr7);
        assertArrayEquals(new int[]{}, arr7);

        int[] arr8 = {-1, -3, 4, 2, 0};  // 有負數
        SortUtil.selectionSort(arr8);
        assertArrayEquals(new int[]{-3, -1, 0, 2, 4}, arr8);

        int[] arr9 = {3, 1, 2, 3, 1};  // 含重複值
        SortUtil.selectionSort(arr9);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arr9);
    }


}