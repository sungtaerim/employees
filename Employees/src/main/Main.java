import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {

        Calendar dateAfter = new GregorianCalendar(year, Calendar.JANUARY , 01);
        Calendar dateBefore = new GregorianCalendar(year, Calendar.DECEMBER , 31);

        return staff.stream()
                .filter(e -> e.getWorkStart().after(dateAfter.getTime()))
                .filter(employee -> employee.getWorkStart().before(dateBefore.getTime()))
                .max(Comparator.comparing(Employee::getSalary)).get();
    }
}