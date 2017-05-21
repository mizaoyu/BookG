/**
 * Created by Misky on 5/20/2017.
 */
public class ReplaceSpace {
    //用函数
    public String replaceSpace1(String s){
        String result = s.replace(" ","%20");
        return result;
    }

    // 自己写
    public String replaceSpace2(String s){
        char [] sch = s.toCharArray();
        int spaceCount = 0;
        for (int i=0;i<sch.length;i++){
            if (sch[i] == ' '){
                spaceCount ++;
            }
        }
        char [] rsch = new char[sch.length + 2*spaceCount];
        int end = sch.length + 2*spaceCount - 1;
        for (int i = sch.length-1;i>=0;i--){
            if (sch[i] != ' '){
                rsch[end] = sch[i];
                end --;
            }else{
                rsch[end] = '0';
                rsch[end-1] = '2';
                rsch[end-2] = '%';
                end -= 3;
            }
        }
        String result = String.valueOf(rsch);
        return result;
    }

    public static void main(String [] args){
        ReplaceSpace rs = new ReplaceSpace();
        System.out.println(rs.replaceSpace1("1 2   3 4 "));
        System.out.println(rs.replaceSpace2("1 2   3 4 "));
    }
}
