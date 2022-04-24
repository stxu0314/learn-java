import java.util.Arrays;

/**
 * @Author STXU
 * @Date 2022/4/16 8:33
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123321));
        test(new char[]{
                'h', 'e', 'l', 'l', 'o'
        });
    }

    public static boolean isPalindrome(int x) {

        StringBuffer str = new StringBuffer(x);
        StringBuffer str1 = str.reverse();
        if (str1.equals(str))
            return true;
        else {

            return false;
        }

    }

    public static void test(char[] arr) {
        String s = new String(arr);
        StringBuffer str = new StringBuffer(s);
        String str2 = String.valueOf(str.reverse());
        char[] chars = str2.toCharArray();
        System.out.println(Arrays.toString(chars));

    }

    public void test() {
        /*
        GitHub Copilot is an AI pair programmer which suggests line completions and entire function bodies as you type.
         GitHub Copilot is powered by the OpenAI Codex AI system, trained on public internet text and billions of lines of code.
         */


    }


}
