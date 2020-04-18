package util;

import java.util.function.Function;

public interface Comparator<T> extends java.util.Comparator<T> {
    int compare(T t1, T t2);

    default Comparator<T> thenCompare(Comparator<T> comparator) {
        return (o1, o2) -> compare(o1, o2) == 0 ? comparator.compare(o1, o2) : compare(o1, o2);
    }

    default Comparator<T> thenCompare(Function<T, Comparable> action) {
        Comparator<T> comparator = comparing(action);
        return thenCompare(comparator);
    }

    static <U> Comparator<U> comparing(Function<U, Comparable> action) {
        return (o1, o2) -> action.apply(o1).compareTo(action.apply(o2));
    }
}
