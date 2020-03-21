package test.semaphore.ordering2;

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
	Semaphore sem2;
	BankAccount() {
		// critical section에 하나만 들어가기 위한 목적
		sem = new Semaphore(1);
		// ordering(출금을 입금보다 항상 먼저 하기 위한) 목적
		sem2 = new Semaphore(0);
	}
	
	void deposit(int n) {
		try{
			sem2.acquire();
			sem.acquire();
		} catch (InterruptedException e) {}
		// critical section
		int temp = balance + n;
		System.out.print("+");
		balance = temp;
//
		sem.release();
	}
	
	void withdraw(int n){
		try{
			sem.acquire();
		} catch (InterruptedException e) {}
		// critical section
		int temp = balance - n;
		System.out.print("-");
		balance = temp;
//
		sem.release();
		sem2.release();
	}
	int getBalance() {
		return balance;
	}
}