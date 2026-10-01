package labcodeinspection;

import java.io.PrintStream;
import java.util.Locale;

public class Email {

	private final String firstName;
	private final String lastName;
	private static final PrintStream OUTPUT = System.out;
	private String password;
	private String department;
	private static final int PASSWORD_LENGTH = 8;
	private String emailAddress;

	public Email(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void showInfo() {
		OUTPUT.printf("%nFIRST NAME= %s%nLAST NAME= %s%n", firstName, lastName);
		OUTPUT.printf("DEPARTMENT= %s%nEMAIL= %s%nPASSWORD= %s%n", department, emailAddress, password);
	}

	public void setDepartment(final int departmentChoice) {
		switch (departmentChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			throw new IllegalArgumentException("Invalid department code: " + departmentChoice);
		}
	}

	private String randomPassword(final int length) {
		final String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			final int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}

	public void generateEmail() {
		this.password = this.randomPassword(PASSWORD_LENGTH);
		this.emailAddress = this.firstName.toLowerCase(Locale.ROOT) + this.lastName.toLowerCase(Locale.ROOT) + "@" + this.department
				+ ".espol.edu.ec";
	}
}
