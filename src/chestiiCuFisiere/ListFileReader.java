package chestiiCuFisiere;

import com.sun.istack.internal.Nullable;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class ListFileReader<T> {

    protected final String filePath;
    protected final List<T> content = new ArrayList<>();

    protected ListFileReader(String filePath) {
        this.filePath = filePath;
    }

    public abstract void read() throws FileNotFoundException;

    /**
     * @param operator a function: to apply to the list of values such as sorting or filtering.
     * @return a copy of content with operator applied to it.
     */
    public final List<T> getContent(@Nullable  Consumer<List<T>> operator) {
        List<T> copy = new ArrayList<>(content);
        if (operator != null) {
            operator.accept(copy);
        }
        return copy;
    }

    public final List<T> getContent() {
        return getContent(null);
    }

}

