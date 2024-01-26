class Student{
 int rollnumber ;    //Instance variables
 String name;
 float grades;  //these are thr properties (Template for the methods )

    public static void main(String[] args) {
        Student S1 /*Reference variable*/ = new Student();
        //(stack)Compile time                run time(heap)
        S1.name = "Biswajit";
        S1.rollnumber = 001;
        S1.grades = 92.00f;

        System.out.println(S1.rollnumber);
        System.out.println(S1.name);
        System.out.println(S1.grades);

    }


}