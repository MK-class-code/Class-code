import java.util.LinkedList;

interface Iterator {
 public void first(); // 取り出し位置を最初の要素へ変える
 public void next(); // 取り出し位置を次の要素へ変える
 public boolean isDone(); // 取り出し位置が最後を超えたか？
 public Object getItem(); // 現在の取り出し位置から取り出す
}
class CarListIterator implements Iterator {
	 private CarListAggregate aggregate;
	 private int current;
	 public CarListIterator(CarListAggregate aggregate) {
	 this.aggregate = aggregate;
	 }
	 @Override
	 public void first() {
	 current = 0;
	 }
	 @Override
	 public void next() {
		 current += 1;
		 }
		 @Override
		 public boolean isDone() {
		 if (current >= aggregate.getNumberOfStock()) {
		 return true;
		 }
		 else {
		 return false;
		 }
		 }
		 @Override
		 public Object getItem() {
		 return aggregate.getAt(current);
		 }
		}
interface Aggregate {
	 public Iterator createIterator();
	}
class CarListAggregate implements Aggregate {
	 private LinkedList<Car> Cars = new LinkedList<Car>();
	 private int numberOfStock;
	 private Boolean caradded;
	 @Override
	 public Iterator createIterator() {
	 return new CarListIterator(this);
	 }
	 public void add(Car car) {
		 caradded=false;
		 for (int i=0;i<numberOfStock;i++) {
			 if(car.getPrice()<Cars.get(i).getPrice()) {
				 Cars.add(i,car);
				 caradded=true;
				 break;
			 }
		 }
	 if(caradded==false) {
		 Cars.add(car);
	 }
	 numberOfStock += 1;

	 }
	 public Object getAt(int number) {
	 return Cars.get(number);
	 }
	 public int getNumberOfStock() {
	 return numberOfStock;
	 }
	}