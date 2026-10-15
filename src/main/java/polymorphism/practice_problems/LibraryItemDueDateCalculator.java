package polymorphism.practice_problems;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibraryItemDueDateCalculator {

    static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);
    static final Pattern LINE_PATTERN = Pattern.compile("^(\\S+)\\s+\"(.+)\"$");

    static abstract class LibraryItem {
        abstract int borrowDays();
    }

    static class Book extends LibraryItem {
        @Override int borrowDays() { return 14; }
    }

    static class Dvd extends LibraryItem {
        @Override int borrowDays() { return 7; }
    }

    static class Magazine extends LibraryItem {
        @Override int borrowDays() { return 3; }
    }

    static Map<String, LibraryItem> itemTypes = new HashMap<>();
    static {
        itemTypes.put("BOOK", new Book());
        itemTypes.put("DVD", new Dvd());
        itemTypes.put("MAGAZINE", new Magazine());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            Matcher m = LINE_PATTERN.matcher(line);
            if (!m.matches()) continue;

            String type = m.group(1);
            String title = m.group(2);

            LibraryItem item = itemTypes.get(type);
            LocalDate dueDate = CURRENT_DATE.plusDays(item.borrowDays());

            System.out.println(title + ": " + dueDate);
        }
    }
}
