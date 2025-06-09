package randomNumber;

import java.util.Random;

public class GenerateRandomNumber {
	public static void main(String[] args) {
		Random rndm= new Random();
		
		System.out.println(rndm.nextInt(1000));
	}

}
