package hb;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        int s1 = sc.nextInt();
        int[] arr1 = new int[s1];
        for (int i = 0; i < s1; i++) {
            arr1[i] = sc.nextInt();
        }
        int s2 = sc.nextInt();
        int[] arr2 = new int[s2];
        for (int i = 0; i < s2; i++) {
            arr2[i] = sc.nextInt();
        }

//        for (int value : arr2) {
//            int target = binSearch(arr1, value);
//            System.out.println(value + " " + target);
//        }
        int[] res = findArrEle(arr1, arr2);
        for (int x : res) {
            System.out.print(x + " ");
        }
        }
    public static int[] findArrEle(int[] arr1, int[] arr2) {
        int[] eles = new int[arr2.length];
        for (int i = 0; i < arr2.length; i++) {
            int target = binSearch(arr1, arr2[i]);
            if (target == -1) {
                eles[i] = -1;
            } else {
                eles[i] = ++target;
            }
        }
        return eles;
    }

    public static int binSearch(int[] arr, int val) {
        int b = 0;
        int e = arr.length - 1;

        while (b <= e) {
            int m = b + (e - b) / 2;
            if (arr[m] == val) {
                return m;
            }
            if (arr[m] < val) {
                b = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }
}
