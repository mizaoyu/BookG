package try2;

import java.lang.*;
import java.io.*;
/**
 * Created by CHILI_USER on 2017/5/17.
 */
//1.1 确定一个字符串的所有字符是否全都不同，ASCII码

//用二进制位移
public class IfDiffString {
    public boolean ifDiff(String s){
        if (s.length()>256) return false;
        int bc = 0;
        for (int i=0;i<s.length();i++){
            int ca = s.charAt(i);
            if ((bc & (1<<ca)) > 0){
                return false;
            }
            bc |= (1 << ca);//要加括号
        }
        return true;
    }

    public static void main(String [] args){
        String s = "1234561";
        String s1 = "sfsfasdag";
        IfDiffString ds = new IfDiffString();
        System.out.println(ds.ifDiff(s) ? "true" : false);
        System.out.println(ds.ifDiff(s1) ? "true" : false);
    }
}
