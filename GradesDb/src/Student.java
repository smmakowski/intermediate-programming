
public class Student {
	private String name;
	private String major;
	private int credits;
	private int points;
	
	public Student(String name, String major) {
		this.name = name;
		this.major = major;
		this.credits = 0;
		this.points = 0;
	}
	
	public void courseCompleted(String grade, int hours) {
		
	}
	
	public String toString() {
		return "";
	}
}
