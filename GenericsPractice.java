import java.util.*;

// Практика #1 - instanceof с параметризованными классами
class Wrapper<T> {
    private T item;
    
    public Wrapper(T item) {
        this.item = item;
    }
    
    public T getItem() {
        return item;
    }
}

public class GenericsPractice {
    public static void main(String[] args) {
        // Практика #1 - instanceof с параметризованными классами
        System.out.println("=== Практика #1 - instanceof ===");
        
        Wrapper<String> stringWrapper = new Wrapper<>("Test");
        Wrapper<Integer> intWrapper = new Wrapper<>(100);
        
        // Пример 1: Проверка самого generic-контейнера
        // Результат: true - потому что stringWrapper является объектом класса Wrapper (стирание типов)
        boolean isWrapper = stringWrapper instanceof Wrapper;
        System.out.println("stringWrapper instanceof Wrapper: " + isWrapper); // true
        
        // Пример 2: Проверка содержимого после извлечения
        // Результат: true - потому что getItem() возвращает String "Test"
        Object content = stringWrapper.getItem();
        boolean isString = content instanceof String;
        System.out.println("stringWrapper.getItem() instanceof String: " + isString); // true
        
        // Пример 3: Проверка с разными типами
        // Результат: true/false - intWrapper содержит Integer, а не String
        Object intContent = intWrapper.getItem();
        System.out.println("intWrapper.getItem() instanceof Integer: " + (intContent instanceof Integer)); // true
        System.out.println("intWrapper.getItem() instanceof String: " + (intContent instanceof String)); // false
        
        // Практика #2 - extends и super в generics
        System.out.println("\n=== Практика #2 - extends и super ===");
        
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
        List<Number> numbers = new ArrayList<>();
        
        // <? extends Number> - для чтения
        // Результат: 6.0 и 6.6 - метод sumNumbers может работать с любыми списками чисел
        System.out.println("Сумма integers: " + sumNumbers(integers)); // 6.0
        System.out.println("Сумма doubles: " + sumNumbers(doubles));   // 6.6
        
        // <? super Integer> - для записи
        // Результат: [10, 20] - метод addNumbers может добавлять Integer в списки Number
        addNumbers(numbers, 10);
        addNumbers(numbers, 20);
        System.out.println("Numbers после добавления: " + numbers); // [10, 20]
    }
    
    // <? extends Number> - принимает любые списки чисел (Integer, Double, etc.)
    // ЗАЧЕМ НУЖЕН: для безопасного чтения из коллекций разных числовых типов
    // ОБЪЯСНЕНИЕ: позволяет работать с List<Integer>, List<Double> и другими наследниками Number
    // как с единым типом для операций чтения
    public static double sumNumbers(List<? extends Number> numbers) {
        double sum = 0;
        for (Number num : numbers) {
            sum += num.doubleValue(); // Безопасно - все элементы являются Number
        }
        return sum;
    }
    
    // <? super Integer> - принимает списки, которые могут содержать Integer
    // ЗАЧЕМ НУЖЕН: для безопасной записи Integer в различные коллекции
    // ОБЪЯСНЕНИЕ: позволяет добавлять Integer в List<Integer>, List<Number>, List<Object>
    // так как все они могут содержать целые числа
    public static void addNumbers(List<? super Integer> list, Integer value) {
        list.add(value); // Безопасно - можно добавить Integer в List<Integer>, List<Number>, List<Object>
    }
}

/*
ОБЪЯСНЕНИЕ РЕЗУЛЬТАТОВ:

ПРАКТИКА #1 - instanceof:
- Из-за стирания типов (type erasure) в Java generics, во время выполнения 
  информация о параметрах типа теряется
- Поэтому нельзя проверить Wrapper<String> instanceof Wrapper<String>
- Но можно проверить Wrapper instanceof Wrapper (без параметров)
- И можно проверить содержимое после извлечения из контейнера

ПРАКТИКА #2 - extends и super:
- <? extends T> (Upper bounded wildcard) - используется когда нужно ЧИТАТЬ данные
  из коллекции. Гарантирует, что все элементы являются T или его наследниками.

- <? super T> (Lower bounded wildcard) - используется когда нужно ЗАПИСЫВАТЬ данные
  в коллекцию. Гарантирует, что коллекция может принимать элементы типа T.

PECS принцип (Producer-Extends, Consumer-Super):
- Producer (источник данных) → используем extends
- Consumer (приемник данных) → используем super
*/