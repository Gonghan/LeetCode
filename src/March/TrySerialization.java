package March;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TrySerialization {

	public static void main(String args[]) {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(bos);
			myBook b = new myBook("Name", "ÄãºÃ", 100);
			oos.writeObject(b);
			// deserialize object, get new object newpair
			ByteArrayInputStream bis = new ByteArrayInputStream(
					bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			myBook newb = (myBook) ois.readObject();

			System.out.println(newb.toString());
			System.out.println(myBook.getISDN());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class myBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7841372683615210106L;

	private String name;
	private String authorName;
	private transient int pageNum;
	private static int ISDN;

	public myBook(String name, String authorName, int pageNum) {
		super();
		this.name = name;
		this.authorName = authorName;
		this.pageNum = pageNum;
		ISDN=11111111;
	}

	@Override
	public String toString() {
		return "myBook [name=" + name + ", authorName=" + authorName
				+ ", pageNum=" + pageNum + "]";
	}

	public static int getISDN(){
		return ISDN;
	}

}