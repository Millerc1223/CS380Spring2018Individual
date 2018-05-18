package eou.eou.cs.cs380;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CipherTest {

    @Test
    public void testEncrypt1() throws Exception{
        Cipher cipher = new CipherImpl();
        String result = cipher.encrypt("cs380 is awesome", "bagofbones");
        assertEquals("ds380 og fxsfsef", result);
    }

    @Test
    public void testDecrypt1() throws Exception{
        Cipher cipher = new CipherImpl();
        String result = cipher.decrypt("lbcd uiqvh njohy oygncvh vg", "puck");
        assertEquals("what fools these mortals be", result);
    }

    @Test
    public void testEncrypt2() throws Exception{
        Cipher cipher = new CipherImpl();
        String result = cipher.encrypt("Jeremiah was a bull frog", "nuggets");
        String result2 = cipher.encrypt("Jeremiah was a bull frog", "nuggets");
        assertEquals(result2, result);
    }

    @Test
    public void testDecrypt2() throws Exception{
        Cipher cipher = new CipherImpl();
        String result = cipher.decrypt("Vseoywnr iof k niyv rfbq", "monk");
        String result2 = cipher.decrypt("Vseoywnr iof k niyv rfbq", "monk");
        assertEquals(result2, result);
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    public void testEncrypt3() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Key cannot be empty");
        Cipher cipher = new CipherImpl();
        String result = cipher.encrypt("Jeremiah was a bull frog", "");
    }

    @Test
    public void testDecrypt3() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Key cannot be empty");
        Cipher cipher = new CipherImpl();
        String result = cipher.decrypt("Vseoywnr iof k niyv rfbq", "");
    }

    @Test
    public void testEncrypt4() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Key cannot be empty");
        Cipher cipher = new CipherImpl();
        String result = cipher.encrypt("Jeremiah was a bull frog", null);
    }

    @Test
    public void testDecrypt4() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Key cannot be empty");
        Cipher cipher = new CipherImpl();
        String result = cipher.decrypt("Vseoywnr iof k niyv rfbq", null);
    }

    @Test
    public void testEncrypt5() throws Exception{
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Key must only contain characters that are A-Z or a-z");
        Cipher cipher = new CipherImpl();
        String result = cipher.encrypt("Jeremiah was a bull frog", "it's");
    }

    @Test
    public void testDecrypt5() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Key must only contain characters that are A-Z or a-z");
        Cipher cipher = new CipherImpl();
        String result = cipher.decrypt("Vseoywnr iof k niyv rfbq", "it's");
    }

    @Test
    public void testEncrypt6() throws Exception {
        Cipher cipher = new CipherImpl();
        String result = cipher.encrypt("JeReMiAh wAs a BuLl fRoG", "monk");
        assertEquals("VsEoYwNr iOf k NiYv rFbQ", result);
    }

    @Test
    public void testDecrypt6() throws Exception {
        Cipher cipher = new CipherImpl();
        String result = cipher.decrypt("VsEoYwNr iOf k NiYv rFbQ", "monk");
        assertEquals("JeReMiAh wAs a BuLl fRoG", result);
    }

    @Test
    public void testEncrypt7() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Message cannot be empty");
        Cipher cipher = new CipherImpl();
        String result = cipher.encrypt(null, "monk");
    }

    @Test
    public void testDecrypt7() throws Exception {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Message cannot be empty");
        Cipher cipher = new CipherImpl();
        String result = cipher.decrypt(null, "monk");
    }

    @Test
    public void testEncrypt8() throws Exception {
        Cipher cipher = new CipherImpl();
        String result = cipher.encrypt("JeReMiAh wAs   a BuLl fRoG", "monk");
        assertEquals("VsEoYwNr iOf   k NiYv rFbQ", result);
    }

    @Test
    public void testDecrypt8() throws Exception {
        Cipher cipher = new CipherImpl();
        String result = cipher.decrypt("VsEoYwNr iOf   k NiYv rFbQ", "monk");
        assertEquals("JeReMiAh wAs   a BuLl fRoG", result);
    }

    @Test
    public void testEncrypt9() throws Exception {
        Cipher cipher = new CipherImpl();
        String result = cipher.encrypt("JeReMiAh wAs a BuLl fRoG!", "monk");
        assertEquals("VsEoYwNr iOf k NiYv rFbQ!", result);
    }

    @Test
    public void testDecrypt9() throws Exception {
        Cipher cipher = new CipherImpl();
        String result = cipher.decrypt("VsEoYwNr iOf k NiYv rFbQ!", "monk");
        assertEquals("JeReMiAh wAs a BuLl fRoG!", result);
    }
}
