package medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
	
	public static void main(String[] args) {
	}
	
	public static int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee employee : employees) {
			map.put(employee.id, employee);
		}
		return dfs(map, id);
	}
	
	private static int dfs(Map<Integer, Employee> map, int id) {
		Employee employee = map.get(id);
		int importance = employee.importance;
		for (Integer subordinate : employee.subordinates) {
			importance += dfs(map, subordinate);
		}
		return importance;
	}
	
	class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
	}
}
