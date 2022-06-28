package sky.pro.teck_meeting.service;

import sky.pro.teck_meeting.model.*;
import org.springframework.stereotype.Service;
import sky.pro.teck_meeting.repository.EmployeeRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void init() {
        List<ITest> employees = employeeRepository.getMaxSalary();
        for (ITest item: employees) {
        System.out.printf("\n*** Dep = %d, Sel_Max = %f",
                item.getDepartment(), item.getSalary());
    }
        System.out.println();

        employees = employeeRepository.getAverageSalary();
        for (ITest item: employees) {
            System.out.printf("\n*** Dep = %d, Sel_Avg = %f",
                    item.getDepartment(), item.getSalary());
        }
        System.out.println();
}
}
