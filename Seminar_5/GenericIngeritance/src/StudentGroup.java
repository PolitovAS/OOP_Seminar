import java.util.Iterator;
import java.util.List;

public class StudentGroup <T,V,S extends Comparable<S>> implements Iterable<Student<T,V,S>> {
    private List<Student<T,V,S>> students;

    public StudentGroup(List<Student<T,V,S>> students) {
        this.students = students;
    }

    public List<Student<T,V,S>> getStudents() {
        return students;
    }

    public void setStudents(List<Student<T,V,S>> students) {
        this.students = students;
    }

    // @Override
    // public Iterator<Student> iterator() {
    //     return new StudentGroupIterator(students);
    // }

    @Override
    public Iterator<Student<T,V,S>> iterator() {
        return new Iterator<Student<T,V,S>>(){
            private int index = 0;
            @Override
            public boolean hasNext() {
               return index<students.size();
            }
            @Override
            public Student next() {
                if(!hasNext())
                {
                    return null;
                }
                //counter++;
                return students.get(index++);        
            }

        };
    }
    
}