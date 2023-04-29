package Queue;

import java.util.Scanner;

public class ArrayQueue {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Queue queue = new Queue(3);
        Boolean loop=true;
        int numb;
        char choose=' ';
        while (loop){
            System.out.println("测试版本信息");
            System.out.println("a(add)加入数据");
            System.out.println("g(get)弹出数据数据");
            System.out.println("s(showAll)显示所有数据");
            System.out.println("n(next)下一个数据");
            System.out.println("e(exit)退出");
            System.out.print("请输入选项：");
            choose=scanner.next().charAt(0);
            switch (choose){
                case 'a':
                    System.out.print("请输入你要加入的数据：");
                    numb=scanner.nextInt();
                    queue.addQueue(numb);
                    break;
                case 'g':
                    queue.getQueue();
                    break;
                case 's':
                    queue.showAll();
                    break;
                case 'n':
                    queue.showNext();
                    break;
                case 'e':
                    loop=false;
                    break;
            }
        }
    }
}
//简单模拟一个队列(有缺陷)
class Queue{
    public int maxSize;//数组的容量
    public int front;//队列的头
    public int rear;//队列的尾
    public int [] arry;//具体实现队列的数组

    //构造器:初始化基本数据
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;//指向当前数据的前一个位置
        this.rear = -1;//指向当前数据的前一个位置
        this.arry = new int[maxSize];
    }

    //判断队列是否满了
    public boolean isFull(){
        return rear==maxSize-1;//这个条件只适用于不能动态扩容的时候
    }
    //判断队是否为空
    public boolean isEmpty(){
        return front == rear;//这个条件只适用于不能动态扩容的时候
    }

    //添加数据
    public void addQueue(int data){
        //1.首先判断队列是不是满的
        if(!isFull()){//如果没有满
            rear++;
            arry[rear]=data;
        }else {
            System.out.println("数组已经满了，不允许加入");
        }
    }
    //取出一个数据
    public void getQueue(){
        //1.首先判断队列是不是空的
        if(!isEmpty()){//如果不是空的
            front++;
            System.out.println("取出的数据是："+arry[front]);
            arry[front]=0;//把位置清空
        }else {
            System.out.println("数组为空，没有数据可以取出");
        }
    }
    //显示所有数据
    public void showAll(){
       for(int i=0;i<arry.length;i++){
           System.out.println("array["+i+"]="+arry[i]);
       }
    }

    //显示下一个节点的数据
    public void showNext(){
        if (isEmpty()){
            System.out.println("当前队列的数据为空，没有下一个数据");
        }{
            System.out.println("下一个数据的值为："+arry[front+1]);
        }
    }
}
