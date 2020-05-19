package algorithm.baekjoon.stepwise.sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class _10825_KoreanEnglishMathmatics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split(" ");
            Student student = new Student(strArr[0], Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2]), Integer.parseInt(strArr[3]));
            students[i] = student;
        }
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < students.length; i++) {
            sb.append(students[i].name).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int mathmatics;
        public Student(String name, int korean, int english, int mathmatics){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.mathmatics = mathmatics;
        }

        @Override
        public int compareTo(Student o) {
            if(this.korean > o.korean){
                return -1;
            }else if(this.korean == o.korean){
                if(this.english < o.english){
                    return -1;
                }else if(this.english == o.english){
                    if(this.mathmatics > o.mathmatics){
                        return -1;
                    }else if(this.mathmatics == o.mathmatics){
                        return this.name.compareTo(o.name);
                    }else{
                        return 1;
                    }
                }else{
                    return 1;
                }
            }else{
                return 1;
            }
        }
    }
}
