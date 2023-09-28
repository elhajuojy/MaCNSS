package ma.yc.GUI;

import ma.yc.core.Print;
import ma.yc.service.EmployeeService;

import java.util.Scanner;

public class MainEmployeeGUI implements DisplayGUI{

    private EmployeeService employeeService;
    @Override
    public int displayMainOptions(Scanner scanner) {
        Print.log("=== Employee  OPERATION  ===");
        return 0;
    }
}
