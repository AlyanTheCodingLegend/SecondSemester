import java.util.ArrayList;

// Abstract class for students
abstract class Student {
    protected String name;
    protected String id;
    protected double cgpa;

    public Student(String name, String id, double cgpa) {
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
    }

    public abstract boolean isEligibleForConvocation();

    public abstract boolean isEligibleForConference();
    
    // Getters to obtain attributes of the Student
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Concrete class for undergraduate students
class UndergraduateStudent extends Student {
    public UndergraduateStudent(String name, String id, double cgpa) {
        super(name, id, cgpa);
    }

    @Override
    public boolean isEligibleForConvocation() {
        return cgpa >= 2.8;
    }

    @Override
    public boolean isEligibleForConference() {
        return false;
    }
}

// Concrete class for graduate students
class GraduateStudent extends Student {
    private boolean hasPublishedPaper;

    public GraduateStudent(String name, String id, double cgpa, boolean hasPublishedPaper) {
        super(name, id, cgpa);
        this.hasPublishedPaper = hasPublishedPaper;
    }

    @Override
    public boolean isEligibleForConvocation() {
        return cgpa >= 2.8;
    }

    @Override
    public boolean isEligibleForConference() {
        return cgpa >= 3.0 && hasPublishedPaper;
    }
}

// Class representing academic events
abstract class AcademicEvent {
    protected ArrayList<Student> attendees;

    public AcademicEvent() {
        attendees = new ArrayList<>();
    }

    public void inviteStudent(Student student) {
        if (isEligible(student)) {
            attendees.add(student);
            System.out.println(student.name + " invited to the event.");
        } else {
            System.out.println(student.name + " not eligible for the event.");
        }
    }

    public abstract boolean isEligible(Student student);
    
    public ArrayList<Student> getAttendees() {
        return attendees;
    }
}

// Concrete class for Convocation
class Convocation extends AcademicEvent {
    @Override
    public boolean isEligible(Student student) {
        return student.isEligibleForConvocation();
    }
}

// Concrete class for Conference
class Conference extends AcademicEvent {
    @Override
    public boolean isEligible(Student student) {
        return student.isEligibleForConference();
    }
}

// Class representing departments
class Department {
    public boolean isClearanceGranted(Student student) {
        // Simulating clearance process
        return true;
    }
}

public class UniversityInvitationSystem {
    public static void main(String[] args) {
        // Creating some sample students
        UndergraduateStudent undergradStdnt = new UndergraduateStudent("John", "U001", 3.2);
        GraduateStudent gradStdnt = new GraduateStudent("Alice", "G001", 3.5, true);

        // Creating academic events
        Convocation convocation = new Convocation();
        Conference conference = new Conference();

        // Simulating clearance process from departments
        Department financeDept = new Department();
        Department libraryDept = new Department();

        boolean financeClearance = financeDept.isClearanceGranted(undergradStdnt);
        boolean libraryClearance = libraryDept.isClearanceGranted(undergradStdnt);

        if (financeClearance && libraryClearance) {
            convocation.inviteStudent(undergradStdnt);
        }

        financeClearance = financeDept.isClearanceGranted(gradStdnt);
        libraryClearance = libraryDept.isClearanceGranted(gradStdnt);

        if (financeClearance && libraryClearance) {
            conference.inviteStudent(gradStdnt);
        }

        System.out.println("\n");

        // Display attendees for each event
        displayEventAttendees(convocation);
        displayEventAttendees(conference);
    }

    // Defining function to display attendees of each type of event
    public static void displayEventAttendees(AcademicEvent event) {
        System.out.println("Attendees for " + event.getClass().getSimpleName() + ":");
        for (Student student : event.getAttendees()) {
            System.out.println(student.getName() + " (" + student.getId() + ")");
        }
        System.out.println();
    }
}