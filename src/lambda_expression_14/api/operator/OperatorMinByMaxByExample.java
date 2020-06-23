package lambda_expression_14.api.operator;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class OperatorMinByMaxByExample {
    public static void main(String[] args) {
        BinaryOperator<Fruit> binaryOperator;
        Fruit fruit;

        binaryOperator = BinaryOperator.minBy((f1, f2) -> Integer.compare(f1.price, f2.price));
        fruit = binaryOperator.apply(new Fruit("딸기", 6000), new Fruit("수박", 10000));
        System.out.println(fruit.name);

        binaryOperator = BinaryOperator.maxBy((f1, f2) -> Integer.compare(f2.price, f1.price));
        fruit = binaryOperator.apply(new Fruit("딸기", 6000), new Fruit("수박", 10000));
        System.out.println(fruit.name);

        binaryOperator = BinaryOperator.minBy(new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                return Integer.compare(o1.price, o2.price);
            }
        });
    }
}

class Fruit {
    public String name;
    public int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price =price;
    }
}