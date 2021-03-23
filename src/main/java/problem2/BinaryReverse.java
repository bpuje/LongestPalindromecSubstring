package problem2;

import java.util.Arrays;

public class BinaryReverse {
    public static void main(String[] args) {
        String str = "47";
        System.out.println(BinaryReversal(str));
    }

    private static String BinaryReversal(String str) {

        int num = Integer.parseInt(str);
        String s = Integer.toBinaryString(num);
        String[] arr = new String[8];
        Arrays.fill(arr, "0");
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            char ch = ' ';
            ch = s.charAt(i);
            arr[j] = Character.toString(ch);
        }
        String result = "";
        for (String i : arr) {
            result += i;

        }
        int decimal = Integer.parseInt(result, 2);
        return Integer.toString(decimal);
    }


}