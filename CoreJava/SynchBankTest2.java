public class SynchBankTest2
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
	public static final int NACCOUNTS = 10;
	public static final double INITIAL_BALANCE = 200;
}

class Bank
{
	public Bank(int n, double initialBalance)
	{
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++)
			accounts[i] = initialBalance;
	}
	
	public synchronized void transfer(int from, int to, double amount)
		throws InterruptedException
	{
		while (accounts[from] < amount)
			wait();
		System.out.println(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
		notifyAll();
	}
		
	public synchronized double getTotalBalance()
	{
		double sum = 0;
		for (double a : accounts)
			sum += a;
			
		return sum;
	}
		
	public int size()
	{
		return accounts.length;
	}
		
	private final double[] accounts;
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
			while (true)
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
	private int repetitions;
	private int DELAY = 10;
}

