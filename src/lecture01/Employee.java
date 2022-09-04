package lecture01;

public class Employee  {
    public int id;
    protected String name = "<unknown>";
    Employee boss = null;

    public static int nextId = 0;

    public Employee() {
        id = nextId++;
    }
}
