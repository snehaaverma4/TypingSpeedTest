import java.util.Scanner;
class Record {
    protected String[] name;
    protected int[] rnk;     
    protected int numStudents; 
    public Record() {
        numStudents = 50; 
        name = new String[numStudents];
        rnk = new int[numStudents];
    }
    public void readValues() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            name[i] = scanner.nextLine();
            System.out.print("Enter rank of student " + (i + 1) + ": ");
            rnk[i] = scanner.nextInt();
            scanner.nextLine(); 
        }
    }
    public void display() {
        System.out.println("\nStudent Records:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Name: " + name[i] + ", Rank: " + rnk[i]);
        }
    }
}
class Rank extends Record {
    private int index; 
    public Rank() {
        super(); 
        index = 0; 
    }
    public void highest() {
        int topRank = rnk[0]; 
        index = 0; 
        for (int i = 1; i < numStudents; i++) {
            if (rnk[i] < topRank) { 
                topRank = rnk[i];
                index = i; 
            }
        }
    }
    public void display() {
        super.display(); 
        System.out.println("\nTopmost Rank:");
        System.out.println("Name: " + name[index] + ", Rank: " + rnk[index]);
    }
}
public class StudentRankSystem {
    public static void main(String[] args) {
        Rank rank = new Rank(); 
        rank.readValues(); 
        rank.highest(); 
        rank.display(); 
    }
}
