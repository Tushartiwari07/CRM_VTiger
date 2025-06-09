package tp;

public class RandomNum {
	public static void main(String[] args) {
		int size=5;
		String val="ABCD123abcd";
		
		StringBuilder sbil=new StringBuilder(size);
		
		for(int i=0;i<size;i++) {
			System.out.println("Math:"+Math.random());
			int num=(int)(val.length()* Math.random());	
			System.out.println("Random:"+num);
			
			sbil.append(val.charAt(num));			
		}
		System.out.println("Val:"+sbil);
	}
}
