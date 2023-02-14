package roster;
import java.util.Scanner;
/**
 * RosterManager is a class that manages a roster of students. It allows the user to add, remove, and print students.
 * It also allows the user to print students by school, major, and standing.
 * @Author: Alex Virilli, Ryan Elizondo-Fallas
 */
public class RosterManager {
    Scanner sc = new Scanner(System.in); Roster roster = new Roster(); Major[] majors = Major.values();
    void run() {
        Scanner sc = new Scanner(System.in); Roster roster = new Roster(); Major[] majors = Major.values(); Checker check = new Checker();
        System.out.println("Roster Manager is running...");
        while (true) {
            String command = sc.nextLine(); String[] line = command.split("\\s+");
            if(line.length==0) continue;
            else if(line[0].trim().length()==0) continue;
            if(line[0].equals("A")) { //add a new student
                Date date = new Date(line[3]);
                if(check.isValidToAdd(date, line)){
                    Profile profile = new Profile(line[2],line[1],date);
                    Student student = check.makeStudent(profile,majors[Major.CS.getMajorIndex(line[4])],Integer.parseInt(line[5]));
                    if (!roster.contains(student)) { roster.add(student); System.out.println(profile.toString() + " added to the roster.");
                    } else { System.out.println(profile.toString() + " is already in the roster."); }}
            } else if (line[0].equals("R")) { //remove a student
                Date date = new Date(line[3]);
                Profile profile = new Profile(line[2],line[1],date);
                Student student = check.makeStudent(profile, Major.CS, 0);
                if (roster.remove(student)) { System.out.println(profile.toString() + " removed from the roster.");
                } else { System.out.println(profile.toString() + " is not in roster.");}
            } else if (line[0].equals("P")) { /*display roster sorted by last name, first name, and DOB*/ roster.print();
            } else if (line[0].equals("PS")) { /*display roster sorted by standing*/ roster.printByStanding();
            } else if (line[0].equals("PC")){ /*display roster sorted by school and major*/ roster.printBySchoolMajor();
            } else if (line[0].equals("L")) { /*list student in a specified school*/ roster.printSchool(line[1]);
            } else if(line[0].equals("C")){ //change a students major
                check.changeStudentMajor(line,roster,majors);
            } else if(line[0].equals("Q")){ /*terminate run*/ System.out.println("Roster Manager terminated."); break;
            } else { System.out.println(line[0] + " is an invalid command!");}
        }
    }
}
