package labcodeinspection;

import java.io.PrintStream;
import java.util.Scanner;

public final class EmailApp {

	private static final PrintStream OUTPUT = System.out;

	private EmailApp() {
	}

	public static void main(final String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {

		OUTPUT.print("Enter your first name: ");
		final String firstName = scanner.nextLine();

		OUTPUT.print("Enter your last name: ");
		final String lastName = scanner.nextLine();

		OUTPUT.print("\nDEPARTMENT CODE\n1. for sales\n2. for Development\n3. for accounting\nEnter code: ");

		final int departmentChoice = scanner.nextInt();
		scanner.close();

		final Email email = new Email(firstName, lastName);
		email.setDepartment(departmentChoice);
		email.generateEmail();
		email.showInfo();
		}
	}
}
