package examset;

class Task implements Runnable {
    private final Object lock1;
    private final Object lock2;

    Task(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    public void run() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " locked " + lock1);

            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " locked " + lock2);
            }
        }
    }
}

public class DeadlockExample {
	
	 public static void main(String[] args) {
	        Object lockA = new Object();
	        Object lockB = new Object();

	        Thread t1 = new Thread(new Task(lockA, lockB), "Thread-1");
	        Thread t2 = new Thread(new Task(lockB, lockA), "Thread-2");

	        t1.start();
	        t2.start();
	    }

}
