package nuc.sw.entity;

public class Project {
	private int Id;
	private String ProjectName;
	private String Summary;
	private Integer ProjectTypeId;
	private String TeacherName;
	private String TeacherPhone;
	
	
	public Project(int id, String projectName, String summary, Integer projectTypeId, String teacherName,
			String teacherPhone) {
		super();
		Id = id;
		ProjectName = projectName;
		Summary = summary;
		ProjectTypeId = projectTypeId;
		TeacherName = teacherName;
		TeacherPhone = teacherPhone;
	}

	public Project(String projectName, String summary, Integer projectTypeId, String teacherName, String teacherPhone) {
		super();
		ProjectName = projectName;
		Summary = summary;
		ProjectTypeId = projectTypeId;
		TeacherName = teacherName;
		TeacherPhone = teacherPhone;
	}
	
	public Project(String projectName, Integer projectTypeId, String teacherName) {
		super();
		ProjectName = projectName;
		ProjectTypeId = projectTypeId;
		TeacherName = teacherName;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getProjectName() {
		return ProjectName;
	}
	
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getSummary() {
		return Summary;
	}
	public void setSummary(String summary) {
		Summary = summary;
	}
	public Integer getProjectTypeId() {
		return ProjectTypeId;
	}
	public void setProjectTypeId(Integer projectTypeId) {
		ProjectTypeId = projectTypeId;
	}
	public String getTeacherName() {
		return TeacherName;
	}
	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	public String getTeacherPhone() {
		return TeacherPhone;
	}
	public void setTeacherPhone(String teacherPhone) {
		TeacherPhone = teacherPhone;
	}
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}	
