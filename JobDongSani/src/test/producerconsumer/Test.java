package test.producerconsumer;

import java.util.concurrent.Semaphore;

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
	int size; // 버퍼 갯수(용량), 크기
	int count; // 버퍼안의 생산되어 저장되어있는 갯수
	int in; // 처음 in 인덱스 값부터 생산자의 데이터를 넣겠다.
	int out; // 빼내는 위치
	
	Semaphore mutex; // mutual exclusion을 위한 세마포
	Semaphore empty;
	Semaphore full;

	Buffer(int size) {
		buf = new int[size];
		this.size = size;
		count = in = out = 0;
		mutex = new Semaphore(1);
		empty = new Semaphore(size);
		full = new Semaphore(0);
	}

	void insert(int item) { // 생산자가 버퍼에 데이터를 집어넣는 함수

		try {
			empty.acquire();
			// check if buf is full
//			while (count == size); // 같다면 무한루프를 돌며 여기서 멈춰있다.
			mutex.acquire();
		} catch (InterruptedException e) {
		}
		// critical section
		// buf is not full
		buf[in] = item; // 소비자가 하나를 가져가 1의 공간이 생긴다면 item을 in에 넣고
		in = (in + 1) % size; // 나머지가 0
		count++;
		mutex.release();
		full.release();
	}

	int remove() {

		try {
			full.acquire();
			// check if buf is empty
//			while (count == 0); // 버퍼가 비어져있으면 무한루프 돌면서 소비자는 기다리고 있음
			mutex.acquire();
			// critical section
			// buf is not empty
			int item = buf[out]; // buf에 out한 값을 item에 넣는다.
			out = (out + 1) % size; // 나머지가 0
			count--;
			mutex.release();
			empty.release();
			return item;
		} catch (InterruptedException e) {
			// 예외인 경우에 대한 처리
			return -1;
		}
	}
}