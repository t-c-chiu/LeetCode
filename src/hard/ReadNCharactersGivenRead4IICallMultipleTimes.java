package hard;

public class ReadNCharactersGivenRead4IICallMultipleTimes {
	
	public class Solution extends Reader4 {
		
		int buffPtr, buffCnt;
		char[] buff = new char[4];
		
		public int read(char[] buf, int n) {
			int ptr = 0;
			while (ptr < n) {
				while (ptr < n && buffPtr < buffCnt) {
					buf[ptr++] = buff[buffPtr++];
				}
				if (buffPtr == buffCnt) {
					buffCnt = read4(buff);
					buffPtr = 0;
				}
				if (buffCnt == 0) {
					break;
				}
			}
			return ptr;
		}
	}
	
	private class Reader4 {
		int read4(char[] buf4) {
			return 0;
		}
	}
}
