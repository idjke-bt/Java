package exer;

/**
 * PPT p28 练习5：常见算法题
 *
 * @author YangFeng
 * @create 2021-01-04 20:44
 */
public class StringExer {

    public static void main(String[] args) {

        StringExer strE =  new StringExer();

        String str1 = "acfacbccacbbbbab";
        String str2 = "abacfacbbavcff";
        System.out.println(strE.maxSameString(str1, str2));

    }

    public String myTrim(String str){
        /*
        模拟一个trim方法，去除字符串两端的空格
     */

        int start = 0;
        int end = str.length();
        for(; start<str.length(); start++){
            if(str.charAt(start) != ' ')
                break;
        }
        for(; end>0; end--){
            if(str.charAt(start) != ' ')
                break;
        }

        return str.substring(start, end);

    }

    public String myReverse(String str, int start, int end){
        /*
            参数：start,end均为索引
            作用：翻转字符串中索引从start到end的部分

            方法：转换成char型数组，然后对数组进行翻转操作
         */
        char[] charArray = str.toCharArray();
        char temp;

        while(start < end){
            temp = charArray[start];
            charArray[start++] = charArray[end];
            charArray[end--] = temp;
        }

        String newStr = new String(charArray);
            return newStr;

    }

    public int myCount(String subStr, String str){
        /*
            返回subStr在str中出现的次数
         */
        int len = str.length();
        int subLen = subStr.length();
        if(len==0 || subLen==0)
            return 0;

        int i = str.indexOf(subStr,0); //看子串第一次出现对应的索引
        int count = 0;
        while(i < len ){
            if(i == -1)
                break;
            count++;
            i = str.indexOf(subStr, i+subLen); //子串出现一次，就将其去掉(移动起始索引即可)
        }

        return count;
    }

    public String maxSameString(String str1, String str2){
        /*
            作用：找出str1和str2的最大相同子串
            做法：不断减少短的那个字符串的长度，直到找到为止(相当于设定了一个滑块，两重循环，外面的循环是滑块的长度）
         */

        int len1 = str1.length();
        int len2 = str2.length();
        String largeStr = (len1 >= len2) ? str1 : str2;//选出较长的字符串
        String smallStr = (len1 < len2) ? str1 : str2;

        int len = (len1 < len2) ? len1 : len2;

        int front =0, rear = 0;
        String sameStr = null;
        while(sameStr == null && len > 0){
            for(front=0; front + len < smallStr.length(); front++){
                rear = front + len;
                if(largeStr.indexOf(smallStr.substring(front, rear)) != -1){
                    sameStr = smallStr.substring(front, rear);
                    break;
                }
            }
            len--;
        }

        return sameStr;
    }


}
