import java.util.*;

// Практика 1 - аннотации @Override, @Deprecated, @SuppressWarnings

class Parent {
    public void display() {
        System.out.println("Метод родительского класса");
    }
    
    public void oldMethod() {
        System.out.println("Старый метод");
    }
}

class Child extends Parent {
    // 1. Аннотация @Override - указывает, что метод переопределяет родительский
    @Override
    public void display() {
        System.out.println("Переопределенный метод дочернего класса");
    }
    
    // Без @Override компилятор не заметит опечатку - создаст новый метод
    public void displaY() { // Опечатка в имени метода!
        System.out.println("Это новый метод, а не переопределение");
    }
    
    // 2. Аннотация @Deprecated - помечает устаревший метод
    @Deprecated
    public void legacyMethod() {
        System.out.println("Этот метод устарел и будет удален в будущих версиях");
    }
    
    @Deprecated(since = "2.0", forRemoval = true)
    public void veryOldMethod() {
        System.out.println("Этот метод будет удален в следующей версии");
    }
    
    // Новый метод вместо устаревшего
    public void newMethod() {
        System.out.println("Новый улучшенный метод");
    }
}

public class AnnotationsDemo {
    // 3. Аннотация @SuppressWarnings - отключает предупреждения компилятора
    @SuppressWarnings("unchecked")
    public static void createRawList() {
        // Без @SuppressWarnings компилятор выдаст предупреждение о raw types
        List rawList = new ArrayList(); // Предупреждение: unchecked conversion
        rawList.add("test");
    }
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void createMultipleWarnings() {
        List list = new ArrayList(); // Несколько предупреждений
        list.add("item");
    }
    
    @SuppressWarnings("deprecation")
    public static void useDeprecatedMethod() {
        Child child = new Child();
        child.legacyMethod(); // Предупреждение: использование устаревшего метода
    }
    
    public static void main(String[] args) {
        System.out.println("=== Аннотация @Override ===");
        Child child = new Child();
        child.display();    // Переопределенный метод
        child.displaY();    // Новый метод (ошибка в имени не обнаружена)
        
        System.out.println("\n=== Аннотация @Deprecated ===");
        // При использовании устаревшего метода компилятор выдает предупреждение
        child.legacyMethod();    // Предупреждение: метод устарел
        child.veryOldMethod();   // Предупреждение: метод будет удален
        child.newMethod();       // Без предупреждений
        
        System.out.println("\n=== Аннотация @SuppressWarnings ===");
        createRawList();              // Предупреждения подавлены
        createMultipleWarnings();     // Несколько предупреждений подавлены
        useDeprecatedMethod();        // Предупреждение об устаревшем методе подавлено
        
        // Без @SuppressWarnings - компилятор выдаст предупреждения
        List rawList = new ArrayList(); // Предупреждение: unchecked conversion
        rawList.add("test");
        
        Child child2 = new Child();
        child2.legacyMethod(); // Предупреждение: использование устаревшего метода
    }
}

/*
ОБЪЯСНЕНИЕ АННОТАЦИЙ:

1. @Override - переопределение метода:
   - НАЗНАЧЕНИЕ: Указывает, что метод переопределяет метод суперкласса
   - ПРЕИМУЩЕСТВА: 
     * Помогает обнаружить опечатки в имени метода
     * Делает код более читаемым
     * Обеспечивает проверку компилятором
   - ПРИМЕР: @Override public void display() {...}

2. @Deprecated - устаревший код:
   - НАЗНАЧЕНИЕ: Помечает метод/класс как устаревший
   - ПРЕИМУЩЕСТВА:
     * Предупреждает разработчиков об устаревшем API
     * Позволяет плавно обновлять код
     * Может содержать информацию о версии (since, forRemoval)
   - ПРИМЕР: @Deprecated(since="2.0", forRemoval=true)

3. @SuppressWarnings - подавление предупреждений:
   - НАЗНАЧЕНИЕ: Отключает конкретные предупреждения компилятора
   - ПРЕИМУЩЕСТВА:
     * Позволяет временно игнорировать предупреждения
     * Полезно для legacy-кода или миграции
   - ЧАСТО ИСПОЛЬЗУЕМЫЕ ЗНАЧЕНИЯ:
     * "unchecked" - сырые типы (raw types)
     * "deprecation" - использование устаревших методов
     * "rawtypes" - сырые типы в generics
     * "unused" - неиспользуемый код

ВАЖНЫЕ ЗАМЕЧАНИЯ:
- Аннотации предоставляют метаинформацию для компилятора и инструментов
- @Override следует использовать ВСЕГДА при переопределении методов
- @Deprecated помогает в управлении жизненным циклом API
- @SuppressWarnings следует использовать ОСТОРОЖНО и только когда необходимо
*/
