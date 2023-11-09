package test;

import java.util.*;

import mob.Pokemon;

public class Test {
	
	//List (인덱스로 요소들을 관리)
	public void method01() {
		System.out.println("리스트=================");
		List al = new ArrayList();
		
		//데이터 삽입
		Pokemon p = new Pokemon();
		al.add(p);
		
		//데이터 사용
		Object result =al.get(0);
		System.out.println(result);
		
	}
	//Set (중복 X)
	public void method02() {
		System.out.println("Set===============");
		
		Set s = new HashSet();
		
		//데이터 삽입
		s.add(new Pokemon());
		
		//데이터 사용
		System.out.println(s);
		
	}

	//Map (key - value 쌍으로 데이터를 관리) /key는 중복 X
	public void method03() {
		
		System.out.println("Map==============");
		
		Map m = new HashMap();
		
		//데이터 삽입
		m.put("first", new Pokemon());
		
		//데이터 사용
		Object result =m.get("first");
		System.out.println(result);
		
	}
	
	//Stack (LIFO)
	public void method04() {
		System.out.println("Stack===========");
		
		Stack s = new Stack();
		
		//데이터 삽입
		s.add(new Pokemon());
		
		
		//데이터 사용
		Object result =s.pop();
		System.out.println(result);
		
	}
		
	//Queue (FIFO)
	public void method05() {
		System.out.println("Queue===============");
		
		 LinkedList q = new LinkedList();
		
		//데이터 삽입
		q.add(new Pokemon());
		
		
		//데이터 사용 //q.poll();
		Object result =q.poll();
		System.out.println(result);
		
		
	}
	
}
