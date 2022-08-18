package nuc.sw.entity;
/**
 * 学生实体
 * @author 24872
 *
 */
public class Student {
	private int Id;
	private String StudentUserName;
	private String StudentPassword;
	private String StudentId;
	private String StudentName;
	private String Sex;
	
	
	
	
	
	public Student(String studentUserName, String studentPassword) {
		super();
		StudentUserName = studentUserName;
		StudentPassword = studentPassword;
	}
	public Student(String studentUserName, String studentPassword, String studentId, String studentName, String sex) {
		super();
		StudentUserName = studentUserName;
		StudentPassword = studentPassword;
		StudentId = studentId;
		StudentName = studentName;
		Sex = sex;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getStudentUserName() {
		return StudentUserName;
	}
	public void setStudentUserName(String studentUserName) {
		StudentUserName = studentUserName;
	}
	public String getStudentPassword() {
		return StudentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		StudentPassword = studentPassword;
	}
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}

	
}
