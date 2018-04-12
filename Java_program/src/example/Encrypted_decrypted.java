package example;

import java.util.Base64;

public class Encrypted_decrypted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Password = "sourabh1990";
		Password = Base64.getEncoder().encodeToString(Password.getBytes());
		System.out.println(Base64.getDecoder().decode(Password));
	}

}
