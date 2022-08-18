package nuc.sw.entity;
/**
 * 课设类别实体
 * @author 24872
 *
 */
public class ProjectType {
	@Override
	public String toString() {
		return ProjectTypeName;
	}
	private int Id;
	private String ProjectTypeName;
	private String ProjectTypeDeco;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getProjectTypeName() {
		return ProjectTypeName;
	}
	public void setProjectTypeName(String projectTypeName) {
		ProjectTypeName = projectTypeName;
	}
	public String getProjectTypeDeco() {
		return ProjectTypeDeco;
	}
	public void setProjectTypeDeco(String projectTypeDeco) {
		ProjectTypeDeco = projectTypeDeco;
	}
	public ProjectType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectType(String projectTypeName, String projectTypeDeco) {
		super();
		this.ProjectTypeName = projectTypeName;
		this.ProjectTypeDeco = projectTypeDeco;
	}
	
	
}
