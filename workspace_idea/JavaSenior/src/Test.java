import java.util.Arrays;

/**
 * @author YangFeng
 * @create 2022-03-18 15:43
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2};
        for(int i=0; i<arr.length; i++){
            System.out.println(i);
            int L=i;
            System.out.println(arr[L++]==arr[L]);
        }
    }
}

class A{
    private int[] arr;
    public A(int[] arr){
        this.arr = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            this.arr[i] = arr[i];
        }
    }

    public void getArr(){
        System.out.println(Arrays.toString(arr));
    }
}
