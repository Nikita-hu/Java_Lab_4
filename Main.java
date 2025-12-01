import java.util.function.Function;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.1 \n1.2 \n2.3 \n3.1 \n3.2 \nВыбери тему задачи: ");
        String theme = scanner.nextLine();
        
        switch (theme) {
            case "1.1":
                System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ КЛАССА BOX<T> ===\n");
                
                // Создаем коробку для целых чисел
                Box<Integer> integerBox = new Box<>();
                
                System.out.println("1. Создана пустая коробка для Integer:");
                System.out.println("Состояние: " + integerBox);
                System.out.println("Пуста ли коробка? " + integerBox.isEmpty());
                
                // Помещаем число 3 в коробку
                System.out.println("\n2. Помещаем число 3 в коробку:");
                integerBox.put(3);
                System.out.println("Состояние: " + integerBox);
                System.out.println("Заполнена ли коробка? " + integerBox.isFull());
                
                // Передаем коробку в метод и извлекаем значение
                System.out.println("\n3. Передаем коробку в метод и извлекаем значение:");
                processIntegerBox(integerBox);
                
                System.out.println("\n4. После извлечения:");
                System.out.println("Состояние: " + integerBox);
                System.out.println("Пуста ли коробка? " + integerBox.isEmpty());
                
                // Демонстрация работы с другими типами
                System.out.println("\n=== ДОПОЛНИТЕЛЬНЫЕ ПРИМЕРЫ ===");
                
                // Работа со строковой коробкой
                Box<String> stringBox = new Box<>();
                stringBox.put("Hello, World!");
                System.out.println("\nСтроковая коробка: " + stringBox);
                String text = stringBox.get();
                System.out.println("Извлеченная строка: " + text);
                
                // Попытка положить объект в заполненную коробку
                System.out.println("\n5. Попытка положить второй объект:");
                try {
                    integerBox.put(5); 
                    integerBox.put(10);
                } catch (IllegalStateException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
                
                // Попытка извлечь из пустой коробки
                // System.out.println("\n6. Попытка извлечь из пустой коробки:");
                // try {
                //     integerBox.get(); // Коробка уже пустая после предыдущей ошибки
                // } catch (IllegalStateException e) {
                //     System.out.println("Ошибка: " + e.getMessage());
                // }
                break;
            
            case "1.2":
                System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ КЛАССА STORAGE<T> ===\n");
        
                // 1. Хранилище чисел с null (альтернатива 0)
                System.out.println("1. Хранилище чисел с null (альтернатива 0):");
                Storage<Integer> intStorage1 = new Storage<>(null, 0);
                System.out.println("Создано: " + intStorage1);
                processIntegerStorage(intStorage1);
                
                // 2. Хранилище чисел с 99 (альтернатива -1)
                System.out.println("\n2. Хранилище чисел с 99 (альтернатива -1):");
                Storage<Integer> intStorage2 = new Storage<>(99, -1);
                System.out.println("Создано: " + intStorage2);
                processIntegerStorage(intStorage2);
                
                // 3. Хранилище строк с null (альтернатива "default")
                System.out.println("\n3. Хранилище строк с null (альтернатива 'default'):");
                Storage<String> stringStorage1 = new Storage<>(null, "default");
                System.out.println("Создано: " + stringStorage1);
                processStringStorage(stringStorage1);
                
                // 4. Хранилище строк с "hello" (альтернатива "hello world")
                System.out.println("\n4. Хранилище строк с 'hello' (альтернатива 'hello world'):");
                Storage<String> stringStorage2 = new Storage<>("hello", "hello world");
                System.out.println("Создано: " + stringStorage2);
                processStringStorage(stringStorage2);
                
                System.out.println("\n=== ДОПОЛНИТЕЛЬНЫЕ ПРИМЕРЫ ===");
                
                // Дополнительный пример с пользовательским классом
                System.out.println("\n5. Хранилище объектов:");
                Storage<Person> personStorage = new Storage<>(null, new Person("Гость", 0));
                System.out.println("Создано: " + personStorage);
                processPersonStorage(personStorage);
                break;

            case "2.3":
                System.out.println("=== ДЕМОНСТРАЦИЯ МЕТОДА С МАСКАМИ ТИПОВ ===\n");
        
                // Создаем различные коробки
                BoxNew<Point3D> pointBox = new BoxNew<>();
                BoxNew<Object> objectBox = new BoxNew<>();
                BoxNew<Number> numberBox = new BoxNew<>();
                
                System.out.println("1. Коробка для Point3D:");
                System.out.println("До: " + pointBox);
                fillBoxWithPoint(pointBox);
                System.out.println("После: " + pointBox);
                
                System.out.println("\n2. Коробка для Object:");
                System.out.println("До: " + objectBox);
                fillBoxWithPoint(objectBox);
                System.out.println("После: " + objectBox);
                
                System.out.println("\n3. Коробка для Number:");
                System.out.println("До: " + numberBox);
                // fillBoxWithPoint(numberBox);
                System.out.println("После: " + numberBox);
                
                // Демонстрация работы с извлеченными точками
                System.out.println("\n=== РАБОТА С ИЗВЛЕЧЕННЫМИ ТОЧКАМИ ===");
                
                Point3D point1 = pointBox.get();
                System.out.println("Извлеченная точка из Point3D коробки: " + point1);
                System.out.println("Расстояние до начала координат: " + point1.distanceToOrigin());
                
                Point3D point2 = (Point3D) objectBox.get();
                System.out.println("Извлеченная точка из Object коробки: " + point2);
                System.out.println("Расстояние до начала координат: " + point2.distanceToOrigin());
                
                // Point3D point3 = (Point3D) numberBox.get();
                // System.out.println("Извлеченная точка из Number коробки: " + point3);
                // System.out.println("Расстояние до начала координат: " + point3.distanceToOrigin());
                
                // Демонстрация с ограниченными масками
                System.out.println("\n=== ДЕМОНСТРАЦИЯ ОГРАНИЧЕННЫХ МАСОК ===");
                
                BoxNew<Point3D> anotherPointBox = new BoxNew<>();
                BoxNew<Object> anotherObjectBox = new BoxNew<>();
                
                System.out.println("4. Использование ограниченной маски (? super Point3D):");
                fillBoxWithPointLimited(anotherPointBox);
                System.out.println("Коробка Point3D: " + anotherPointBox);
                
                fillBoxWithPointLimited(anotherObjectBox);
                System.out.println("Коробка Object: " + anotherObjectBox);
                
                // Попытка с неподходящим типом (должна вызвать ошибку компиляции)
                // Box<String> stringBox = new Box<>();
                // fillBoxWithPoint(stringBox); // Ошибка компиляции!
                break;

            case "3.1":
                System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ ФУНКЦИОНАЛЬНОГО МЕТОДА ===\n");
                
                // 1. Преобразование строк в их длины
                System.out.println("1. Строки -> длины строк:");
                List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
                System.out.println("Исходный список: " + strings);
                
                List<Integer> stringLengths = map(strings, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String value) {
                        return value.length();
                    }
                });
                System.out.println("Результат (длины): " + stringLengths);
                
                // Альтернативная запись с лямбдой
                List<Integer> stringLengthsLambda = map(strings, s -> s.length());
                System.out.println("Результат (лямбда): " + stringLengthsLambda);
                
                // 2. Преобразование чисел: отрицательные -> положительные
                System.out.println("\n2. Числа -> абсолютные значения:");
                List<Integer> numbers = Arrays.asList(1, -3, 7);
                System.out.println("Исходный список: " + numbers);
                
                List<Integer> absoluteNumbers = map(numbers, new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer value) {
                        return Math.abs(value);
                    }
                });
                System.out.println("Результат (абсолютные): " + absoluteNumbers);
                
                // Альтернативная запись с лямбдой
                List<Integer> absoluteNumbersLambda = map(numbers, n -> Math.abs(n));
                System.out.println("Результат (лямбда): " + absoluteNumbersLambda);
                
                // 3. Преобразование массивов в их максимальные значения
                System.out.println("\n3. Массивы -> максимальные значения:");
                List<int[]> arrays = Arrays.asList(
                    new int[]{1, 5, 3},
                    new int[]{-2, 8, 0},
                    new int[]{10, -5, 7, 2}
                );
                
                // Выводим исходные массивы
                System.out.print("Исходные массивы: ");
                for (int[] arr : arrays) {
                    System.out.print(Arrays.toString(arr) + " ");
                }
                System.out.println();
                
                List<Integer> maxValues = map(arrays, new Function<int[], Integer>() {
                    @Override
                    public Integer apply(int[] array) {
                        if (array.length == 0) return 0;
                        int max = array[0];
                        for (int i = 1; i < array.length; i++) {
                            if (array[i] > max) {
                                max = array[i];
                            }
                        }
                        return max;
                    }
                });
                System.out.println("Максимальные значения: " + maxValues);
                
                // Альтернативная запись с лямбдой
                List<Integer> maxValuesLambda = map(arrays, arr -> {
                    if (arr.length == 0) return 0;
                    int max = arr[0];
                    for (int i = 1; i < arr.length; i++) {
                        if (arr[i] > max) max = arr[i];
                    }
                    return max;
                });
                System.out.println("Максимальные значения (лямбда): " + maxValuesLambda);
                
                // ДОПОЛНИТЕЛЬНЫЕ ПРИМЕРЫ
                System.out.println("\n=== ДОПОЛНИТЕЛЬНЫЕ ПРИМЕРЫ ===");
                
                // 4. Преобразование чисел в строки
                System.out.println("\n4. Числа -> строки:");
                List<Integer> nums = Arrays.asList(10, 20, 30);
                List<String> numberStrings = map(nums, n -> "Число: " + n);
                System.out.println("Исходный список: " + nums);
                System.out.println("Результат: " + numberStrings);
                
                // 5. Преобразование строк в верхний регистр
                System.out.println("\n5. Строки -> верхний регистр:");
                List<String> words = Arrays.asList("hello", "world", "java");
                List<String> upperCaseWords = map(words, String::toUpperCase);
                System.out.println("Исходный список: " + words);
                System.out.println("Результат: " + upperCaseWords);
                break;

            case "3.2":
                System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ МЕТОДА ФИЛЬТРАЦИИ ===\n");
                
                // 1. Фильтрация строк: оставить строки длиной >= 3 символов
                System.out.println("1. Фильтрация строк (длина >= 3):");
                List<String> strings1 = Arrays.asList("qwerty", "asdfg", "zx", "abc", "xy");
                System.out.println("Исходный список: " + strings1);
                
                List<String> filteredStrings = filter(strings1, new Predicate<String>() {
                    @Override
                    public boolean test(String value) {
                        return value.length() >= 3;
                    }
                });
                System.out.println("Результат (строки >= 3 символов): " + filteredStrings);
                
                // Альтернативная запись с лямбдой
                List<String> filteredStringsLambda = filter(strings1, s -> s.length() >= 3);
                System.out.println("Результат (лямбда): " + filteredStringsLambda);
                
                // 2. Фильтрация чисел: оставить только положительные
                System.out.println("\n2. Фильтрация чисел (положительные):");
                List<Integer> numbers1 = Arrays.asList(1, -3, 7, -5, 0, 10, -2);
                System.out.println("Исходный список: " + numbers1);
                
                List<Integer> positiveNumbers = filter(numbers1, new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer value) {
                        return value > 0;
                    }
                });
                System.out.println("Результат (положительные числа): " + positiveNumbers);
                
                // Альтернативная запись с лямбдой
                List<Integer> positiveNumbersLambda = filter(numbers1, n -> n > 0);
                System.out.println("Результат (лямбда): " + positiveNumbersLambda);
                
                // 3. Фильтрация массивов: оставить только массивы без положительных элементов
                System.out.println("\n3. Фильтрация массивов (без положительных элементов):");
                List<int[]> arrays1 = Arrays.asList(
                    new int[]{-1, -5, -3},      // нет положительных
                    new int[]{-2, 8, 0},        // есть положительный (8)
                    new int[]{-10, -5, -7},     // нет положительных
                    new int[]{0, -1, 2},        // есть положительный (2)
                    new int[]{-3, -2, -1}       // нет положительных
                );
                
                // Выводим исходные массивы
                System.out.print("Исходные массивы: ");
                for (int[] arr : arrays1) {
                    System.out.print(Arrays.toString(arr) + " ");
                }
                System.out.println();
                
                List<int[]> arraysWithoutPositives = filter(arrays1, new Predicate<int[]>() {
                    @Override
                    public boolean test(int[] array) {
                        for (int num : array) {
                            if (num > 0) {
                                return false;
                            }
                        }
                        return true; 
                    }
                });
                
                System.out.print("Массивы без положительных элементов: ");
                for (int[] arr : arraysWithoutPositives) {
                    System.out.print(Arrays.toString(arr) + " ");
                }
                System.out.println();
                
                // Альтернативная запись с лямбдой
                List<int[]> arraysWithoutPositivesLambda = filter(arrays1, arr -> {
                    for (int num : arr) {
                        if (num > 0) return false;
                    }
                    return true;
                });
                System.out.print("Результат (лямбда): ");
                for (int[] arr : arraysWithoutPositivesLambda) {
                    System.out.print(Arrays.toString(arr) + " ");
                }
                System.out.println();
                
                // ДОПОЛНИТЕЛЬНЫЕ ПРИМЕРЫ
                System.out.println("\n=== ДОПОЛНИТЕЛЬНЫЕ ПРИМЕРЫ ===");
                
                // 4. Фильтрация четных чисел
                System.out.println("\n4. Фильтрация четных чисел:");
                List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
                List<Integer> evenNumbers = filter(numbers2, n -> n % 2 == 0);
                System.out.println("Исходный список: " + numbers2);
                System.out.println("Четные числа: " + evenNumbers);
                
                // 5. Фильтрация строк, начинающихся с определенной буквы
                System.out.println("\n5. Фильтрация строк (начинаются на 'a'):");
                List<String> words1 = Arrays.asList("apple", "banana", "apricot", "cherry", "avocado");
                List<String> wordsStartingWithA = filter(words1, s -> s.startsWith("a"));
                System.out.println("Исходный список: " + words1);
                System.out.println("Слова на 'a': " + wordsStartingWithA);
                
                // 6. Фильтрация непустых строк
                System.out.println("\n6. Фильтрация непустых строк:");
                List<String> mixedStrings = Arrays.asList("hello", "", "world", "", "java", "");
                List<String> nonEmptyStrings = filter(mixedStrings, s -> !s.isEmpty());
                System.out.println("Исходный список: " + mixedStrings);
                System.out.println("Непустые строки: " + nonEmptyStrings);    
                break;
            default:
                System.out.println("Нет такой темы!");
        }
        scanner.close();
    }

    // Метод для обработки коробки с целыми числами
    public static void processIntegerBox(Box<Integer> box) {
        System.out.println("В методе processIntegerBox:");
        System.out.println("Получена коробка: " + box);

        if (box.isFull()) {
            Integer value = box.get();
            System.out.println("Извлеченное значение: " + value);
            System.out.println("Значение умноженное на 2: " + (value * 2));
        }
    }

    public static void processIntegerStorage(Storage<Integer> storage) {
        System.out.println("В методе processIntegerStorage:");
        System.out.println("Исходное значение: " + storage.getOriginal());
        System.out.println("Хранится null? " + storage.isNull());

        Integer value = storage.get();
        System.out.println("Полученное значение: " + value);
        System.out.println("Значение + 10: " + (value + 10));
    }

    // Метод для работы с хранилищем строк
    public static void processStringStorage(Storage<String> storage) {
        System.out.println("В методе processStringStorage:");
        System.out.println("Исходное значение: " + storage.getOriginal());
        System.out.println("Хранится null? " + storage.isNull());

        String value = storage.get();
        System.out.println("Полученное значение: " + value);
        System.out.println("Длина строки: " + value.length());
        System.out.println("В верхнем регистре: " + value.toUpperCase());
    }

    // Метод для работы с хранилищем объектов
    public static void processPersonStorage(Storage<Person> storage) {
        System.out.println("В методе processPersonStorage:");
        System.out.println("Исходное значение: " + storage.getOriginal());
        System.out.println("Хранится null? " + storage.isNull());

        Person person = storage.get();
        System.out.println("Полученный объект: " + person);
    }

    static class Person {
        private String name;
        private int age;
        
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return String.format("Person{name='%s', age=%d}", name, age);
        }
    }

        
    /**
     * Метод, который принимает коробку с маской типа и помещает в нее Point3D
     * Используется маска <? super Point3D> - позволяет принимать коробки,
     * которые могут хранить Point3D или его супертипы
     */
    public static void fillBoxWithPoint(BoxNew<? super Point3D> boxnew) {
        // Создаем точку с произвольными значениями
        Point3D point = new Point3D(
            Math.random() * 10,  // x от 0 до 10
            Math.random() * 10,  // y от 0 до 10  
            Math.random() * 10   // z от 0 до 10
        );
        
        System.out.println("Создана точка: " + point);
        
        // Помещаем точку в коробку
        // Безопасно, так как коробка может хранить Point3D или его супертипы
        boxnew.put(point);
    }
    
    /**
     * Альтернативная версия с более строгим ограничением
     * Может принимать только коробки, предназначенные для Point3D или его суперклассов
     */
    public static void fillBoxWithPointLimited(BoxNew<? super Point3D> boxnew) {
        Point3D point = new Point3D(1.5, 2.5, 3.5);
        System.out.println("Помещаем точку в коробку: " + point);
        boxnew.put(point);
    }
    
    /**
     * Метод для демонстрации противоположной маски - <? extends Point3D>
     * Может принимать коробки, которые хранят Point3D или его подтипы
     * Но не позволяет добавлять элементы (только читать)
     */
    public static void printPointFromBox(BoxNew<? extends Point3D> boxnew) {
        if (boxnew.isFull()) {
            Point3D point = boxnew.peek(); // Можно читать
            System.out.println("Точка из коробки: " + point);
            // box.put(new Point3D()); // Ошибка компиляции - нельзя добавлять
        } else {
            System.out.println("Коробка пуста");
        }
    }

    public static <T, P> List<P> map(List<T> list, Function<T, P> function) {
    List<P> result = new ArrayList<>();
    for (T item : list) {
        result.add(function.apply(item));
    }
    return result;
}

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

}





