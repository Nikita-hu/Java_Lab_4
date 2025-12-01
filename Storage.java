public class Storage<T> {
    private final T content;
    private final T alternative;
    
    // Конструктор с альтернативным значением
    public Storage(T content, T alternative) {
        this.content = content;
        this.alternative = alternative;
    }
    
    // Конструктор только с содержимым (альтернативное значение будет null)
    public Storage(T content) {
        this.content = content;
        this.alternative = null;
    }
    
    // Метод для получения значения
    public T get() {
        return content != null ? content : alternative;
    }
    
    // Метод для проверки, хранится ли null
    public boolean isNull() {
        return content == null;
    }
    
    // Метод для получения исходного содержимого (без замены на альтернативное)
    public T getOriginal() {
        return content;
    }
    
    // Метод toString()
    @Override
    public String toString() {
        return String.format("Storage[%s] содержит: %s, альтернатива: %s",
                content != null ? content.getClass().getSimpleName() : "null",
                content,
                alternative);
    }
}