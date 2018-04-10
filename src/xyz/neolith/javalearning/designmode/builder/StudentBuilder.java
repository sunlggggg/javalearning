package xyz.neolith.javalearning.designmode.builder;

/**
 * @author sunlggggg
 * @date 2018/4/10
 */
public class StudentBuilder {
    private String name;
    private String subject;
    private int age;
    public StudentBuilder setName(String name){
        this.name = name;
        return this;
    }
    public StudentBuilder setAge(int age){
        this.age = age;
        return this;
    }
    public StudentBuilder setSubject(String subject){
        this.subject = subject ;
        return this;
    }
    public Student build(){
        Student student = new Student() ;
        student.setAge(this.age);
        student.setSubject(this.subject);
        student.setName(this.name);
        return student;
    }
}
