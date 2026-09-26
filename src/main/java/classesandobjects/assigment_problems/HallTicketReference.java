package classesandobjects.assigment_problems;

public class HallTicketReference {
    String studentName;
    int seatNumber;

    public HallTicketReference(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        HallTicketReference priya = new HallTicketReference("Priya", 0);
        HallTicketReference copy = priya;
        copy.seatNumber = 45;

        HallTicketReference separate = new HallTicketReference("Priya", 45);

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}
