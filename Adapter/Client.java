public class Client {
 public static void main(String[] args) {
 Dengen d;

 d = new Adapter();
 int denatsu = d.kyuuden();
 System.out.println( denatsu + "V で給電されています" );
 }
}
interface Dengen {
	 public int kyuuden();
	}
class Adaptee{
	public int kyuuden100V() {
		return 100;
	}
}
class Adapter extends Client implements Dengen{
	private Adaptee adaptee;
	public Adapter() {
		this.adaptee=new Adaptee();
	}
	@Override
	public int kyuuden() {
		return adaptee.kyuuden100V();
	}

}