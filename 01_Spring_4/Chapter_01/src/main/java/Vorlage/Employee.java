package Vorlage;

/**
 * Created by JAbanto on 10.05.2017.
 */
public class Employee {

    private int Id;
    private String nameStrg;
    private String lastNameStrg;
    private long salary;

    public Employee(){}

    public Employee(int id, String nameStrg, String lastNameStrg, long salary) {
        Id = id;
        this.nameStrg = nameStrg;
        this.lastNameStrg = lastNameStrg;
        this.salary = salary;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNameStrg() {
        return nameStrg;
    }

    public void setNameStrg(String nameStrg) {
        this.nameStrg = nameStrg;
    }

    public String getLastNameStrg() {
        return lastNameStrg;
    }

    public void setLastNameStrg(String lastNameStrg) {
        this.lastNameStrg = lastNameStrg;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
