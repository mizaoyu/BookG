import java.lang.*;
import java.util.Arrays;

/**
 * Created by CHILI_USER on 2017/5/18.
 */
public class Reconstruct {
    //假设空格考虑进去，不区分大小写
    public boolean reconstruct1(String s1,String s2){
       //数是否每个字符出现次数一样
       if (s1.length() != s2.length()){
           return false;
       }
       int [] s1count = new int[256];
       for (int i=0; i<s1.length();i++){
           int charInt = s1.charAt(i);
           s1count[charInt]++;
       }
       int [] s2count = new int[256];
       for (int i=0; i<s2.length();i++){
           int charInt = s2.charAt(i);
           s2count[charInt]++;
       }
       for (int i=0;i<256;i++){
           if (s1count[i] != s2count[i]){
               return false;
           }
       }
       return true;
   }

    public boolean reconstruct2(String s1,String s2){
        //数是否每个字符出现次数一样,优化版，一个加，一个减，且用charArray
        if (s1.length() != s2.length()){
            return false;
        }
        int [] scount = new int[256];
        for (char c:s1.toCharArray()){
            scount[c]++;
        }
        for (char c:s2.toCharArray()){
            scount[c]--;
            if (scount[c]<0){
                return false;
            }
        }
        return true;
    }

    public boolean reconstruct3(String s1,String s2){
        //将字符串排序
        if (s1.length() != s2.length()){
            return false;
        }
        char [] s1c = s1.toCharArray();
        Arrays.sort(s1c);
        String s1s = String.valueOf(s1c);
        char [] s2c = s2.toCharArray();
        Arrays.sort(s2c);
        String s2s = String.valueOf(s2c);
        return s1s.equals(s2s);
    }

    //假设空格不考虑，区分大小写
    public boolean reconstruct4(String s1,String s2){
        //先去除空格
        //自己写
        StringBuffer ss = new StringBuffer();
        for (int i=0;i<s1.length();i++){
            if (s1.charAt(i) != ' '){
                ss.append(s1.charAt(i));
            }
        }
        String s1s = ss.toString();
        //用函数
        String s2s = s2.replaceAll(" ", "");

        //再统一成小写
        //自己写
        StringBuffer ss1 = new StringBuffer();
        for (int i=0;i<s1s.length();i++){
            if (s1s.charAt(i) <= 'Z' && s1s.charAt(i) >= 'A'){
                char lc = (char)('a'+ (s1s.charAt(i)-'A'));
                ss1.append(lc);
            }else{
                ss1.append(s1s.charAt(i));
            }
        }
        String s1ss = ss1.toString();
        System.out.println(s1ss);
        //用函数
        String s2ss = s2s.toLowerCase();


        return reconstruct3(s1ss,s2ss);
    }

    public static void main(String [] args){
        Reconstruct rc = new Reconstruct();
        System.out.println(rc.reconstruct1("1234","2431"));
        System.out.println(rc.reconstruct1("afsfsdf","frggd1s"));
        System.out.println(rc.reconstruct2("1234","2431"));
        System.out.println(rc.reconstruct2("afsfsdf","frggd1s"));
        System.out.println(rc.reconstruct3("1234","2431"));
        System.out.println(rc.reconstruct3("afsfsdf","frggd1s"));
        System.out.println(rc.reconstruct4("1  2 3 4      ","2431"));
        System.out.println(rc.reconstruct4("A S13Dsasf,.F ","dFsA"));
    }

}
