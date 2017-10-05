import java.util.concurrent.locks.*;
public class SynchBankTest
{
	public static void main(String[] args)
	{
		Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
		int i;
		for (i = 0; i < NACCOUNTS; i++)
		{
			TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	
	}
	
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
}

class Bank
{
	public Bank(int n, double initialBalance)
	{
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++)
			accounts[i] = initialBalance;
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();
	}
	
	public void transfer(int from, int to, double amount)
		throws InterruptedException
		{
			bankLock.lock();
			try
			{
				while (accounts[from] < amount)
					sufficientFunds.await();
				System.out.print(Thread.currentThread());
				accounts[from] -= amount;
				System.out.printf(" %10.2f from %d", amount, from, to);
				accounts[to] += amount;
				System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
				sufficientFunds.signalAll();
			}
			finally
			{
				bankLock.unlock();
			}
		}
		
		public double getTotalBalance()
		{
			bankLock.lock();
			try
			{
				double sum = 0;
				
				for (double a : accounts)
					sum += a;
				
				return sum;
			}
			finally
			{
				bankLock.unlock();
			}
		}
		
		public int size()
		{
			return accounts.length;
		}
		
		private final double[] accounts;
		private Lock bankLock;
		private Condition sufficientFunds;
}

class TransferRunnable implements Runnable
{
	public TransferRunnable(Bank b, int from, double max)
	{
		bank = b;
		fromAccount = from;
		maxAmount = max;
	}
	
	public void run()
	{
		try
		{
			while(true)
			{
				int toAccount = (int) (bank.size() * Math.random());
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int) (DELAY * Math.random()));
			}
		}
		catch (InterruptedException e) {}
	}
	
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 10;
}