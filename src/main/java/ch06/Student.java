package ch06;

public class Student {
    String name;
    int kor;
    int eng;
    int math;
    public Student(){
        //null, 0, 0, 0
        System.out.println(name+", "+kor+", "+eng+", "+math);
    }
    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        System.out.println(name+", "+kor+", "+eng+", "+math);
    }
    public double getAvg() {
        return (kor + eng + math) / 3.0;
    }
    public void printInfo() {
        System.out.println(name + "의 평균: " + getAvg());
    }

    public static void main(String[] args) {
    //보통은 디폴트 생성자 경우 없으면 자동으로 생성해줌
    //파라미터가 있는 생성자가 하나라도 있으면 자동생성이 안됨
        Student s = new Student();
        Student s1 = new Student("강감찬",80,70,90);
    }
}
