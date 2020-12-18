package animatedfigures.util;

import java.util.function.Function;

public class Pair<TFirst, TSecond> {
    private final TFirst first;
    private final TSecond second;

    public Pair(TFirst first, TSecond second) {
        this.first = first;
        this.second = second;
    }

    public TFirst first() {
        return this.first;
    }

    public TSecond second() {
        return this.second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + this.first +
                ", second=" + this.second +
                '}';
    }

    public <A, B> Pair<A, B> map(Function<TFirst, A> f1, Function<TSecond, B> f2) {
        return Pair.of(f1.apply(this.first()), f2.apply(this.second()));
    }

    public static <A, B> Pair<A, B> of(A a, B b) {
        return new Pair<>(a, b);
    }
}
