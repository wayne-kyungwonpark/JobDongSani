package test.monitors.bankaccount.ordering;

public class Test {
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
		for (int i = 0; i < 1000; i++) {
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
		for (int i = 0; i < 1000; i++) {
			b.withdraw(1000);
		}
	}
}

class BankAccount {
	int balance;

	BankAccount() {
	}

	synchronized void deposit(int n) {
		// void deposit(int n) {
		// critical section
		int temp = balance + n;
		System.out.print("+");
		balance = temp;
		notify();
	}

	synchronized void withdraw(int n) {
		// void withdraw(int n){
		// critical section
		while(balance <= 0){
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		int temp = balance - n;
		System.out.print("-");
		balance = temp;
	}

	int getBalance() {
		return balance;
	}
}