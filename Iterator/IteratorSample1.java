public class IteratorSample1 {
 public static void main(String[] args) {
 CarListAggregate carListAggregate = new CarListAggregate();
 Iterator iterator = carListAggregate.createIterator();
 carListAggregate.add(new Car("プリウス", 3));
 carListAggregate.add(new Car("ポルシェ", 40));
 carListAggregate.add(new Car("フェラーリ", 50));
 carListAggregate.add(new Car("ベンツ", 20));
 iterator.first(); // まず探す場所を先頭位置にしてもらう
 while ( ! iterator.isDone() ) { // まだある？ まだあるよ！
 Car car = (Car)iterator.getItem(); // はいどうぞ (と受取る)
 System.out.println(car.getName());
 iterator.next(); // 次を頂戴
 }
 }
}
