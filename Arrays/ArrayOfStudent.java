import java.util.Scanner;
import java.util.GregorianCalendar;

class student {
	String studentName;
	String studentLastName;
	long studentRegno;
	String department;
	char gender;
	String studentAddress;
	char studentSection;
	String studentEmail;
	long studentMobileNumber;
	GregorianCalendar Calendar;

	

	student() {

		studentName = "";
		studentLastName = "";
		studentRegno = 0;
		department = "";
		gender = '\0';
		studentAddress = "";
		studentSection = '\0';
		studentEmail = "";
		studentMobileNumber = 0;
		Calendar = new GregorianCalendar(0, 0, 0);

	}

	student(String sName, String lsName, long regno, String dept, char gender, String addrs, char section, String email,
			long mbno, int mm, int dd, int yy) {
		this.studentName = sName;
		this.studentLastName = lsName;
		this.studentRegno = regno;
		this.department = dept;
		this.gender = gender;
		this.studentAddress = addrs;
		this.studentSection = section;
		this.studentEmail = email;
		this.studentMobileNumber = mbno;
		this.Calendar = new GregorianCalendar(dd, mm, yy);
	}

	public void studentDisplay() {
		System.out.println("------------------------------------------------------");
		System.out.println();
		System.out.println("Student name is : " + studentName);
		System.out.println("Student Last name is : " + studentLastName);
		System.out.println("Student registernumber is : " + studentRegno);
		System.out.println("Department is : " + department);
		System.out.println("Gender is : " + gender);
		System.out.println("Student Address is : " + studentAddress);
		System.out.println("Student Section is : " + studentSection);
		System.out.println("Student email is : " + studentEmail);
		System.out.println("Student mobile number is : " + studentMobileNumber);
		System.out.println("Date of joining is : " + this.Calendar.get(java.util.Calendar.DATE) + "/"
				+ this.Calendar.get(java.util.Calendar.MONTH) + "/" + this.Calendar.get(java.util.Calendar.YEAR));
		System.out.println();
		System.out.println("------------------------------------------------------");

	}
}

class ArrayOfStudent {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------------------------------------------------------");
		System.out.println();
		System.out.print("Enter the number of student wanna register : ");
		int studentSize = scanner.nextInt();
		student stuArr[] = new student[studentSize];

		for (var i = 0; i < stuArr.length; i++) {
			System.out.println("Enter the details of : [ " + (i + 1) + " ] student : ");
			System.out.println();
			System.out.print("Enter the Student name : ");
			String studentName = scanner.nextLine();
			System.out.print("Enter the student last name : ");
			String studentLastName = scanner.nextLine();
			System.out.print("Enter the student register number : ");
			long studentRegno = scanner.nextLong();
			System.out.print("Enter the department : ");
			String department = scanner.nextLine();
			System.out.print("Enter the Gender : ");
			char gender = scanner.next().charAt(0);
			System.out.print("Enter the student address : ");
			String studentAddress = scanner.nextLine();
			System.out.print("Enter the student section : ");
			char studentSection = scanner.next().charAt(0);
			System.out.print("Enter the student email : ");
			String studentEmail = scanner.nextLine();
			System.out.println("Enter the student mobile number : ");
			long studentMbno = scanner.nextLong();
			System.out.print("Enter the day : ");
			int dd = scanner.nextInt();
			System.out.print("Enter the month : ");
			int mm = scanner.nextInt();
			System.out.print("Enter the year : ");
			int yy = scanner.nextInt();

			stuArr[i] = new student(studentName, studentLastName, studentRegno, department, gender, studentAddress,
					studentSection, studentEmail, studentMbno, dd, mm, yy);
		}

		for (var i = 0; i < stuArr.length; i++) {
			stuArr[i].studentDisplay();
		}
		scanner.close();
	}

}