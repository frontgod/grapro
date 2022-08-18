package nuc.sw.entity;
/**
 * 自拟毕设实体
 */
public class ProjectSelf {
	
	private int Id;
	private String ProjectSelfName;
	private String Summary;
	private Integer ProjectTypeId;
	private String StudentId;
	
	public ProjectSelf(String studentId) {
		super();
		StudentId = studentId;
	}

	
	public ProjectSelf(int id, String projectSelfName, String summary, Integer projectTypeId, String studentId) {
		super();
		Id = id;
		ProjectSelfName = projectSelfName;
		Summary = summary;
		ProjectTypeId = projectTypeId;
		StudentId = studentId;
	}


	public ProjectSelf(String projectSelfName, String summary, Integer projectTypeId, String studentId) {
		super();
		ProjectSelfName = projectSelfName;
		Summary = summary;
		ProjectTypeId = projectTypeId;
		StudentId = studentId;
	}
	
	public ProjectSelf(String projectSelfName, Integer projectTypeId, String studentId) {
		super();
		ProjectSelfName = projectSelfName;
		ProjectTypeId = projectTypeId;
		StudentId = studentId;
	}

	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	private String ProjectTypeName;
	@Override
	public String toString() {
		return ProjectSelfName;
	}
	public ProjectSelf() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getProjectSelfName() {
		return ProjectSelfName;
	}
	public void setProjectSelfName(String projectSelfName) {
		ProjectSelfName = projectSelfName;
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
	public String getProjectTypeName() {
		return ProjectTypeName;
	}
	public void setProjectTypeName(String projectTypeName) {
		ProjectTypeName = projectTypeName;
	}
	
	
	
}
