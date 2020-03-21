package test.semaphore.ordering3;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) throws InterruptedException {
	    BankAccount b = new BankAccount();
	    Parent p = new Parent(b);
	    Child c = new Child(b);

	    p.start();
	    c.start();
	    p.join(); // p의 작업이 끝날 때까지 기다림
	    c.join(); // c의 작업이 끝날 때까지 기다림

	    System.out.println("balance = " + b.getBalance());
    }
}

class Parent extends Thread {
	BankAccount b;
	Parent(BankAccount b) {
		this.b = b;
	}
	public void run() {
		for (int i=0; i<1000; i++){
			b.deposit(1000);			
		}
	}
}

class Child extends Thread {
	BankAccount b;
	Child(BankAccount b) {
		this.b = b;
	}
	public void run() {
		for (int i=0; i<1000; i++){
			b.withdraw(1000);			
		}
	}
}


class BankAccount {
	int balance;
	Semaphore sem;
	Semaphore dsem;
	Semaphore wsem;
	BankAccount() {
		// critical section에 하나만 들어가기 위한 목적
		sem = new Semaphore(1);
		dsem = new Semaphore(0);
		wsem = new Semaphore(0);
	}
	
	void deposit(int n) {
		try{
			sem.acquire();
		} catch (InterruptedException e) {}
		// critical section
		int temp = balance + n;
		System.out.print("+");
		balance = temp;
//
		sem.release();
		wsem.release();
		try {
			// 입금을 한번 한 뒤, 다시 한 번 하면 교대가 되지 않으므로 acquire를 통해 제약을 건다.
			dsem.acquire();
		} catch (InterruptedException e) {}
	}
	
	void withdraw(int n){
		try{
			// 혹시라도 출금이 먼저 되지 않도록 먼저 acquire를 한다.
			wsem.acquire();
			sem.acquire();
		} catch (InterruptedException e) {}
		// critical section
		int temp = balance - n;
		System.out.print("-");
		balance = temp;
//
		sem.release();
		// 입금에 대한 제약을 푼다.
		dsem.release();
	}
	int getBalance() {
		return balance;
	}
}