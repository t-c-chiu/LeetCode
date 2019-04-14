package easy;

public class ComplementOfBaseTenInteger {
	public static void main(String[] args) {
		ComplementOfBaseTenInteger complementOfBaseTenInteger = new ComplementOfBaseTenInteger();
		System.out.println(complementOfBaseTenInteger.bitwiseComplement(5));
		System.out.println(complementOfBaseTenInteger.bitwiseComplement(10));
		System.out.println(complementOfBaseTenInteger.bitwiseComplement(2));
	}
	
	public int bitwiseComplement(int N) {
		int i = 1;
		while (N > i)
			i = i * 2 + 1;
		return N ^ i;
	}
}
