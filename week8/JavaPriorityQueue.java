package week8;

import java.util.*;

public class JavaPriorityQueue {
    class Student {
        private int id;
        private String name;
        private double cgpa;

        public Student (int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
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
                if(x.getName().compareTo(y.getName()) == 0) {
                    return x.getId() - y.getId();
                } else {
                    return x.getName().compareTo(y.getName());
                }
            } else if (x.getCgpa() > y.getCgpa()) {return -1;}
            else return 1;
        }
    }
    class Priorities {
        public List<Student> getStudents(List<String> events) {
            Comparator<Student> comparator = new StudentComparator();
            Queue<Student> pq = new PriorityQueue<>(comparator);
            List<Student> students = new ArrayList<>();
            for (int i = 0; i < events.size(); i++) {
                String[] e = events.get(i).split(" ");
                String info = e[0];
                if(e.equals("ENTER")) {
                    int id = Integer.parseInt(e[3]);
                    String name = e[1];
                    double cpga = Double.parseDouble(e[2]);
                    Student student = new Student(id, name, cpga);
                    pq.add(student);
                }
                else if (e.equals("SERVED")) {
                    students.add(pq.poll());
                }
            }

            return students;
        }
    }
}
