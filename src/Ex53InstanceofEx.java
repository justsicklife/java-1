class Person {}
class Studnet extends Person{}
class Researcher extends Person {}
class Professor extends Researcher {}

public class Ex53InstanceofEx {
    
    static void print(Person p) {
        if(p instanceof Person) {
            System.out.println("Person");
        }
        if(p instanceof Studnet) {
            System.out.println("Studnet");
        }
        if(p instanceof Researcher) {
            System.out.println("Researcher");
        }
        if(p instanceof Professor) {
            System.out.println("Professor");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("new Student() -> ");
        print(new Studnet());
        System.out.println("new Researcher() -> ");
        print(new Researcher());
        System.out.println("new Professer() ->");
        print(new Professor());
    }
}
