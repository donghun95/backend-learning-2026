package week_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Colletctionpractice {
	
	public static void main(String[] args) {
		System.out.println("List 테스트");
		// List: 순서가 있고, 중복을 허용합니다. (대기줄, 리스트)
		List<String> list = new ArrayList<>();
		list.add("사과");
		list.add("바나나");
		list.add("사과");
		System.out.println("List 출력 : " + list);
		System.out.println("List 첫번째 출력" + list.get(0));
		System.out.println("List 첫번째 출력" + list.size());
		System.out.println("List 첫번째 출력" + list.get(2));
		
		System.out.println();
		
		System.out.println("Set 테스트");
		// Set: 순서가 없고, 중복을 허용하지 않습니다. 
		Set<String> set = new HashSet<>();
		set.add("사과");
		set.add("바나나");
		set.add("사과");
		
		System.out.println("Set 출력: " + set);
		System.out.println("Set 크기(데이터 개수): " + set.size());
		Iterator<String> iterSet = set.iterator();
		while(iterSet.hasNext()) {
			System.out.println(iterSet.next()+ " ");
			
		}
		
		
		System.out.println();
		System.out.println("Map 테스트");
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "홍길동");
		map.put(2, "대길동");
		map.put(3, "삼길동");
		
		
		System.out.println("Map 출력: " + map);
		System.out.println("Key 2번의 Value:" + map.get(2));
		
	}

}
