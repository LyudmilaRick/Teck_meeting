package sky.pro.teck_meeting.repository;

import sky.pro.teck_meeting.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sky.pro.teck_meeting.model.Employee;

import java.util.List;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT department, MAX (salary) as salary, COUNT(*)  FROM employee "+
                   "GROUP BY department  HAVING COUNT(*)>1 ORDER BY department",
                   nativeQuery = true)
   List<ITest> getMaxSalary();

    @Query(value = "SELECT department, AVG(salary) as salary, COUNT(*)  FROM employee "+
            "GROUP BY department  HAVING COUNT(*)>1 ORDER BY department",
            nativeQuery = true)
    List<ITest> getAverageSalary();
}
