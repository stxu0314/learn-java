package vip.grmz.queue;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

/**
 * @Author STXU
 * @Date 2022/4/19 21:17
 * @Version 1.0
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        UUID id = UUID.randomUUID();
        String s = id.toString().replaceAll("-", "");
        System.out.println(s);
        System.out.println(id);
            //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头数据");
            key = sc.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int val = sc.nextInt();
                    queue.addQueue(val);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    sc.close();
                    loop = false;
                    break;
                default :break;
            }
        }
        System.out.println("程序退出!!!");
    }
}

/**
 * 使用数组模拟队列, 编写一个ArrayQueue类
 * @Author STXU
 * @Description //TODO
 * @Date 21:18 2022/4/19
 */
class ArrayQueue{
    /**
     * 表示数组最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 该数据用于存放数据,模拟队列
     */
    private int[] arr;

    //创建队列的构造器
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部,分析出front是指向队列头的前一个位置.
        rear = -1; //指向队列尾,指向队列尾的数据(即就是队列最后一个数据)
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否满
        if (isFull()){
            System.out.println("队列满,禁止加入");
            return;
        }
        rear++;//让rear后移
        arr[rear] = n;
    }

    //获取队列的数据,出队列
    public int getQueue(){
        //判断队列是否空
        if (isEmpty()){
            //通过抛出异常
            throw new NoSuchElementException("队列空,不能取数据");
        }
        front++; //让front后移
        return arr[front];

    }

    //显示队列的所有数据
    public void showQueue(){
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空,没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示对列的头数据,注意不是取出数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new NoSuchElementException("队列为空,没有数据");
        }
        return arr[front + 1];
    }
}