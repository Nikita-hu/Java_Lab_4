public class BoxNew<T> {
    private T content;

    public BoxNew() {
        this.content = null;
    }

    public BoxNew(T content) {
        this.content = content;
    }

    public void put(T item) {
        if (isFull()) {
            throw new IllegalStateException("Коробка уже заполнена! Нельзя положить новый объект.");
        }
        this.content = item;
    }

    public T get() {
        if (isEmpty()) {
            throw new IllegalStateException("Коробка пуста! Нечего извлекать.");
        }
        T item = this.content;
        this.content = null;
        return item;
    }

    public boolean isFull() {
        return content != null;
    }

    public boolean isEmpty() {
        return content == null;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Коробка пуста!");
        }
        return content;
    }

    @Override
    public String toString() {
        if (isFull()) {
            return String.format("Box[%s] содержит: %s",
                    content.getClass().getSimpleName(), content);
        } else {
            return "Box пуста";
        }
    }
}
