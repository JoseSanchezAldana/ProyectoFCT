package controlador;

import java.util.Base64;

/**
 * La clase SecurityUtilities proporciona métodos estáticos para cifrar y descifrar texto utilizando XOR y Base64.
 */
public class SecurityUtilities {

	/**
     * Cifra un texto utilizando XOR con una clave y lo codifica en Base64.
     * @param plaintext El texto plano a cifrar.
     * @param key La clave utilizada para el cifrado.
     * @return El texto cifrado y codificado en Base64.
     */
	public static String encrypt(String plaintext, String key) {
		StringBuilder ciphertext = new StringBuilder();

		for (int i = 0; i < plaintext.length(); i++) {
			char plainChar = plaintext.charAt(i);
			char keyChar = key.charAt(i % key.length());
			char encryptedChar = (char) (plainChar ^ keyChar);
			ciphertext.append(encryptedChar);
		}
		return Base64.getEncoder().encodeToString(ciphertext.toString().getBytes());
	}

	/**
     * Descifra un texto cifrado y codificado en Base64 utilizando XOR con una clave.
     * @param ciphertext El texto cifrado y codificado en Base64.
     * @param key La clave utilizada para el cifrado.
     * @return El texto plano descifrado.
     */
	public static String decrypt(String ciphertext, String key) {
		byte[] base64CipherText = Base64.getDecoder().decode(ciphertext);
		StringBuilder decryptedText = new StringBuilder();

		for (int i = 0; i < base64CipherText.length; i++) {
			char cipherChar = (char) base64CipherText[i];
			char keyChar = key.charAt(i % key.length());
			char decryptedChar = (char) (cipherChar ^ keyChar);
			decryptedText.append(decryptedChar);
		}
		return decryptedText.toString();
	}
}
