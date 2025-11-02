// Практика 1 - спецификаторы доступа для внутренних классов
class OuterClass {
    // public внутренний класс - доступен извне
    public class PublicInner {
        public void display() {
            System.out.println("PublicInner класс");
        }
    }
    
    // protected внутренний класс - доступен в пакете и наследникам
    protected class ProtectedInner {
        protected void display() {
            System.out.println("ProtectedInner класс");
        }
    }
    
    // default (package-private) внутренний класс - доступен только в пакете
    class DefaultInner {
        void display() {
            System.out.println("DefaultInner класс");
        }
    }
    
    // private внутренний класс - доступен только во внешнем классе
    private class PrivateInner {
        private void display() {
            System.out.println("PrivateInner класс");
        }
        
        public void show() {
            display(); // доступно внутри PrivateInner
        }
    }
    
    public void testInnerAccess() {
        // Доступ ко всем внутренним классам из внешнего класса
        PublicInner pub = new PublicInner();
        ProtectedInner prot = new ProtectedInner();
        DefaultInner def = new DefaultInner();
        PrivateInner priv = new PrivateInner();
        
        pub.display();
        prot.display();
        def.display();
        priv.show(); // доступ через public метод
    }
}

// Практика 2 - доступ внутреннего класса к внешнему
class OuterWithFields {
    private String privateField = "private поле";
    protected String protectedField = "protected поле";
    String defaultField = "default поле";
    public String publicField = "public поле";
    
    private void privateMethod() {
        System.out.println("private метод внешнего класса");
    }
    
    protected void protectedMethod() {
        System.out.println("protected метод внешнего класса");
    }
    
    void defaultMethod() {
        System.out.println("default метод внешнего класса");
    }
    
    public void publicMethod() {
        System.out.println("public метод внешнего класса");
    }
    
    // Внутренний класс
    public class InnerClass {
        public void accessOuterMembers() {
            // Внутренний класс имеет доступ ко ВСЕМ полям и методам внешнего класса
            System.out.println("Доступ из InnerClass:");
            System.out.println("privateField: " + privateField);
            System.out.println("protectedField: " + protectedField);
            System.out.println("defaultField: " + defaultField);
            System.out.println("publicField: " + publicField);
            
            privateMethod();
            protectedMethod();
            defaultMethod();
            publicMethod();
        }
    }
}

// Практика 3 - доступ внешнего класса к внутреннему
class OuterAccessToInner {
    private String outerField = "поле внешнего класса";
    
    // Внутренний класс с разными спецификаторами доступа
    public class PublicInner {
        private String privateInnerField = "private поле PublicInner";
        public String publicInnerField = "public поле PublicInner";
        
        private void privateInnerMethod() {
            System.out.println("private метод PublicInner");
        }
        
        public void publicInnerMethod() {
            System.out.println("public метод PublicInner");
        }
    }
    
    private class PrivateInner {
        private String privateField = "private поле PrivateInner";
        public String publicField = "public поле PrivateInner";
        
        public void display() {
            System.out.println("PrivateInner: " + privateField);
        }
    }
    
    public void testAccessToInner() {
        System.out.println("Доступ из OuterAccessToInner:");
        
        // Создание объектов внутренних классов
        PublicInner pubInner = new PublicInner();
        PrivateInner privInner = new PrivateInner();
        
        // Доступ к public членам внутренних классов
        System.out.println("pubInner.publicInnerField: " + pubInner.publicInnerField);
        pubInner.publicInnerMethod();
        
        // Доступ к private членам внутренних классов - ОШИБКА КОМПИЛЯЦИИ
        // System.out.println(pubInner.privateInnerField); // ОШИБКА!
        // pubInner.privateInnerMethod(); // ОШИБКА!
        
        // Доступ к private внутреннему классу - возможен только внутри внешнего класса
        System.out.println("privInner.publicField: " + privInner.publicField);
        privInner.display();
    }
}

public class InnerClassesExample {
    public static void main(String[] args) {
        System.out.println("=== Практика 1 - спецификаторы доступа ===");
        OuterClass outer = new OuterClass();
        outer.testInnerAccess();
        
        // Создание внутренних классов извне
        OuterClass.PublicInner pub = outer.new PublicInner(); // public - доступно
        pub.display();
        
        OuterClass.ProtectedInner prot = outer.new ProtectedInner(); // protected - доступно в пакете
        prot.display();
        
        OuterClass.DefaultInner def = outer.new DefaultInner(); // default - доступно в пакете
        def.display();
        
        // OuterClass.PrivateInner priv = outer.new PrivateInner(); // ОШИБКА - private недоступно
        
        System.out.println("\n=== Практика 2 - доступ внутреннего к внешнему ===");
        OuterWithFields outerWithFields = new OuterWithFields();
        OuterWithFields.InnerClass inner = outerWithFields.new InnerClass();
        inner.accessOuterMembers();
        
        System.out.println("\n=== Практика 3 - доступ внешнего к внутреннему ===");
        OuterAccessToInner outerAccess = new OuterAccessToInner();
        outerAccess.testAccessToInner();
    }
}

/*
ОБЪЯСНЕНИЕ РЕЗУЛЬТАТОВ:

ПРАКТИКА 1 - спецификаторы доступа внутренних классов:
- public: доступен отовсюду (OuterClass.PublicInner)
- protected: доступен в пакете и наследникам OuterClass
- default: доступен только в том же пакете
- private: доступен только внутри OuterClass

ПРАКТИКА 2 - доступ внутреннего класса к внешнему:
- Внутренний класс имеет доступ ко ВСЕМ (включая private) полям и методам внешнего класса
- Каждый объект внутреннего класса неявно содержит ссылку на создавший его объект внешнего класса
- Это позволяет внутреннему классу работать с состоянием внешнего класса

ПРАКТИКА 3 - доступ внешнего класса к внутреннему:
- Внешний класс имеет доступ только к public членам внутреннего класса
- Доступ к private членам внутреннего класса запрещен, даже из внешнего класса
- Внешний класс может создавать объекты всех своих внутренних классов (включая private)
- Спецификаторы доступа работают одинаково для внутренних и обычных классов
*/
