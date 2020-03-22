package test.monitors.producerconsumer;

public class Test {
	public static void main(String[] args) {
		Buffer b = new Buffer(100);
		Producer p = new Producer(b, 10000);
		Consumer c = new Consumer(b, 10000);
		p.start();
		c.start();
		try {
			p.join();
			c.join();
		} catch (InterruptedException e) {
		}
		System.out.println("Number of items in the buf is " + b.count);
	}
}

/****** 생산자 ******/
class Producer extends Thread {
	Buffer b;
	int N;

	Producer(Buffer b, int N) {
		this.b = b;
		this.N = N;
	}

	public void run() {
		for (int i = 0; i < N; i++) {
			b.insert(i);
		}
	}
}

/****** 소비자 ******/
class Consumer extends Thread {
	Buffer b;
	int N;

	Consumer(Buffer b, int N) {
		this.b = b;
		this.N = N;
	}

	public void run() {
		int item;
		for (int i = 0; i < N; i++) {
			item = b.remove();
		}
	}
}

class Buffer {
	int[] buf;
	int size, count, in, out;

	Buffer(int size) {
		buf = new int[size];
		this.size = size;
		count = in = out = 0;
	}

	synchronized void insert(int item) {
		while (count == size){}
		try {
			wait();
		} catch (InterruptedException e) {
		}
		buf[in] = item;
		in = (in + 1) % size;
		count++; // increase item count
		notify();
	}

	synchronized int remove() {
		while (count == 0){}
		try {
			wait();
		} catch (InterruptedException e) {
		}
		int item = buf[out];
		out = (out + 1) % size;
		count--;
		notify();
		return item;
	}

}