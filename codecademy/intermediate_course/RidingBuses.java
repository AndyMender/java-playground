package codecademy.intermediate_course;

public class RidingBuses {
    public static void main(String[] args) {
        Teacher teacherMike = new Teacher("Mike", "Geography");
        Student studentTom = new Student("Tom", "Math");

        Bus<SchoolPerson> busTeacher = new Bus<>(teacherMike);
        Bus<SchoolPerson> busStudent = new Bus<>(studentTom);
        busTeacher.printPassenger();  
        busStudent.printPassenger();

    }
}
