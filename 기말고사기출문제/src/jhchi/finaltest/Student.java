package jhchi.finaltest;

public class Student {
	String stdID; //학번

	String stdName; //이름	
	
	public Student(String stdID) { //생성자
		super();
		this.stdID = stdID;
	}

	public Student(String stdID, String stdName) { //생성자
		super();
		this.stdID = stdID;
		this.stdName = stdName;
	}
	
	@Override
	public int hashCode() { //해시코드 오버라이드 -> 같음의 기준 재정의
		// TODO Auto-generated method stub
		return stdID.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Student) {
			Student student = (Student) obj;
			return student.stdID.equals(stdID);
		}
		else
			return false;
	}

	@Override
	public String toString() { //출력
		String str = "학번 : "+this.stdID+" / ";
		str += "이름 : "+this.stdName+"\n";		
		str += "------------------------\n";
		
		return str;
	}

}
