package model;

public class Student {


	private int id;
	private String stuName;
	private String stuId;
	private String sex;
	private String birth;
	private String face;
	private String address;
	private String phone;
	private String dormitory;

	private String depart_name;

	private Integer departmentId;



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDormitory() {
		return dormitory;
	}
	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepart_name() {
		return depart_name;
	}
	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String stuName, String stuId, String sex, String birth, String face, String address, String phone,
			String dormitory ,Integer departmentId ) {
		super();
		this.stuName = stuName;
		this.stuId = stuId;
		this.sex = sex;
		this.birth = birth;
		this.face = face;
		this.address=address;
		this.phone = phone;
		this.dormitory = dormitory;
		this.departmentId=departmentId;
	}


	public Student(String stuName, String stuId, Integer departmentId) {
		this.stuName = stuName;
		this.stuId = stuId;
		this.departmentId = departmentId;
	}

	public Student(String stuName, String stuId) {
		this.stuName = stuName;
		this.stuId = stuId;
	}

	public Student(int id, String stuName, String stuId, String sex, String birth, String face, String address, String phone, String dormitory, Integer departmentId) {
		this.id = id;
		this.stuName = stuName;
		this.stuId = stuId;
		this.sex = sex;
		this.birth = birth;
		this.face = face;
		this.address = address;
		this.phone = phone;
		this.dormitory = dormitory;
		this.depart_name = depart_name;
		this.departmentId = departmentId;
	}

}
