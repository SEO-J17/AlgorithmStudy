import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()){
            int num = scan.nextInt();
            System.out.println(calc(num));
        }
		
	}

	private static int calc(int num) {
		int temp = 0;
        for(int i=1;;i++){
        	temp = temp*10 + 1;
        	temp = temp % num;
            if(temp==0)
                return i;
        }
	}
}
