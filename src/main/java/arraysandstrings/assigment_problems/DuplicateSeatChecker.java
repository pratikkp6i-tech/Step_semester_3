package arraysandstrings.assigment_problems;

public class DuplicateSeatChecker {

    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundAny = false;
        boolean[] alreadyPrinted = new boolean[seatNumbers.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < seatNumbers.length; i++) {
            if (alreadyPrinted[i]) continue;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    if (foundAny) sb.append(", ");
                    sb.append(seatNumbers[i]);
                    foundAny = true;
                    alreadyPrinted[j] = true;
                    break;
                }
            }
        }

        if (foundAny) {
            System.out.println("Duplicate Seat Number Found: " + sb);
        } else {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        checkDuplicateSeats(new int[]{101, 102, 103, 102, 105});
        checkDuplicateSeats(new int[]{101, 102, 103, 104, 105});
    }
}
