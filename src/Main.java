import java.util.Scanner;
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
    try {
        return Integer.parseInt(str);
    } catch (NumberFormatException e) {
        return -1;
    }
}

void main() {

    Scanner scanner = new Scanner(System.in);

    int count = 0;
    int rangeMin;
    int rangeMax;
    int countMax;

    do {
        String rangeMinStr = JOptionPane.showInputDialog("\nInsert a minimum range for prime number search: ");
        rangeMin = stringToInt(rangeMinStr);
        if (rangeMin <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid operation.");
            break;
        }

        String rangeMaxStr = JOptionPane.showInputDialog("\nInsert a minimum range for prime number search: ");
        rangeMax = stringToInt(rangeMaxStr);
        if (rangeMax <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid operation.");
            break;
        }

        String countMaxStr = JOptionPane.showInputDialog("\nInsert a minimum range for prime number search: ");
        countMax = stringToInt(countMaxStr) - 1;
        if (countMax <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid operation.");
            break;
        }

        while (count <= countMax && rangeMin <= rangeMax) {
            if (isPrime(rangeMin)) {
                System.out.println(rangeMin);
                ++count;
                if (count % 10 == 0) System.out.println();
            }
            ++rangeMin;
        }
    } while (true);

}
