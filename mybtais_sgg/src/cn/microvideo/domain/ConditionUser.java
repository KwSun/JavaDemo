package cn.microvideo.domain;
/** 
  * @author  作者：Kw
  * @date 创建时间：2015年7月23日 上午11:10:12 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class ConditionUser {
	private String name;
	private int minAge;
	private int maxAge;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public ConditionUser(String name, int minAge, int maxAge) {
		super();
		this.name = name;
		this.minAge = minAge;
		this.maxAge = maxAge;
	}
	public ConditionUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ConditionUser [name=" + name + ", minAge=" + minAge + ", maxAge=" + maxAge + "]";
	}
	
}
