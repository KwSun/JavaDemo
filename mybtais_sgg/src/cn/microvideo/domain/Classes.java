package cn.microvideo.domain;

import java.util.List;

/** 
  * @author  作者：Kw
  * @date 创建时间：2015年7月22日 下午10:28:15 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class Classes {
	private int id;
	private String name;
	private Teacher teacher;
	private List<Student> students;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classes(int id, String name, Teacher teacher, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.students = students;
	}
	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + ", teacher=" + teacher + ", students=" + students + "]";
	}
	
	
	
}

