package cn.microvideo.domain;
/** 
  * @author  作者：Kw
  * @date 创建时间：2015年7月22日 下午10:27:46 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class Teacher {
	private int id;
	private String name;
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
	public Teacher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + "]";
	}
	
}
