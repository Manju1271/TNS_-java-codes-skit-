package javacodes;
class Course 
{
	String courseName="Java ";
	
	void showCourse()
	{
		System.out.println("Course :"+courseName);
	}
}
class Student extends Course 
{
String studentName="Manjunath";
	
	void showStudent()
	{
		System.out.println("Student  :"+studentName);
	}
}

public class SingleLevelDemo {

	public static void main(String[] args) {
		Student obj=new Student(); 
		obj.showCourse();
		obj.showStudent();
	}
}

	


