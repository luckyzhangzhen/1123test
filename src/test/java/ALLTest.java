import junit.framework.TestSuite;

import java.security.KeyRep;
import java.util.Date;

public class ALLTest {
    public static TestSuite suite(){
        TestSuite suite=new TestSuite();
        suite.addTestSuite(CourseSessionTest.class);
        suite.addTestSuite(StudentTest.class);
        suite.addTestSuite(RosterReporterTest.class);
        suite.addTestSuite(DateUtilTest.class);
        return suite;
    }


}
