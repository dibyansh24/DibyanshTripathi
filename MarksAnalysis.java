import java.util.*;

public class MarksAnalysis {
    static class Student {
        String name;
        int math, physics, chemistry, biology;
        public Student(String name, int math, int physics, int chemistry, int biology) {
            this.name = name;
            this.math = math;
            this.physics = physics;
            this.chemistry = chemistry;
            this.biology = biology;
        }
        public int total() { return math + physics + chemistry + biology; }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("101", 86, 79, 94, 91),
            new Student("102", 85, 88, 88, 90),
            new Student("103", 80, 82, 85, 94),
            new Student("104", 81, 88, 90, 89),
            new Student("105", 95, 98, 99, 94),
            new Student("106", 72, 78, 82, 80),
            new Student("107", 89, 92, 94, 91)
        );
        Map<String, String> topPerformers = new HashMap<>();
        topPerformers.put("Math", students.stream().max(Comparator.comparingInt(s -> s.math)).get().name);
        topPerformers.put("Physics", students.stream().max(Comparator.comparingInt(s -> s.physics)).get().name);
        topPerformers.put("Chemistry", students.stream().max(Comparator.comparingInt(s -> s.chemistry)).get().name);
        topPerformers.put("Biology", students.stream().max(Comparator.comparingInt(s -> s.biology)).get().name);
       
        System.out.println("Top Performers:");
        for (Map.Entry<String, String> e : topPerformers.entrySet())
            System.out.println(e.getKey() + ": " + e.getValue());

        students.sort((s1, s2) -> Integer.compare(s2.total(), s1.total()));
        System.out.println("\nStudents sorted by total marks:");
        for (Student s : students)
            System.out.println(s.name + ": " + s.total());
    }
}