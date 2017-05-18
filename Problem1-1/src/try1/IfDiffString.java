package try1;

import java.lang.*;
import java.io.*;
/**
 * Created by CHILI_USER on 2017/5/17.
 */
//1.1 确定一个字符串的所有字符是否全都不同，ASCII码

//最普通解法, 用一个数组存所有可能出现的位是否出现过
public class IfDiffString {
    public boolean ifDiff(String s){
        if (s.length()>256) return false;
        boolean [] caCount = new boolean[256];
        for (int i=0;i<s.length();i++){
            int ca = s.charAt(i);
            if (caCount[ca] == true){
                return false;
            }
            caCount[ca] = true;
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
