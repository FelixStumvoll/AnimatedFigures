package animatedfigures.ui.visitor;

import java.util.function.Consumer;

public interface StatefulVisitor<T extends StatefulVisitor<?>> {
    void update(Consumer<T> consumer);
}
