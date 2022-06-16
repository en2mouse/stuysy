package model;

public class Department {
	@Override
	public String toString() {
	return depart_name;
	}
	private int id;
	private String depart_name;
	private String depart_desc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepart_name() {
		return depart_name;
	}
	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}
	public String getDepart_desc() {
		return depart_desc;
	}
	public void setDepart_desc(String depart_desc) {
		this.depart_desc = depart_desc;
	}
	public Department(String depart_name, String depart_desc) {
		super();
		this.depart_name = depart_name;
		this.depart_desc = depart_desc;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int id, String depart_name, String depart_desc) {
		super();
		this.id = id;
		this.depart_name = depart_name;
		this.depart_desc = depart_desc;
	}

}
