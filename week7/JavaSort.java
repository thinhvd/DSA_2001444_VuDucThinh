package week7;

import java.util.*;

public class JavaSort {
    public static class Student{
        private int id;
        private String fname;
        private double cgpa;
        public Student(int id, String fname, double cgpa) {
            super();
            this.id = id;
            this.fname = fname;
            this.cgpa = cgpa;
        }
        public int getId() {
            return id;
        }
        public String getFname() {
            return fname;
        }
        public double getCgpa() {
            return cgpa;
        }
    }

    public static class StudentComparator implements Comparator<Student>
    {
        @Override
        public int compare(Student x, Student y)
        {
            //Complete your code
            if (x.getCgpa() == y.getCgpa()) {
                if(x.getFname().compareTo(y.getFname()) == 0) {
                    return x.getId() - y.getId();
                } else {
                    return x.getFname().compareTo(y.getFname());
                }
            } else if (x.getCgpa() > y.getCgpa()) {return -1;}
            else return 1;
        }
    }

    //Complete the code
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int testCases = Integer.parseInt(in.nextLine());

            List<Student> studentList = new ArrayList<Student>();
            while(testCases>0){
                int id = in.nextInt();
                String fname = in.next();
                double cgpa = in.nextDouble();

                Student st = new Student(id, fname, cgpa);
                studentList.add(st);

                testCases--;
            }
            Collections.sort(studentList, new StudentComparator());
            for(Student st: studentList){
                System.out.println(st.getFname());
            }
        }
}
