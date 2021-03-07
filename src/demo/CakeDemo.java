package demo;

/**
 * @Author Xiaoma
 * @Date 2021/3/7 0007 16:18
 * @Email 1468835254@qq.com
 */
public class CakeDemo {

    static volatile int num = 0;

    public static Object object = new Object();

    public static void main(String[] args) {
        new Thread(new Product()).start();
        new Thread(new Consumption()).start();
    }

    static class Product implements Runnable {

        public final int MAX = 3;

        @Override
        public void run() {
            try {
                while (true) {
                    if (num > MAX) {
                        wait();
                    } else {
                        num++;
                        System.out.println("Product" + num);
                        notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumption implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    if (num == 0) {
                        wait();
                    } else {
                        num--;
                        System.out.println("Consumption" + num);
                        notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
