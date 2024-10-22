
public class CryptoManagerDemo {

	public static void main(String[] args) {
		System.out.println(CryptoManager.caesarEncryption("david", 9));
		
		boolean passes = true;
		for (int i = -99; i < 100; i++) {
			if (!CryptoManager.caesarDecryption(CryptoManager.caesarEncryption("DAVID", i), i).equals("DAVID"))
				passes = false;
		}
		System.out.println("Does -99 to 99 pass? " + passes);
		
		System.out.println(CryptoManager.bellasoEncryption("ABC", "abc"));
		
		System.out.println(CryptoManager.bellasoDecryption("\"$&", "abcabc"));
	}
	
}
