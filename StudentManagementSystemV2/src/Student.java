public class Student {
    private int studentId;
    private String name;
    private int age;
    private String branch;
    private double cgpa;
    private String mobileNumber;
    public Student(int studentId,String name,int age,String branch,double cgpa,String mobileNumber){
        this.studentId = studentId;
        this.name = name;
        this.age=age;
        this.branch = branch;
        this.cgpa=cgpa;
        this.mobileNumber=mobileNumber;
    }
    public int getStudentId(){
        return studentId;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getBranch(){
        return branch;
    }
    public double getCgpa(){
        return cgpa;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }
    public void setName(String name){
        this.name = name;
    }
    public int setAge(int age){
       return this.age=age;
    }
    public String setbranch(String branch){
        return this.branch=branch;
    }
    public double setCgpa(double cgpa){
        return this.cgpa=cgpa;
    }
    public String setmobileNumber(String mobileNumber){
        return this.mobileNumber = mobileNumber;
    }
     @Override
    public String toString() {
        return "Student ID: " + studentId +
           "\nName: " + name +
           "\nAge: " + age +
           "\nBranch: " + branch +
           "\nCGPA: " + cgpa +
           "\nMobile Number: " + mobileNumber;
        }

}