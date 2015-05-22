package org.duohuo.sort;

public class Sort1 {
	public static void main(String[] args) {
		int arr[] = {-4,7,10,99};
		
//		Bubble bubble = new Bubble();
//		bubble.sort(arr);
		
//		Select select = new Select();
//		select.sort(arr);
		
		InsertSort insertsort = new InsertSort();
		insertsort.sort(arr);
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+" ");
		}
	}
	
	
}


//冒泡排序
class Bubble{
	public void sort(int arr[]){
		int temp  =0;
		//外层循环，决定走几趟
		for(int i=0;i<arr.length-1;i++){
			//内层循环，逐个比较
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]){
					//换位置
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}

//选择排序
class Select{
	public void sort(int arr[]){
		int temp = 0;
		for (int j = 0; j < arr.length-1; j++) {
			//默认第一个最小
			int min = arr[j];
			//记录最小的数的下标
			int minIndex = j;
			for (int k=j+1; k < arr.length; k++) {
				if (min>arr[k]) {
					min = arr[k];
					minIndex = k;
				}
			}
			//退出for的时候找到最小值
			temp = arr[j];
			arr[j] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
}

//插入排序
class InsertSort{
	public void sort(int arr[]){
		for (int i = 1; i < arr.length; i++) {
			int insertVal = arr[i];
			//insertVal和前一个数比较
			int index = i-1;
			while(index>=0&&insertVal<arr[index]){
				//把arr[index]向后移动
				arr[index+1] = arr[index];
				//让index向前移动
				index--;
			}
			//将insertVal插入适当位置
			arr[index+1] = insertVal;
		}
	}
}