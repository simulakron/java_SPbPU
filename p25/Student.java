import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private String studentId;
    
    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }
    
    // Переопределение метода equals()
    @Override
    public boolean equals(Object obj) {
        // 1. Проверка на ссылочное равенство (один и тот же объект)
        if (this == obj) {
            return true;
        }
        
        // 2. Проверка на null и совместимость типов
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        
        // 3. Приведение типа к Student
        Student other = (Student) obj;
        
        // 4. Сравнение полей, определяющих равенство
        // studentId - уникальный идентификатор студента
        return age == other.age && 
               Objects.equals(name, other.name) && 
               Objects.equals(studentId, other.studentId);
    }
    
    // Переопределение hashCode() в соответствии с equals()
    @Override
    public int hashCode() {
        return Objects.hash(name, age, studentId);
    }
    
    // Переопределение toString() для удобного вывода
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", studentId='" + studentId + "'}";
    }

    public static void main(String[] args) {
        Student student1 = new Student("Иван", 20, "S12345");
        Student student2 = new Student("Иван", 20, "S12345");
        Student student3 = new Student("Мария", 22, "S67890");
        Student student4 = student1;
        
        System.out.println("=== Тестирование метода equals() ===");
        System.out.println("student1: " + student1);
        System.out.println("student2: " + student2);
        System.out.println("student3: " + student3);
        
        System.out.println("\nstudent1.equals(student2): " + student1.equals(student2)); // true
        System.out.println("student1.equals(student3): " + student1.equals(student3)); // false
        System.out.println("student1.equals(student4): " + student1.equals(student4)); // true (та же ссылка)
        System.out.println("student1.equals(null): " + student1.equals(null));        // false
        System.out.println("student1.equals(\"строка\"): " + student1.equals("строка")); // false
        
        System.out.println("\n=== Тестирование hashCode() ===");
        System.out.println("student1.hashCode(): " + student1.hashCode());
        System.out.println("student2.hashCode(): " + student2.hashCode());
        System.out.println("student3.hashCode(): " + student3.hashCode());
        System.out.println("hashCode равны для равных объектов: " + 
                          (student1.hashCode() == student2.hashCode())); // true
    }
}

/*
СОГЛАШЕНИЯ ДЛЯ РЕАЛИЗАЦИИ equals():

1. РЕФЛЕКСИВНОСТЬ: x.equals(x) всегда true
2. СИММЕТРИЧНОСТЬ: если x.equals(y) = true, то y.equals(x) = true
3. ТРАНЗИТИВНОСТЬ: если x.equals(y) = true и y.equals(z) = true, то x.equals(z) = true
4. СОГЛАСОВАННОСТЬ: многократные вызовы x.equals(y) возвращают одинаковый результат
5. СРАВНЕНИЕ С NULL: x.equals(null) всегда false

ДОПОЛНИТЕЛЬНЫЕ ПРАВИЛА:

6. Всегда переопределять hashCode() вместе с equals()
7. Использовать @Override аннотацию
8. Сначала проверять ссылочное равенство (this == obj)
9. Проверять тип объекта (getClass() или instanceof)
10. Приводить тип после проверки
11. Сравнивать значимые поля (использовать Objects.equals() для null-safe сравнения)

В данном примере:
- Студенты равны, если совпадают name, age и studentId
- hashCode() вычисляется на основе тех же полей
- Все соглашения соблюдены
*/
