import java.util.Scanner;

public class RosterManager {
    Scanner sc = new Scanner(System.in);
    Roster roster = new Roster();
    major[] majors = major.values();
    void run() {
        System.out.println("Roster Manager is running...");
        while (true) {
            System.out.println("Enter a command: ");
            String command = sc.nextLine();
            String[] line = command.split("\\s+");
            //command = line[0];
            if (line[0].equals("A")) { //add a new student
                Student student = new Student(new Profile(line[0], line[1], new date(line[2])), majors[Integer.parseInt(line[3])], Integer.parseInt(line[4]));
                roster.add(student);
            } else if (line[0].equals("R")) { //remove a student
                Student student = new Student(new Profile(line[0], line[1], new date(line[2])), majors[Integer.parseInt(line[3])], Integer.parseInt(line[4]));
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

            } else if(line[0].equals("Q")){ //terminate run
                System.out.println("Roster Manager terminated.");
                break;
            }
        }
    }
}

