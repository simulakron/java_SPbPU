// Практика 1 - interface без спецификатора
interface MyPackagePrivateInterface {
    // Область видимости: только в том же пакете
    void method();
}

// Практика 2 - public interface
interface MyPublicInterface {
    // Область видимости: везде (из любого пакета)
    void publicMethod();
}

// Демонстрация корректных областей видимости
class PackagePrivateImpl implements MyPackagePrivateInterface {
    @Override
    public void method() {
        System.out.println("Реализация package-private интерфейса");
    }
}

class PublicImpl implements MyPublicInterface {
    @Override
    public void publicMethod() {
        System.out.println("Реализация public интерфейса");
    }
}

// Вложенные интерфейсы с разными спецификаторами доступа
class OuterClass {
    // public вложенный интерфейс - доступен везде
    public interface MyPublicNestedInterface {
        void publicNestedMethod();
    }
    
    // protected вложенный интерфейс - доступен в пакете и наследникам
    protected interface MyProtectedNestedInterface {
        void protectedNestedMethod();
    }
    
    // default вложенный интерфейс - доступен в пакете
    interface MyPackagePrivateNestedInterface {
        void packagePrivateNestedMethod();
    }
    
    // private вложенный интерфейс - доступен только в OuterClass
    private interface MyPrivateNestedInterface {
        void privateNestedMethod();
    }
    
    // Реализация private интерфейса внутри внешнего класса
    private class PrivateImpl implements MyPrivateNestedInterface {
        @Override
        public void privateNestedMethod() {
            System.out.println("Реализация private вложенного интерфейса");
        }
    }
    
    public void testPrivateInterface() {
        PrivateImpl priv = new PrivateImpl();
        priv.privateNestedMethod();
    }
}

public class InterfaceVisibilityDemo {
    public static void main(String[] args) {
        System.out.println("=== Практика 1-4 - Области видимости интерфейсов ===");
        
        // Практика 1: default/package-private интерфейс
        PackagePrivateImpl ppImpl = new PackagePrivateImpl();
        ppImpl.method();
        
        // Практика 2: public интерфейс
        PublicImpl pubImpl = new PublicImpl();
        pubImpl.publicMethod();
        
        System.out.println("\nПрактика 3: protected интерфейс - НЕВОЗМОЖЕН для топ-левел");
        System.out.println("Практика 4: private интерфейс - НЕВОЗМОЖЕН для топ-левел");
        
        System.out.println("\n=== Вложенные интерфейсы с разными спецификаторами ===");
        
        // public вложенный интерфейс
        class PublicNestedImpl implements OuterClass.MyPublicNestedInterface {
            @Override
            public void publicNestedMethod() {
                System.out.println("public вложенный интерфейс - доступен везде");
            }
        }
        
        // protected вложенный интерфейс - доступен в пакете
        class ProtectedNestedImpl implements OuterClass.MyProtectedNestedInterface {
            @Override
            public void protectedNestedMethod() {
                System.out.println("protected вложенный интерфейс - доступен в пакете");
            }
        }
        
        // default вложенный интерфейс - доступен в пакете
        class PackagePrivateNestedImpl implements OuterClass.MyPackagePrivateNestedInterface {
            @Override
            public void packagePrivateNestedMethod() {
                System.out.println("default вложенный интерфейс - доступен в пакете");
            }
        }
        
        PublicNestedImpl pubNested = new PublicNestedImpl();
        pubNested.publicNestedMethod();
        
        ProtectedNestedImpl protNested = new ProtectedNestedImpl();
        protNested.protectedNestedMethod();
        
        PackagePrivateNestedImpl ppNested = new PackagePrivateNestedImpl();
        ppNested.packagePrivateNestedMethod();
        
        // Тестирование private вложенного интерфейса
        OuterClass outer = new OuterClass();
        outer.testPrivateInterface();
    }
}

/*
ОБЪЯСНЕНИЕ РЕЗУЛЬТАТОВ:

ПРАКТИКА 1 - interface без спецификатора:
Область видимости: PACKAGE-PRIVATE (default)
- Доступен только классам в том же пакете
- MyPackagePrivateInterface может быть реализован только в этом пакете

ПРАКТИКА 2 - public interface:  
Область видимости: PUBLIC
- Доступен из любого пакета
- MyPublicInterface может быть реализован любым классом

ПРАКТИКА 3 - protected interface:
НЕДОПУСТИМ для топ-левел интерфейсов
- Ошибка компиляции: "modifier protected not allowed here"
- protected разрешен ТОЛЬКО для вложенных интерфейсов

ПРАКТИКА 4 - private interface:
НЕДОПУСТИМ для топ-левел интерфейсов
- Ошибка компиляции: "modifier private not allowed here"
- private разрешен ТОЛЬКО для вложенных интерфейсов

ВЛОЖЕННЫЕ ИНТЕРФЕЙСЫ:
Могут иметь все спецификаторы доступа:
- public (MyPublicNestedInterface) - доступен везде
- protected (MyProtectedNestedInterface) - в пакете + наследники OuterClass  
- default (MyPackagePrivateNestedInterface) - только в пакете
- private (MyPrivateNestedInterface) - только в OuterClass

ВЫВОД:
Топ-левел интерфейсы: только public или package-private
Вложенные интерфейсы: все спецификаторы доступа
*/
