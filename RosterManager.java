import java.util.Scanner;
public class RosterManager {
    Scanner sc = new Scanner(System.in);
    Roster roster = new Roster();
    major[] majors = major.values();
    void run() {
        System.out.println("Roster Manager is running...");
        while (true) {
            String command = sc.nextLine();
            String[] line = command.split("\\s+");
            if (line[0].equals("A")) { //add a new student
                Student student = new Student(new Profile(line[1], line[2], new date(line[3])), majors[Integer.parseInt(line[4])], Integer.parseInt(line[5]));
                roster.add(student);
            } else if (line[0].equals("R")) { //remove a student
                Student student = new Student(new Profile(line[1], line[2], new date(line[3])), majors[Integer.parseInt(line[4])], Integer.parseInt(line[5]));
                if (roster.contains(student)){
                    roster.remove(student);
                }
            } else if (line[0].equals("P")) { //display roster sorted by last name, first name, and DOB
                roster.print();
            } else if (line[0].equals("PS")) { //display roster sorted by standing
                roster.printByStanding();
            } else if (line[0].equals("PC")){ //display roster sorted by school and major
                roster.printBySchoolMajor();
            } else if (line[0].equals("L")) { //list student in a specified school

            } else if(line[0].equals("C")){ //change a students major
                Student student = new Student(new Profile(line[1], line[2], new date(line[3])), majors[Integer.parseInt(line[4])], Integer.parseInt(line[5]));
                if(roster.contains(student)){
                    roster.changeMajor(student, majors[Integer.parseInt(line[5])]);
                }
            } else if(line[0].equals("Q")){ //terminate run
                System.out.println("Roster Manager terminated.");
                break;
            } else {
                System.out.println(line[0] + "is an invalid command");
            }
        }
    }
}

