public class ThreeChapter {
    public static void main(String[] args) {
        char captialA = 'A';

        //Char
        System.out.println(captialA == 65);
        System.out.println(captialA == '\u0041');
        System.out.println(captialA == '\101');

        //String

        String name1="zhangsan";
        String name2="lisi";
        String z="你\t\n好";

        System.out.println(name1 == name2);//重写了操作符==
        System.out.println(name1.equals(name2));
        System.out.println(name1+z);

        String student1=name1+":20";
        System.out.println(student1);
        String student2=name2.concat(":20");
        System.out.println(student2);


        //StringBuilder

        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(student1);
        stringBuilder.append("\r\n");
        stringBuilder.append(student2);
        System.out.println(stringBuilder.toString());








    }
}
