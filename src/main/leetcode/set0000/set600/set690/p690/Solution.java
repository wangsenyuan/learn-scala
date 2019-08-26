package set0000.set600.set690.p690;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap =
            employees.stream().collect(Collectors.toMap(emp -> emp.id, Function.identity()));


        return get(employeeMap, id);
    }

    public int get(Map<Integer, Employee> employeeMap, int id) {
        Employee employee = employeeMap.get(id);
        if (employee == null) {
            return 0;
        }
        return employee.importance + employee.subordinates.stream().map(sub -> get(employeeMap, sub))
            .reduce(0, (sum, x) -> sum + x);
    }
}


// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
