package test.monitors.bankaccount.ordering3;

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
	boolean pTurn = true; // 처음에 Parent 동작 후 P->C->P->C ...로 동작하길 바라기 때문

	BankAccount() {
	}

	synchronized void deposit(int n) {
		// void deposit(int n) {
		// critical section
		int temp = balance + n;
		System.out.print("+");
		balance = temp;
		notify(); // Child를 깨워주기 위한 목적
		pTurn = false;
		try {
			wait(); // Parent가 한 번 돌았을 시 두 번 연속으로 돌면 안되므로 자신을 block
		} catch (InterruptedException e) {
		}
	}

	synchronized void withdraw(int n) {
		// void withdraw(int n){
		// critical section
		while (pTurn) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		int temp = balance - n;
		System.out.print("-");
		balance = temp;
		pTurn = true;
		notify(); // Parent를 깨워주기 위한 목적
	}

	int getBalance() {
		return balance;
	}
}