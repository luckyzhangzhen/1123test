import junit.framework.TestCase;
import org.junit.Test;
import java.lang.StringBuilder;

//import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.lang.System;

public class CourseSessionTest extends TestCase {
    private CourseSession session;
    private Date startDate;
    public void setUp(){
        startDate=createDate(2003,1,6);
        startDate=new DateUtil().CreateDate(2003,1,6);
        session=new CourseSession("English",
                "101",startDate);


    }


    @Test
    public void testCreate() {
       // CourseSession courseSession = new CourseSession("English", "101",startDate);
        assertEquals("English", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
//        assertEquals(startDate,session.getStartDate());

    }
    @Test
    public void testEnrollStudents(){
       // CourseSession coursesession=new CourseSession("English","101",startDate);
        Student firstStudent=new Student("zhangsan");
        session.enroll(firstStudent);
        assertEquals(1,session.getNumberOfStudents());
//        ArrayList<Student> allStudents=coursesession.getAllStudents();
//        assertEquals(1,allStudents.size());
//        assertEquals(firstStudent,allStudents.get(0));

        Student secondStudent=new Student("lisi");
        session.enroll(secondStudent);
        assertEquals(2,session.getNumberOfStudents());
//        assertEquals(2,allStudents.size());
//        assertEquals(secondStudent,allStudents.get(1));
    }

    @Test
    public void testCourseDates(){
        int year=103;
        int month=0;
        int date=6;
        Date startDate=new Date(year,month,date);
        CourseSession session =new CourseSession("ABC","200",startDate);
         year=103;
         month=3;
         date=25;
         Date sixteenWeeksOut=new Date(year,month,date);
         assertEquals(sixteenWeeksOut,session.getEndDate());

         Date sixteenWeeksOut2=new DateUtil().CreateDate(2003,4,25);
        assertEquals(sixteenWeeksOut,session.getEndDate());
    }
    @Test
    public Date createDate(int year,int month,int date){
        GregorianCalendar calendar=new GregorianCalendar();
        calendar.clear();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,date);
        return calendar.getTime();
    }
    @Test
    public void testRosterReport(){
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));
        String rosterReport=session.getRosterReport();
        assertEquals(CourseSession.ROSTER_REPORT_HEADER+
                "A"+CourseSession.NEWLINE+
                "B"+CourseSession.NEWLINE+
                CourseSession.ROSTER_REPORT_FOOTER+"2"+
                CourseSession.NEWLINE,rosterReport);
    }




}
