package hello.spring_core.singleton;

public class StatefulService {  // 망한 서비스이다. 샷따 내려.

    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제
    }

    public int getPrice() {
        return this.price;
    }
}
