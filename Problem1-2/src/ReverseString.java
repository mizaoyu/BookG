import java.lang.*;

/**
 * Created by CHILI_USER on 2017/5/18.
 */
public class ReverseString {
    public String reverse(String str){
        char [] charList = str.toCharArray();
        int start = 0;
        int end = charList.length - 1;
        while(end >= start){
            char tmp = charList[start];
            charList[start] = charList[end];
            charList[end] = tmp;
            end--;
            start++;
        }
        String result = String.valueOf(charList);
        return result;
    }

    public static void main(String [] args){
        String s1 = "123456789";
        String s2 = "1234";

        ReverseString rs = new ReverseString();
        System.out.println(rs.reverse(s1));
        System.out.println(rs.reverse(s2));
    }
}
