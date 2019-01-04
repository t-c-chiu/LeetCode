package easy;

public class ExcelSheetColumnNumber {
	public static void main(String[] args) {
		ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
		System.out.println(excelSheetColumnNumber.titleToNumber("A"));
		System.out.println(excelSheetColumnNumber.titleToNumber("Z"));
		System.out.println(excelSheetColumnNumber.titleToNumber("AA"));
		System.out.println(excelSheetColumnNumber.titleToNumber("ZZ"));
	}

	// A B C ... Z AA AB AC AZ ... BA BB BC
	//	A - 1
	//	Z - 26
	//	AA - 27
	public int titleToNumber(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result *= 26;
			result += s.charAt(i) - 'A' + 1;
		}
		return result;
	}
}