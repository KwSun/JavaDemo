package cn.microvideo.domain;
/** 
  * @author  作者：Kw
  * @date 创建时间：2015年7月23日 上午10:03:51 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class Student {
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
		public Student(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + "]";
		}
		
	}

