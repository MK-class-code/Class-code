
public class SingletonTest {

	public static void main(String[] args) {
		Renban renban = Renban.getInstance();
		seizoubutu s1 = new seizoubutu();
		s1.setNumber(renban.getNumber());
		seizoubutu s2 = new seizoubutu();
		s2.setNumber(renban.getNumber());
		System.out.println(s1.getNumber());
		System.out.println(s2.getNumber());
	}

}