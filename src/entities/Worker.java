package entities;

import entities.enums.WorkerLevel;

import java.util.Calendar;
import java.util.List;

public class Worker {
    // atributos basicos de worker
    private String name;
    private WorkerLevel level;
    private double baseSalary;

    // associacoes
    private Department department;
    private List<HourContract> contracts;

    public Worker(){
    }

    public Worker(String name, WorkerLevel level, double baseSalary, Department deparment ) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = deparment;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }
    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public double income(int year, int month){
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts){
            cal.setTime(c.getDate());
            int c_month = 1 + cal.get(Calendar.MONTH);
            int c_year = cal.get(Calendar.YEAR);
            if(year == c_year && month == c_month) {
                sum += c.totalValue();
            }
        }
        return sum;
    }
}
