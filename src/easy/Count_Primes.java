package easy;

public class Count_Primes {
	
	public static void main(String[] args) {
		Count_Primes test = new Count_Primes();
		System.out.println(test.countPrimes(6));
		System.out.println(test.countPrimes(10));
	}
	
	public int countPrimes(int n) {
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime(i))
				count++;
		}
		return count;
	}
	
	private boolean isPrime(int n) {
		if (n != 2 && n % 2 == 0)
			return false;
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
