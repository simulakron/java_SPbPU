    import java.util.ArrayList;
import java.util.HashMap;

public class Practice8 {
    public static void main(String[] args) {
        // Type inference (вывод типов) - возможность компилятора автоматически
        // определять тип переменной на основе контекста без явного указания
        
        // 1. С базовыми типами
        var name = "Ульяна";           // компилятор выводит String
        var age = 19;                  // компилятор выводит int
        var height = 170.5;            // компилятор выводит double
        var isStudent = true;          // компилятор выводит boolean
        
        // 2. С коллекциями 
        var list = new ArrayList<String>();      // компилятор выводит ArrayList<String>
        var map = new HashMap<Integer, String>(); // компилятор выводит HashMap<Integer, String>
        
        // 3. С пользовательскими классами
        var person = new Person("Иван");         // компилятор выводит Person
        
        // 4. В циклах 
        list.add("Элемент 1");
        list.add("Элемент 2");
        for (var item : list) {                  // компилятор выводит String
            System.out.println(item);
        }
        
        // 5. С массивами
        var numbers = new int[]{1, 2, 3};        // компилятор выводит int[]
        
        // Демонстрация работы
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("list size: " + list.size());
        System.out.println("numbers length: " + numbers.length);
        System.out.println("person: " + person.getName());
    }
}

class Person {
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}