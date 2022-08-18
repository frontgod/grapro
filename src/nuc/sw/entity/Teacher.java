package nuc.sw.entity;

public class Teacher {
	
	private int Id;
	public Teacher(String teacherUserName, String teacherPassword) {
		super();
		TeacherUserName = teacherUserName;
		TeacherPassword = teacherPassword;
	}
	
	

	public Teacher(String teacherUserName, String teacherPassword, String teacherId, String teacherName, String sex,
			String phone) {
		super();
		TeacherUserName = teacherUserName;
		TeacherPassword = teacherPassword;
		TeacherId = teacherId;
		TeacherName = teacherName;
		Sex = sex;
		Phone = phone;
	}



	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTeacherUserName() {
		return TeacherUserName;
	}
	public void setTeacherUserName(String teacherUserName) {
		TeacherUserName = teacherUserName;
	}
	public String getTeacherPassword() {
		return TeacherPassword;
	}
	public void setTeacherPassword(String teacherPassword) {
		TeacherPassword = teacherPassword;
	}
	public String getTeacherName() {
		return TeacherName;
	}
	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	private String TeacherUserName;
	private String TeacherPassword;
	private String TeacherId;
	public String getTeacherId() {
		return TeacherId;
	}

	public void setTeacherId(String teacherId) {
		TeacherId = teacherId;
	}
	private String TeacherName;
	private String Sex;
	private String Phone;
	
	
	
	
}
