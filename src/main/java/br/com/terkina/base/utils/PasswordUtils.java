package br.com.terkina.base.utils;

import java.util.Random;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtils {
	
	private static final char[] ALL_CHARS = new char[62];
	private static final Random RANDOM = new Random();
	
	static {
		for (int i = 48, j = 0; i < 123; i++) {
			if (Character.isLetterOrDigit(i)) {
				ALL_CHARS[j] = (char) i;
				j++;
			}
		}
	}
	
	public static String getRandomPassword(final int length) {
		
		final char[] result = new char[length];
		for (int i = 0; i < length; i++) {
			result[i] = ALL_CHARS[RANDOM.nextInt(ALL_CHARS.length)];
		}
		
		return new String(result);
	}
	
	public static String getRandomPassword() {
		return getRandomPassword(8);
	}
	
	public static String encode(String password) {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encoder.encode(password);
	}
}