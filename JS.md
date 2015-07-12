###JS小记：
              //1. 获取 id 为 bj 的那个节点.
				//在编写 HTML 文档时, 需确保 id 属性值是唯一的. 
				//该方法为 document 对象的方法
				var bjNode = document.getElementById("bj");
				alert(bjNode);
				
				//2. 获取所有的 li 节点. 
				//使用标签名获取指定节点的集合. 
				//该方法为 Node 接口的方法, 即任何一个节点都有这个方法. 
				var liNodes = document.getElementsByTagName("li");
				alert(liNodes.length);
				
				
				//3.若 HTML 元素自身没有定义 name 属性, 则 getElementsByName()
				//方法对于 IE 无效. 所以使用该方法时需谨慎. 
				var bjNode = document.getElementsByName("BeiJing");
				alert(bjNode2.length);
				
				//4读写属性节点: 通过元素节点 . 的方式来获取属性值和设置属性值. 
			   window.onload = function(){
				
				//属性节点即为某一指定的元素节点的属性. 
				//(1). 先获取指定的那个元素节点
				var nameNode = document.getElementById("name");
				
				//(2). 再读取指定属性的值
				alert(nameNode.value);
				
				//(3). 设置指定的属性的值.
				nameNode.value = "kw";
				
				}
