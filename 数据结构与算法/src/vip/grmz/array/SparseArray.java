package vip.grmz.array;

/**
 * 二维数组转稀疏数组
 * @Author STXU
 * @Date 2022/4/19 8:48
 * @Version 1.0
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;
        System.out.println("原始的二维数组:");
        for (int[] num:
             arr) {
            for (int data:
                 num) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //将二维数组转为稀疏数组
        //1. 遍历二维数组,得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }
       //2. 创建一个对应的稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        //3. 给稀疏数组赋值
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr.length;
        sparseArr[0][2] = sum;

        //遍历二维数组,将非0数据存放到sparseArr中
        int count = 0; // 用于记录是第几个非0数据
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println();
        System.out.println("稀疏数组:");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }

        //将稀疏数组恢复成二维数组
        //1.先读取稀疏数组的第一行,根据第一行的数据,创建原始的二维数组
        int[][] arr1 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2. 再读取稀疏数组的后几行,并赋值给原始的二维数组即可
        for (int i = 1; i < sparseArr.length; i++) {
            arr1[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println();
        System.out.println("恢复后的二维数组:");
        for (int[] num:
                arr1) {
            for (int data:
                    num) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }
}
