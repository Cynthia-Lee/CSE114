// CSE 114 Lab 20 (Fall 2017)
//
// Your name:
// Your SBU ID:

import java.util.*;

public class Trouble
{
	public static void main (String [] args)
	{
	try {
		problem();
		System.out.println("Delta");
	} catch (ArrayIndexOutOfBoundsException ex) {
		System.out.println("Alpha");
	} catch (NullPointerException ex) {
		System.out.println("Beta");		
	} catch (ArithmeticException ex){
		System.out.println("Gamma");				
	}
  }

  private static void problem()
  {
		Random r = new Random();

		int action = r.nextInt(4);

		if (action == 1)
		{
      System.out.println("About to generate an ArrayIndexOutOfBoundsException...");
			throw new ArrayIndexOutOfBoundsException();
		}

		if (action == 2)
		{
      System.out.println("About to generate a NullPointerException...");
			throw new NullPointerException();
		}

		if (action == 3)
		{
      System.out.println("About to generate an ArithmeticException...");
			throw new ArithmeticException();
		}

	}
}