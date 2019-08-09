package factorymethod;

public class Client {
	 public static void main(String[] args) {
	 Koujyou koujyou1 = new TvKoujyou();
	 Koujyou koujyou2 = new RadioKoujyou();
	 Seihin[] array = new Seihin[3];
	 array[0] = koujyou1.create();//テレビが生成される
	 array[1] = koujyou2.create();//ラジオが生成される
	 array[2] = koujyou1.create();//テレビが生成される
	 for (int i = 0; i < array.length; ++i) {//完成品の詳細を表示
	 array[i].print();
	 }
	 }
	}
abstract class Koujyou {//Creatorクラスに相当
	 public final Seihin create() {
	 Seihin seihin = factoryMethod(); touroku(seihin);
	 return seihin;
	 }
	 public abstract Seihin factoryMethod();
	 public abstract void touroku(Seihin s);
	}
class TvKoujyou extends Koujyou {//ConcreteCreatorクラスに相当
	 public Seihin factoryMethod() {
	 return new Television();
	 }
	 public void touroku(Seihin s) {
	 Television t = (Television) s;
	 t.numberring();//製造番号を登録
	 t.setDate(Date.today());//製造年月日を登録
	 }
	}
class RadioKoujyou extends Koujyou {//ConcreteCreatorクラスに相当
	 public Seihin factoryMethod() {
	 return new Radio();
	 }
	 public void touroku(Seihin s) {
	 Radio r = (Radio) s;
	 r.numberring();//製造番号を登録
	 }
	}
abstract class Seihin {//Productクラスに相当
	 public abstract void print();
	}
class Television extends Seihin {//ConcreteProductクラスに相当
	 private int tvSerialNumber;
	 private String date;
	 public void numberring() {//製造番号を振る
	 tvSerialNumber = Counter.getTvNumber();
	 }
	 public void setDate(String date) {//製造年月日を振る
	 this.date = date;
	 }
	 public void print() {//この製品の情報を表示
	 System.out.println("このテレビに関する情報:");
	 System.out.println(" 製造番号:" + tvSerialNumber);
	 System.out.println(" 製造年月日:" + date);
	 }
}
class Radio extends Seihin {//Productクラスに相当
	 private int radioSerialNumber;
	 public void numberring() {//製造番号を振る
	 radioSerialNumber = Counter.getRadioNumber();
	 }
	 public void print() {//この製品の情報を表示
	 System.out.println("このラジオに関する情報:");
	 System.out.println(" 製造番号:" + radioSerialNumber);
	 }
	}
class Date {
	 public static String today() {//製造年月日を返す
	 return "2004/01/20";
	 }
	}
	class Counter {
	 private static int tvNum = 100;
	 private static int radioNum = 76;
	 public static int getTvNumber() {//新しいテレビの製造番号を返す
	 return tvNum++;
	 }
	 public static int getRadioNumber() {//新しいラジオの製造番号を返す
	 return radioNum++;
	 }
	}