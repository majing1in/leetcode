package demo;

/**
 * 生产消费者模型一
 */
public class ConsumerModel1 {

    private static int sum = 3;

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
                        if (sum == 3) {
                            lock.notify();
                            lock.wait();
                        } else {
                            sum++;
                            System.out.println("Consumer 正在生产 sum = " + sum);
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
                        if (sum == 1) {
                            lock.notify();
                            lock.wait();
                        } else {
                            sum--;
                            System.out.println("Producer 正在消费 sum = " + sum);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
