public class Student<T,V,S extends Comparable<S>> extends User<T,V> implements Comparable<Student<T,V,S>>{
    private S studentID;

    public Student(T firstName, T secondName, V age, S studentID) {
        super(firstName, secondName, age);
        this.studentID = studentID;
    }


    public S getStudentID() {
        return studentID;
    }

    public void setStudentID(S studentID) {
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "Student{" 
                
                +"firstName=" +super.getFirstName()
                +", secondName=" +super.getSecondName()
                +", age=" +super.getAge()+
                ", studentID=" + studentID +
                '}';
    }


    @Override
    public int compareTo(Student<T,V,S> o) {
        
        
         return this.studentID.compareTo(o.studentID);
    }
}