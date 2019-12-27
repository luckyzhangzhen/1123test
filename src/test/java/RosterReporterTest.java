import junit.framework.TestCase;
import org.junit.Test;

import java.sql.Struct;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static ReportConstant.NEWLINE;


public class RosterReporterTest extends TestCase {

    private CourseSession session;
    public void setUp(){
        session=new CourseSession("ENGLISH",
                "101",createDate(2003,1,6));
    }
    @Test
    public void testRosterReport(){

        session.enroll(new Student("A"));
        session.enroll(new Student("B"));
        String rosterReport=new RosterReporter(session).getRosterReport();

        System.out.println(rosterReport);

        assertEquals(RosterReporter.ROSTER_REPORT_HEADER+
                "A"+RosterReporter.NEWLINE+
                "B"+RosterReporter.NEWLINE+
                RosterReporter.ROSTER_REPORT_FOOTER+"2"+
                RosterReporter.NEWLINE,rosterReport);


    }
    public Date createDate(int year, int month, int date){
        GregorianCalendar calendar=new GregorianCalendar();
        calendar.clear();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,date);
        return calendar.getTime();
    }

}
