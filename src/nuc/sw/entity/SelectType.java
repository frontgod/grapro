package nuc.sw.entity;

public class SelectType {
	
	public String toString() {
		return StudentId;
	}
	private int Id;
	private String StudentId;
	private String ProjectId;
	private String ProjectName;
	private String state;
	
	
	public SelectType(String studentId) {
		super();
		StudentId = studentId;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	public String getProjectId() {
		return ProjectId;
	}
	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public SelectType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SelectType(String studentId, String projectId, String projectName, String state) {
		super();
		StudentId = studentId;
		ProjectId = projectId;
		ProjectName = projectName;
		this.state = state;
	}
	
	
	
}
