package core.java;

import java.util.*;

public class Student {
    public static void main(String[] args) {

        StudentInfo dto1  = new StudentInfo("ravi","khandelwal",258350);
        StudentInfo dto2  = new StudentInfo("toni","khandelwal",258351);
        StudentInfo dto3  = new StudentInfo("ravi","khandelwal",258350);

        System.out.println("dto1.equals(dto3) " + dto1.equals(dto3));
        System.out.println("dto1 " + dto1);
        System.out.println("dto3 " + dto3);

        List<StudentInfo> list = new ArrayList<>();
        list.add(dto1);
        list.add(dto2);
        list.add(dto3);

        System.out.println("list size " + list.size());

        list = new ArrayList<>();
        list.add(dto1);
        System.out.println("does dto3 exits " + list.contains(dto3));

        Set<StudentInfo> studentset = new HashSet<>();
        studentset.add(dto1);
        studentset.add(dto2);
        studentset.add(dto3);

        System.out.println("set size " + studentset.size());

    }
}

class StudentInfo {

    private final String fname;
    private final String lname;
    private final int id;

    public StudentInfo(String fname, String lname, int id) {
        this.fname = fname;
        this.lname = lname;
        this.id = id;
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentInfo that = (StudentInfo) o;
        return id == that.id && fname.equals(that.fname) && lname.equals(that.lname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fname, lname, id);
    }
}
