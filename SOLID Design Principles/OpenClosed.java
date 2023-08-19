/*
 * Instead of using If else to implement Calculate bonus for employees we can separate their implementation 
 * using Abstract class and method. Thus making it easy to modify and test and not modifying the existing 
 * employee code.
 */

//Abstract base class
abstract class Employee {
    public int id;
    public String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }

    public abstract double CalculateBonus(double salary) ;
}

//derived class

class PermanentEmployee extends Employee{

    public PermanentEmployee(int id, String name) {
        super(id, name);
    }

    @Override
    public double CalculateBonus(double salary) {
        return salary*0.1;
    }
}

class TemporaryEmployee extends Employee{

    public TemporaryEmployee(int id, String name) {
        super(id, name);
    }

    @Override
    public double CalculateBonus(double salary) {
        return salary*0.07;
    }
    
}

public class OpenClosed {
    public static void main(String[] args) {
        Employee empJohn = new PermanentEmployee(1, "John");
        Employee empJason = new TemporaryEmployee(2, "Jason");
        System.out.println(empJohn.toString()+" "+empJohn.CalculateBonus(100000));
        System.out.println(empJason.toString()+" "+empJason.CalculateBonus(100000));
    }
}
