import java.util.Scanner;

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

void main() {

    Scanner scanner = new Scanner(System.in);

    int count = 0;
    int rangeMin;
    int rangeMax;
    int countMax;

    System.out.print("\nInsert a minimum range for prime number search: ");
    rangeMin = scanner.nextInt();
    System.out.print("\nInsert a maximum range for prime number search: ");
    rangeMax = scanner.nextInt();
    System.out.print("\nInsert the max number of primes you want to search for: ");
    countMax = scanner.nextInt() - 1;
    System.out.println();

    while (count <= countMax && rangeMin <= rangeMax) {
        if (isPrime(rangeMin)) {
            System.out.println(rangeMin);
            ++count;
            if (count % 10 == 0) System.out.println();
        }
        ++rangeMin;
    }

}
