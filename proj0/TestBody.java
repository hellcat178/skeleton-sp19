/*
* @Author: hexia
* @Date:   2020-01-17 17:17:29
* @Last Modified by:   hexia
* @Last Modified time: 2020-01-17 17:22:57
*/

public class TestBody  {
	public static void main(String[] args) {
		Body b1 = new Body(0.0,0.0,0.0,0.0,100.0,"1");
		Body b2 = new Body(3.0,4.0,0.0,0.0,100.0,"2");
		System.out.println(b1.calcForceExertedBy(b2));

	}
} 