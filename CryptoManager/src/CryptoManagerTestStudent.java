import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("DAVID"));
		assertTrue(CryptoManager.isStringInBounds("123$%^;:. "));
		assertFalse(CryptoManager.isStringInBounds("david"));
		assertFalse(CryptoManager.isStringInBounds("\n\t"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("david", 7));
		assertEquals("L#ZRQGHU#ZKDW#WKH#RXWSXW#ZLOO#EH", CryptoManager.caesarEncryption("I WONDER WHAT THE OUTPUT WILL BE", 3));
		assertEquals("()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_ !\"#$%&'", CryptoManager.caesarEncryption(" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_", 8));
		assertEquals("5<:AH@58E(($%&", CryptoManager.caesarEncryption("BIGNUMBER55123", 555123));
		assertEquals("5<:AH@58E(($%&", CryptoManager.caesarEncryption("BIGNUMBER55123", 51)); // 555123 MOD 64 = 51 | Same key.
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("I WONDER WHAT THE OUTPUT WILL BE", CryptoManager.caesarDecryption("L#ZRQGHU#ZKDW#WKH#RXWSXW#ZLOO#EH", 3));
		assertEquals("BIGNUMBER55123", CryptoManager.caesarDecryption("5<:AH@58E(($%&", 51));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("[TRS)[$Z&J!UPX", CryptoManager.bellasoEncryption("FAMOUS_EXAMPLE", "USEDTHEUNITEDSTATESDECLARATIONOFINDEPENDANCEASTHEKEYTEXT"));
		assertEquals(")JU+$] UR$YU!Y\"%JW%JW1Y#2UD%X3\"S", CryptoManager.bellasoEncryption("VERY_IMPORTANT_SECRET_TO_PASS_ON", "SECRET"));
	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("FAMOUS_EXAMPLE", CryptoManager.bellasoDecryption("[TRS)[$Z&J!UPX", "USEDTHEUNITEDSTATESDECLARATIONOFINDEPENDANCEASTHEKEYTEXT"));
		assertEquals("VERY_IMPORTANT_SECRET_TO_PASS_ON", CryptoManager.bellasoDecryption(")JU+$] UR$YU!Y\"%JW%JW1Y#2UD%X3\"S", "SECRET"));
	}

}
