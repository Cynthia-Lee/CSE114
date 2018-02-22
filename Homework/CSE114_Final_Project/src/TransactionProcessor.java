//Name: Cynthia Lee
//ID: 111737790

// Driver class for the final project
import java.util.*;
import java.io.*;

public class TransactionProcessor
{
	public static void main (String[] args) { 
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the name of the account list file:");
		String text = input.next();
	
		CardList cl = loadCardData(text);
		if(cl!=null) {
			System.out.print("Please enter the name of a transaction file: ");
			String transText = input.next();
			processTransactions(transText,cl);
			System.out.println();
			for(int i = 0; i<cl.size(); i++) {
				cl.get(i).printStatement();
				//System.out.println(cl.get(i).isFraud);
				if(cl.get(i).isFraud==true) {
					System.out.println("** Account frozen due to suspected fraud **");
				} 
				System.out.println("");
			}
		}
		
	}
	
	private static String getCardType (long number)
	{
		// Return a String indicating whether 'number' belongs to a 
		// CreditCard, RewardsCard, or a PrepaidCard (or null if it's none
		// of the three)
		
		String result;
		
		int firstTwo = Integer.parseInt(("" + number).substring(0,2));
		
		switch(firstTwo)
		{
			case 84:
			case 85: result = "CreditCard"; break;
			case 86:
			case 87: result = "RewardsCard"; break;
			case 88:
			case 89: result = "PrepaidCard"; break;
			default: result = null; // invalid card number
		}
		
		return result;
	}
	
	
	public static BankCard convertToCard(String data) {
		String ct;
		Scanner reader = new Scanner(data); //only collect input from that String
		long cardNum = reader.nextLong();
		if(getCardType(cardNum).equals(null)) {
			//skip and move to the next line of the file
			return null;
		} else {
			ct = getCardType(cardNum); 
		}
		//Prepaid: number,name
		//Credit/rewards: number,name,  expiration (default credit limit)
		//Prepaid: number,name,  balance
		//Credit/Rewards: number,name,  expiration, limit
		String name; double balance; int exp; double lim; 
		name = reader.next(); //number = cardNum
		if(name.contains("_")) {
			String[] n = name.split("_");
			name = n[0]+" "+n[1];
		} else {
			//name does not change
		}
		
		if(ct.equals("CreditCard")) {
			exp = reader.nextInt();
			if(reader.hasNextDouble()) {
				lim = reader.nextDouble();
				CreditCard c = new CreditCard(name,cardNum,exp,lim);
				return c;
			} else {
				CreditCard c = new CreditCard(name,cardNum,exp);
				return c;
			}
		} else if (ct.equals("RewardsCard")) {
			exp = reader.nextInt();
			if(reader.hasNextDouble()) {
				lim = reader.nextDouble();
				RewardsCard c = new RewardsCard(name,cardNum,exp,lim);
				return c;
			} else {
				RewardsCard c = new RewardsCard(name,cardNum,exp);
				return c;
			}
			
		} else if (ct.equals("PrepaidCard")) {
			if(reader.hasNextDouble()) {
				balance = reader.nextDouble();
				PrepaidCard c = new PrepaidCard(name,cardNum,balance);
				return c;
			} else {
				PrepaidCard c = new PrepaidCard(name,cardNum);
				return c;
			}
		} else {
			return null;
		}
		
	}
	
	public static CardList loadCardData(String fName) { //takes name of a card data file as argument
		CardList list = new CardList();
		try {
			File inputFile = new File(fName);
			Scanner fs = new Scanner(inputFile);
			//opens and processes file one line at a time
			while(fs.hasNextLine()) {
				String line = fs.nextLine();
				list.add(convertToCard(line)); 
			}
			//return CardList of BankCards
			return list;
			
		} catch (IOException ex) {
			return null; //indicates failure
		}
	}
	
	public static void processTransactions(String filename, CardList c) { 
		try {
			File inputFile = new File(filename);
			Scanner fs = new Scanner(inputFile);
			while(fs.hasNextLine()) {
				String line = fs.nextLine();
				String[] arr = line.split(" ");
				long cardNum = Long.parseLong(arr[0]);
				int index = c.indexOf(cardNum);
				//second substring is the type
				String type = arr[1];
				//redeem type: has next int (points to be redeemed)
				//top-up type: has next double (money to add)
				//debit or credit type: double(transaction amount),merchant name(String) "_"
				
				if(type.equals("redeem")) {
					int points = Integer.parseInt(arr[2]); //points to redeem
					((RewardsCard) c.get(index)).redeemPoints(points);
				} else if (type.equals("top-up")) {
					double value = Double.parseDouble(arr[2]); //amount of money to add
					((PrepaidCard) c.get(index)).addFunds(value);
				} else if(type.equals("advance")) {
					double value = Double.parseDouble(arr[2]);
					((CreditCard) c.get(index)).getCashAdvance(value);
				} else {
					//Create a new Transaction from the 2nd,4th, and 3rd substrings
					//type arr[1] (2nd)
					double value = Double.parseDouble(arr[2]); //(3rd)
					String company = arr[3]; //(4th)
					String comp = "";
					if(company.contains("_")) {
						String[] n = company.split("_");
						for(int i = 0; i<n.length; i++) {
							if(i==n.length-1) {
								comp = comp+n[i];
							} else {
								comp = comp+n[i]+" ";
							}
						}
					} else {
						comp = company;
					}
					
					Transaction t = new Transaction(type,comp,value);
					c.get(index).addTransaction(t);
					c.get(index).checkFraud(c.get(index));
				}
				
			}
		
		} catch (IOException ex) { 
			return;
		}
	}
	
		
}