package lecture09.serial;

import java.io.Serializable;

public class Student implements Serializable {
    public static final long serialVersionUID = 1L; // Java 9

    private int id;
    private String name;
    private float gpa;
    public Student(int id, String name, float gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return String.format("id: %d\nname: %s\ngpa: %.2f\n", id, name, gpa);
    }
    
}
