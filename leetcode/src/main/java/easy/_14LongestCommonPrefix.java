package easy;

/**
 * @author yang
 * Date 2020/4/14 10:25
 */
public class _14LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flo", "flow","flow"};
        String s = solution1(strs);
        System.out.println(s);
    }

    public static String solution1(String[] strs) {
        String e1 = strs[0];
        int maxIndex = -1;
        for (int j = 1; j <= e1.length(); j++) {
            String prefix = e1.substring(0, j);
            boolean hasFlag = true;
            for (int i = 1; i < strs.length; i++) {
                if(strs[i].length() < j || !prefix.equals(strs[i].substring(0,j))){
                    hasFlag = false;
                    break;
                }
            }
            if(!hasFlag){
                maxIndex = j -1;
                break;
            }
        }

        if(maxIndex < 0){
            return "";
        }else {
            return e1.substring(0, maxIndex);
        }
    }
}
