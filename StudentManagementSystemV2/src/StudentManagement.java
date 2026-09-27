import java.util.ArrayList;

public class StudentManagement {
   private ArrayList<Student> students = new ArrayList<>();
   private int nextStudentId=5001;
   public int addStudent(String name,int age,String branch,double cgpa,String mobileNumber){
        Student s = new Student(nextStudentId,name,age,branch,cgpa,mobileNumber);
        students.add(s);
        nextStudentId++;
        return s.getStudentId();
   }
   public ArrayList<Student> viewStudents(){
      return students;
   }
   public Student searchStudent(int enteredId){
      for(Student s: students){
         if(enteredId==s.getStudentId()){
            return s;
         }
         else{
            continue;
         }
      }
      return null;
   }
   public Student removeStudent(int enteredId){
      boolean found = false;
      for(Student s: students){
         if(enteredId==s.getStudentId()){
               students.remove(s);
               found = true;
               break;
         }
      }
      if(found==false){
         System.out.println("No Student Data Found");
      }
      return null;
   }
   public int getTotalStudent(){
      return students.size();
   }
   public double getAverageCgpa(){
      double gpa=0.0;
      for(Student a: students){
         gpa += a.getCgpa();
      }
      double Average = Math.round((gpa / (double) students.size()) * 100) / 100.0;
      return Average;
   }
}