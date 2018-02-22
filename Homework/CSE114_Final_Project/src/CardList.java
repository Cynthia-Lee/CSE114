//Name: Cynthia Lee
//ID: 111737790
import java.util.ArrayList;

public class CardList {
	private ArrayList<BankCard> list;
	
	public CardList() {
		list = new ArrayList<BankCard>();
	}
	public void add(BankCard b) {
		list.add(b);
	}
	public void add(int index,BankCard b) {
		if(index>=0 && index<list.size()) {
			list.add(index, b);
		} else {
			list.add(b);
		}
	}
	public int size() {
		return list.size();
	}
	public BankCard get(int index) {
		if(index>=0 && index<list.size()) {
			return list.get(index);
		} else {
			return null;
		}
	}
	public int indexOf(long cardNumber) {
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).number()==cardNumber) {
				return i;
			}
		}
		return -1;
	}
	
}
