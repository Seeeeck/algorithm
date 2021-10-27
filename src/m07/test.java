package m07;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        List<Student> students = initStudents(args[1]);
        if ("dropouts".equals(args[0])){
            dropouts(students);
        }else if ("top-vs-bottom".equals(args[0])){
            topVsBottom(students);
        }
    }
    public static List<Student> initStudents(String fileName) {
        List<Student> studentList = new ArrayList<>();
        File file = new File(fileName);
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            int num = 0;
            while ((line=br.readLine()) != null){
                num++;
                if (num > 1){
                    studentList.add(parseStudent(line));
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return studentList;
    }

    private static Student parseStudent(String line){
        String[] strings = line.split(",");
        String id = strings[0];
        List<Integer> scoreList = Arrays.stream(Arrays.copyOfRange(strings, 1, strings.length))
                .map(Integer::parseInt).collect(Collectors.toList());
        return new Student(id,scoreList);

    }

    public static void dropouts(List<Student> students){
        System.out.println("ID");
        ArrayList<Student> dropoutStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getDropoutCount() >= 2){
                dropoutStudents.add(student);
            }
        }
        if (!dropoutStudents.isEmpty()){
            Collections.sort(dropoutStudents);
            for (Student dropoutStudent : dropoutStudents) {
                System.out.println(dropoutStudent.getId());
            }
        }

    }

    public static void topVsBottom(List<Student> students){
        System.out.println("ID,Mean");
        double maxScore = 0;
        double minScore = 100;
        for (Student student : students) {
            if (student.getMean() > maxScore){
                maxScore = student.getMean();
            }
            if (student.getMean() < minScore){
                minScore = student.getMean();
            }
        }
        ArrayList<Student> maxScoreStudents = new ArrayList<>();
        ArrayList<Student> minScoreStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getMean()==maxScore){
                maxScoreStudents.add(student);
            }else if (student.getMean()==minScore){
                minScoreStudents.add(student);
            }
        }
        if (maxScoreStudents.size() > 1){
            Collections.sort(maxScoreStudents);
        }
        if (minScoreStudents.size() > 1){
            Collections.sort(minScoreStudents);
        }
        for (Student minScoreStudent : minScoreStudents) {
            System.out.println(minScoreStudent.getId()+","+minScoreStudent.getMeanStr());
        }
        for (Student maxScoreStudent : maxScoreStudents) {
            System.out.println(maxScoreStudent.getId()+","+maxScoreStudent.getMeanStr());
        }

    }


    private static class Student implements Comparable<Student>{
        private String id;
        private List<Integer> scoreList;
        private int dropoutCount;
        private double mean;
        private String meanStr;

        public Student(String id, List<Integer> scoreList) {
            this.id = id;
            this.scoreList = scoreList;
            checkDropout();
            calculateMean();
        }

        private void checkDropout(){
            this.dropoutCount = 0;
            for (int score : scoreList) {
                if (score <= 49){
                    dropoutCount++;
                }
            }
        }

        private void calculateMean(){
            int sum = 0;
            for (int score : scoreList) {
                sum += score;
            }
            double v = sum * 1.0 / scoreList.size();
            this.mean = new BigDecimal(v).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
            this.meanStr = String.format("%.2f",this.mean);
        }

        public String getId() {
            return id;
        }

        public int getDropoutCount() {
            return dropoutCount;
        }

        public double getMean() {
            return mean;
        }

        public String getMeanStr() {
            return meanStr;
        }

        @Override
        public int compareTo(Student o) {
            return this.getId().compareTo(o.getId());
        }
    }
}
