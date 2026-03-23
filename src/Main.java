import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

boolean isPrime(int num) {
    if (num <= 1) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;

    // Checks every odd number between 3 and the square root of the number to declare if it is prime or composite.
    for (int i = 3; i <= Math.sqrt(num); i += 2) {
        if (num % i == 0) return false;
    }
    return true;
}


int stringToInt(String str) {
    // Checks if the given value is a number.
    try {
        return Integer.parseInt(str);
    } catch (NumberFormatException e) {
        return -1;
    }
}

void main() {

    int rangeMin;
    int rangeMax;
    int countMax;

    int count = 0;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    File outputFolder = new File("OUTPUT");
    if (!outputFolder.exists()) {
        boolean outputFolderExists = outputFolder.mkdirs();
        if (!outputFolderExists) {
            JOptionPane.showMessageDialog(null, "Error: Output directory could not be created.");
            System.exit(0);
        }
    }

    do {
        int startMenuOption = JOptionPane.showOptionDialog(null,
                "Welcome to the Prime Number Searcher.\n\nDo you wish to proceed?",
                "Prime Number Searcher v1",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                null,
                0);
        if (startMenuOption == JOptionPane.CANCEL_OPTION || startMenuOption == JOptionPane.CLOSED_OPTION) {
            System.exit(0);
        }

        String rangeMinStr = JOptionPane.showInputDialog("\nInsert a minimum range for prime number search: ");
        rangeMin = stringToInt(rangeMinStr);
        if (rangeMin <=  0) {
            JOptionPane.showMessageDialog(null, "Invalid operation.");
            break;
        }

        String rangeMaxStr = JOptionPane.showInputDialog("\nInsert a maximum range for prime number search: ");
        rangeMax = stringToInt(rangeMaxStr);
        if (rangeMax <= 0 || rangeMax <= rangeMin) {
            JOptionPane.showMessageDialog(null, "Invalid operation.");
            break;
        }

        String countMaxStr = JOptionPane.showInputDialog("\nInsert the amount of prime numbers to search for: ");
        countMax = stringToInt(countMaxStr) - 1;
        if (countMax <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid operation.");
            break;
        }

        LocalDateTime currentDateTime = LocalDateTime.now();
        String dateString = currentDateTime.format(formatter);

        PrintWriter writer;
        try {
            writer = new PrintWriter("OUTPUT/prime_numbers" + dateString + ".txt", StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Searches for primes within the given range so the user can get the results.
        writer.println("---//---\n");
        while (count <= countMax && rangeMin <= rangeMax) {
            if (isPrime(rangeMin)) {
                writer.println(rangeMin);
                ++count;
                if (count % 10 == 0) writer.println("\n---//---\n");
            }
            ++rangeMin;
        }
        writer.close();

    } while (true);

}
