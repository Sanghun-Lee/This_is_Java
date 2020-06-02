package lambda_expression_14.api.default_method.predicate;

import java.util.function.Predicate;

public class PredicateIsEqualExample {
    public static void main(String[] args) {
        Predicate<String> predicate;

        predicate = Predicate.isEqual(null);
        System.out.println("null, null : " + predicate.test(null));

        predicate = Predicate.isEqual("Java");
        System.out.println("null, Java : " + predicate.test(null));

        predicate = Predicate.isEqual(null);
        System.out.println("Java, null : " + predicate.test("Java"));

        predicate = Predicate.isEqual("Java");
        System.out.println("Java, Java : " + predicate.test("Java"));

        predicate = Predicate.isEqual("java");
        System.out.println("java, Java : " + predicate.test("Java"));
    }
}
