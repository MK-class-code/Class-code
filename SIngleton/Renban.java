import java.text.DecimalFormat;
public class Renban {
	private static Renban renban = new Renban();
	private int number;
	DecimalFormat fm = new DecimalFormat("0000");
	private Renban() {
	}
	public String getNumber() {
		number++;
		return fm.format(number);
	}
	public static Renban getInstance() {
        return renban;
	}
}
class seizoubutu{
	private String number;
	public void setNumber(String s) {
		number=s;
	}
	public String getNumber() {
		return number;
	}
}
