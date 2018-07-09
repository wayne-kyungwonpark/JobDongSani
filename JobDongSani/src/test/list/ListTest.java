package test.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		strList.add("1");
		strList.add("2");
		strList.add("3");
		strList.add("4");
		strList.add("5");
		strList.add("6");
		strList.add("7");
		List<String> subList = strList.subList(0, 7);
		boolean isSame = strList == subList;
		System.out.println(isSame);
		System.out.println(strList);
		System.out.println(subList.toString());
	}
}
