package chapter6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 성적낮은순서로학생출력하기 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            students.add(new Student(str.split(" ")[0], Integer.parseInt(str.split(" ")[1])));
            System.out.println(students.get(i).getName() + " " + students.get(i).getScore());
        }

        Collections.sort(students);

        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getName() + " ");
        }

    }

}

class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if(this.score < o.score){
            return -1;
        }
        return 1;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
