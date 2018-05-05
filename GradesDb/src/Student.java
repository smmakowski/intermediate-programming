
public class Student {
	// instance variables
	private String name;
	private String major;
	private double credits;
	private double points;
	//constructor
	public Student(String name, String major) {
		this.name = name;
		this.major = major;
		this.credits = 0;
		this.points = 0;
	}
	
	public void courseCompleted(String letter, double hours) {
		double grade = 0.00;
		// set grade based on letter
		if (letter.equals("A")) {
			grade = 4.00;
		} else if (letter.equals("B")) {
			grade = 3.00;
		} else if (letter.equals("C")) {
			grade = 2.00;
		} else if (letter.equals("D")) {
			grade = 1.00;
		} else if (letter.equals("F")) {
			grade = 0.00;
		}

		// increment credits and value points
		this.credits += hours;
		this.points += (hours * grade); // points for class is (number of hours * gpa for class)
	}
	// overidden toString() method; overridden since same method signature
	public String toString() {
		double gpa = 4.00;// set gpa to 4.00 automatically
		if (this.credits > 0) { // calculate gpa if credits earned
			gpa = points / credits;
		}
		// return string
		return "{name: " + this.name + ", major: " + this.major + ", gpa: " + gpa + "}";
	}
}
 