import java.util.*;
import java.lang.StringBuilder;

public class CourseSession {
    private String department;
    private String number;
//    private int numberOfStudents=0;
    static int count;
    private ArrayList<Student> students=new ArrayList<Student>();
    private Date startDate;
    public static final String NEWLINE=System.getProperty("line.separator");
    public static final String ROSTER_REPORT_HEADER="Student"+NEWLINE+"-----"+NEWLINE;
    public static final String ROSTER_REPORT_FOOTER=NEWLINE+"# students =";
    public CourseSession(String department,String number,Date startDate){
        this.department=department;
        this.number=number;
        this.startDate=startDate;
        CourseSession.count=CourseSession.count+1;
        CourseSession.incrementCount();

    }
    /*
    计数类方法
     */
    private static void incrementCount(){
        count=count++;
    }
    public String getDepartment(){
        return department;
    }
    public String getNumber(){
        return number;
    }
    public int getNumberOfStudents(){
        return students.size();
    }
    public void enroll(Student student){
//        numberOfStudents+=1;
        students.add(student);
    }
    public ArrayList<Student> getAllStudents(){
        return students;
    }
    public Student get(int index){
        return students.get(index);

    }
    public Date getEndDate(){
        GregorianCalendar calendar=new GregorianCalendar();
        calendar.setTime(startDate);
        int numberOfDays=16*7-3;
        calendar.add(Calendar.DAY_OF_YEAR,numberOfDays);
        Date endDate=calendar.getTime();
        return endDate;

    }

    public String getRosterReport(){
        StringBuilder buffer =new StringBuilder();
        buffer.append(ROSTER_REPORT_HEADER);

//        Student student=students.get(0);
//        buffer.append(student.getName());
//        buffer.append(NEWLINE);
//
//        student=students.get(1);
//        buffer.append(student.getName());
//        buffer.append(NEWLINE);

//        将集合students的每一个对象赋值给Student类型引用，引用的名称为student,执行循环体
        for (Student student:students){
            buffer.append(student.getName());
            buffer.append(NEWLINE);
        }
//        for (int i=0;i<students.size();i++){
//            students[i]
//        }


        buffer.append(ROSTER_REPORT_FOOTER+students.size()+NEWLINE);
        return buffer.toString();

    }

}
