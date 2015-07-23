package org.duohuo.test;
/** 
  * @author  作者：Kw
  * @date 创建时间：2015年7月23日 下午5:42:33 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
@Description("I am class annotation")
public class Child implements Person{

	@Override
	@Description("I am method annotation")
	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int age() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		
	}
	
	
}
