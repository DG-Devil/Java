
//This program follows the SRP & OCP principles

public class AssignmentOne {
    public static void main(String[] args) {

        Employee m = new Employee("⋄Baburao Ganpatrao Apte⋄", 100000);


        PaySlipPrinter printer = new StandardPrinter();
        printer.printPaySlip(m);

         EmployeeDatabaseSaver save = new DefaultEmployeeDatabaseSaver();
        save.saveToDatabase(m);
    }
    
    static class Employee {     //Created this class so that the program does not violate SRP principle
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

    interface PaySlipPrinter {                  //OCP Principle
    void printPaySlip(Employee employee);
   }
    
    static class StandardPrinter implements PaySlipPrinter{     //It implements above interface thus it can use its function
      public void printPaySlip(Employee employee) {
          System.out.println("Employee: " + employee.getName() + ", Salary: $" + employee.getSalary());
      }
  }

    interface EmployeeDatabaseSaver {           //This is another interface (follows OCP principle)
    void saveToDatabase(Employee employee);
    }
    static class DefaultEmployeeDatabaseSaver implements EmployeeDatabaseSaver{
    public void saveToDatabase(Employee employee) {
        System.out.println("Saving employee " + employee.getName() + " to the database...");
      }
  }
}

