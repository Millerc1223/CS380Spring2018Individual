package eou.eou.cs.cs380;

public class CipherImpl implements Cipher{
    public String encrypt(String stringToEncrypt, String key){
        if(stringToEncrypt == null){throw new IllegalArgumentException("Message cannot be empty");}
        if(key == null || key.length() <= 0){throw new IllegalArgumentException("Key cannot be empty");}
        String s = stringToEncrypt.toUpperCase();
        char [] encryptedString = new char[s.length()];
        String keyPhrase = key.toUpperCase();
        for (int i = 0; i < key.length(); i++){
            if(keyPhrase.charAt(i) < 65 || keyPhrase.charAt(i) > 90)
                throw new IllegalArgumentException("Key must only contain characters that are A-Z or a-z");
        }
        for (int i = 0,j = 0; i< s.length(); i++){
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
                if(j == keyPhrase.length()){j = 0;}
                char newChar = (char) ((s.charAt(i) + keyPhrase.charAt(j)) % 26 + 'A');
                encryptedString[i] = getCase(newChar, stringToEncrypt.charAt(i));
                j++;
            }
            else{encryptedString[i] = s.charAt(i);}
        }
        StringBuilder endResult = new StringBuilder();
        for(int i = 0; i < encryptedString.length; i++){
            endResult.append(encryptedString[i]);
        }
        return endResult.toString();
    }

    public String decrypt(String stringToDecrypt, String key){
        if(stringToDecrypt == null || stringToDecrypt.length() <= 0){throw new IllegalArgumentException("Message cannot be empty");}
        if(key == null || key.length() <= 0){throw new IllegalArgumentException("Key cannot be empty");}
        String s = stringToDecrypt.toUpperCase();
        char [] decryptedString = new char[s.length()];
        String keyPhrase = key.toUpperCase();
        for (int i = 0; i < keyPhrase.length(); i++){
            if(keyPhrase.charAt(i) < 65 || keyPhrase.charAt(i) > 90)
                throw new IllegalArgumentException("Key must only contain characters that are A-Z or a-z");
        }
        for (int i = 0,j = 0; i< s.length(); i++){
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
                if(j == keyPhrase.length()){j = 0;}
                char newChar = (char) ((s.charAt(i) - keyPhrase.charAt(j) + 26) % 26 + 'A');
                decryptedString[i] = getCase(newChar, stringToDecrypt.charAt(i));
                j++;
            }
            else{decryptedString[i] = s.charAt(i);}
        }
        StringBuilder endResult = new StringBuilder();
        for(int i = 0; i < decryptedString.length; i++){endResult.append(decryptedString[i]);}
        return endResult.toString();
    }

    private char getCase(char caselessChar, char originalChar){
        char newChar = caselessChar;
        if(originalChar > 96 && originalChar < 122){newChar += 32;}
        return newChar;
    }
}
