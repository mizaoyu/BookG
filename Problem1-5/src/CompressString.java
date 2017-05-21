/**
 * Created by Misky on 5/21/2017.
 */
public class CompressString {
    public String compress1(String str){
        //用StringBuffer
        StringBuffer rsb = new StringBuffer();
        char last = str.charAt(0);
        rsb.append(last);
        int count = 1;
        for (int i=1;i<str.length();i++){
            if (str.charAt(i) == last){
                count++;
            }else{
                rsb.append(count);
                count = 1;
                last = str.charAt(i);
                rsb.append(last);
            }
        }
        rsb.append(count);
        if (rsb.length() < str.length()){
            return rsb.toString();
        }else{
            return str;
        }
    }

    public String compress2(String str){
        //用Array
        //先数结果会有多长
        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for (int i=1;i<str.length();i++){
            if (str.charAt(i) == last){
                count++;
            }else{
                size += 1 + String.valueOf(count).length();
                count = 1;
                last = str.charAt(i);
            }
        }
        size += 1 + String.valueOf(count).length();
        //再构建答案
        char [] rch = new char[size];
        int index = 0;
        last = str.charAt(0);
        count = 1;
        for (int i=1;i<str.length();i++){
            if (str.charAt(i) == last){
                count++;
            }else{
                rch[index] = last;
                index ++;
                String cstr = String.valueOf(count);
                for (int j = 0;j<cstr.length();j++){
                    rch[index] = cstr.charAt(j);
                    index++;
                }
                count = 1;
                last = str.charAt(i);
            }
        }
        rch[index] = last;
        index ++;
        String cstr = String.valueOf(count);
        for (int j = 0;j<cstr.length();j++){
            rch[index] = cstr.charAt(j);
            index++;
        }

        if (rch.length < str.length()){
            return String.valueOf(rch);
        }else{
            return str;
        }
    }

    public static void main(String [] args){
        CompressString cs = new CompressString();
        System.out.println(cs.compress1("aabcccccaaa"));
        System.out.println(cs.compress1("abca"));
        System.out.println(cs.compress2("aabcccccaaa"));
        System.out.println(cs.compress2("abca"));
    }
}
