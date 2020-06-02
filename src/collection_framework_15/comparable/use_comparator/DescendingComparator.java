package collection_framework_15.comparable.use_comparator;

import java.util.Comparator;

public class DescendingComparator implements Comparator<Fruit> {
    @Override
    public int compare(Fruit f1, Fruit f2) {
        if(f1.price < f2.price) return 1;
        else if(f1.price == f2.price) return 0;
        else return -1;
    }
}
