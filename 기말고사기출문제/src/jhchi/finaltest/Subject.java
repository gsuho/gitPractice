package jhchi.finaltest;

import java.util.HashSet;

public class Subject implements Comparable<Subject>  {
//	comparable을 사용해서 compareTo를 오버라이드 
//	->과목코드기준으로 정렬하기 위함.
	String subID; //과목 번호
	String subName; //과목 이름
	HashSet<Student> stdset = new HashSet<>(); // 수강생 저장구조
//	hashset은 hashcode()랑 equals()를 오버라이드해서 같은것에대한 조건을 만들어 줘야함.
	
	public Subject(String subID) {
		this(subID, null);		
	}

	public Subject(String subID, String subName) {
		super();
		this.subID = subID;
		this.subName = subName;
	}
	
	public void register(Student std) {
		if(!stdset.contains(std)) { 
			//contains와 student클래스의 hashcode()랑 equals()로 같음의 기준을 재정의
			System.out.println("수강 등록이 잘 되었습니다.");
			stdset.add(std);
		}else {
			System.out.println("이미 수강 등록 되어 있습니다.");
		}
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "과목번호 : "+ this.subID+"\n";
		str += "과목이름 : "+this.subName+"\n";
		str+= "등록 학생 명단\n";
		str+= "------------------------\n";
		
		for(Student std : stdset) { 
			//set에 저장된 요소 꺼내서 출력할때 이렇게 하기
			str += std.toString();
		}
		return str;
	}
// 같은 과목의 기준을 과목코드로 해주기 위한 메소드
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Subject) {
			Subject subject = (Subject) obj;
			return subject.subID.equals(subID);
		}
		else
			return false;
	}

@Override
public int compareTo(Subject s) {
	// TODO Auto-generated method stub
	return this.subID.compareTo(s.subID);
}

//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return subID.hashCode();
//	}
	

	
	
}
