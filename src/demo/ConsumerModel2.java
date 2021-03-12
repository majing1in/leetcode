package demo;

/**
 * 生产消费者模型二
 */
public class ConsumerModel2 {

    private static volatile int sum = 3;

    private final static Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (lock) {
                        if (sum < 3) {
                            sum++;
                            System.out.println("Consumer 正在生产 sum = " + sum);
                            Thread.sleep(500);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class Producer implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (lock) {
                        if (sum > 0) {
                            sum--;
                            System.out.println("Producer 正在消费 sum = " + sum);
                            Thread.sleep(500);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
