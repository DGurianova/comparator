import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DemoOne {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee employeeOne = new Employee(11, "Maria", "Ivanova", 12000);
        Employee employeeTwo = new Employee(25, "Anna", "Nikolaeva", 14000);
        Employee employeeThree = new Employee(3, "Alex", "Ivanov", 16000);
        Employee employeeFour = new Employee(4, "Olga", "Alexandrova", 10700);

        list.add(employeeOne);
        list.add(employeeTwo);
        list.add(employeeThree);
        list.add(employeeFour);

        System.out.println("Before sorting \n" + list);
        Collections.sort(list, new SalaryComparator());
        System.out.println("After sorting \n" + list);
    }

    static class Employee {
        int id;
        String name;
        String surname;
        int salary;

        public Employee(int id, String name, String surname, int salary) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }

    static class IdComparator implements Comparator<Employee> { //// zum Vergleich von Objekten anhang der nicht natürlichen Ordnung
        @Override
        public int compare(Employee employeeOne, Employee employeeTwo) {
            if (employeeOne.id == employeeTwo.id) {
                return 0;
            }
            if (employeeOne.id < employeeTwo.id) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    static class NameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee employeeOne, Employee employeeTwo) {
            return employeeOne.name.compareToIgnoreCase(employeeTwo.name);
        }
    }

    static class SalaryComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee employeeOne, Employee employeeTwo) {
            return employeeOne.salary - employeeTwo.salary;
        }
    }
}
