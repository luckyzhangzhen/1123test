
public class RosterReporter {

    public static final String NEWLINE = System.getProperty("line.separator");
    public static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "-----" + NEWLINE;
    public static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students =";

    private CourseSession _session;

    public RosterReporter(CourseSession session) {
        _session = session;
    }

    public String getRosterReport() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(ROSTER_REPORT_HEADER);

//        将集合students的每一个对象赋值给Student类型引用，引用的名称为student,执行循环体
        for (Student student : _session.getAllStudents()) {
            buffer.append(student.getName());
            buffer.append(NEWLINE);
        }

        buffer.append(ROSTER_REPORT_FOOTER + _session.getAllStudents().size() + NEWLINE);
        return buffer.toString();

//        return getReport();
    }

    private String getReport() {
        StringBuilder builder = new StringBuilder();
        writeHeader(builder);
        writeBody(builder);
        writeFooter(builder);
        return builder.toString();
    }

    private void writeHeader(StringBuilder buffer) {
        buffer.append(ROSTER_REPORT_HEADER);
    }

    private void writeBody(StringBuilder buffer) {
        for (Student student : _session.getAllStudents()) {
            buffer.append(student.getName());
            buffer.append(NEWLINE);
        }
    }

    private void writeFooter(StringBuilder buffer) {
        buffer.append(ROSTER_REPORT_FOOTER +
                _session.getAllStudents().size() + NEWLINE);
    }
}
