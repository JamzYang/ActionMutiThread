package easy;

/**
 * @author yang
 * Date 2020/4/14 10:25
 */
public class _14LongestCommonPrefix {
    public static void main(String[] args) {
//        String[] strs = {"flower", "fl","flow"};
//        String[] strs = {"aa", "a"};
        String[] strs = {"aba","c","b","a","ab"};
        String s = solution1(strs);
        System.out.println(s);
    }
    //TODO 没通过部分测试
    public static String solution1(String[] strs) {
        if(strs.length == 0) return "";
        String e1 = strs[0];
        String result=e1;
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < e1.length(); j++) {
                if((strs[i].length() > j && strs[i].charAt(j) != e1.charAt(j))
                    || strs[i].length() <=j ){
                    result = e1.substring(0,j);
                    break;
                }
            }
        }
        return result;
    }
}
