package practice;

import java.util.*;

import mob.Pokemon;

public class PracticeClass {
	
	//List
	public void method01() {
		List al = new ArrayList();
		
		Pokemon p =new Pokemon();
		int num = 10;
		String str="hello";
		
		al.add(p);
		al.add(num);
		al.add(str);
		
		System.out.println(al);
		
		// al.add("안녕");
		// al.clear();
		boolean result =  al.contains(p);
		System.out.println(result);
		System.out.println(al);
		
	}
	//Set
	public void method02() {
		System.out.println("set==========");
		
		HashSet s = new HashSet();
		
		s.add("one");
		s.add("two");
		s.add("three");
		s.add(4);
		s.add(5);

		System.out.println(s);
	}

	//Map
	public void method03() {
		System.out.println("map===========");
			
		HashMap map = new HashMap();
		
		map.put("name", "양덕기");
		map.put("name", "피존투");
		map.put("atk", 77);
		map.put("gender", "M");

		
		Object result = map.get("name");
		System.out.println(result); 
		
		map.remove("name");
		
		System.out.println(map);
		
	}
	
	//Stack
	public void method04() {
		
		System.out.println("stack =============== ");
		Stack stack = new Stack();
		
		stack.add("one");
		stack.add("two");
		stack.add("three");
		
		Object result = stack.peek();
		System.out.println(result); 
		
		Object result2 = stack.peek();
		System.out.println(result2); 
		
		System.out.println(stack);
		
	}
		
	//Queue
	public void method05() {
		
		System.out.println("Queue ================");
		
		Queue q = new LinkedList();
		
		q.add("one");
		q.add("two");
		q.add("three");
		
		
		Object result = q.poll();
		System.out.println(result); 
		
		Object result2 = q.poll();
		System.out.println(result2); 
		
		System.out.println(q);
		
		
	}
}
