package jhchi.finaltest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubjectManager {
	String deptName; // 학과명
	List<Subject> sublist = new ArrayList<>(); // 과목 저장하기 위한 리스트

	SubjectManager(String deptName) {// 생성자
		this.deptName = deptName;
	}

	void addSubject(Subject sub) {
		if (sublist.size() > 0) {
			if (sublist.contains(sub)) {
//				contains쓸때는 hashcode랑 equals오버라이드 해서 쓰는게 맞는듯.
//				equals쓸때도 마찬가지 일수도
//				그런데 여기서는 equals만 오버라이드 해도 되는듯..
				System.out.println("이미 등록된 과목입니다.");
			} else {
				System.out.println("과목 등록이 완료되었습니다.");
				sublist.add(sub);
			}
		} else {
			System.out.println("과목 등록이 완료되었습니다.");
			sublist.add(sub);
		}
		
	}

	Subject findSubject(String subID) {
		Collections.sort(sublist);
		int index = Collections.binarySearch(sublist, new Subject(subID));
		Subject finding =sublist.get(index);
		return finding;
	}

	List<Subject> findStudent(String stdID) {
		List<Subject> subjects = new ArrayList<>();
		for(Subject sub : sublist) {
			if(sub.stdset.contains(new Student(stdID))) { 
				//새로운 생성자 만듦.
				subjects.add(sub);
			}
		}
		
		return subjects;
	}

	@Override
	public String toString() {

		String str = "학과명 : " + this.deptName + "\n";
		str += "개설 과목 현황\n";
		str += "=========================\n";
		for (Subject sub : sublist) {
			str += sub.toString();
		}
		return str;
	}

	public Subject getMaxSubject() {
		Subject findingSubject = null;
//		int maxsize=0;
//		
//		for(Subject sub : sublist) {
//			if(sub.stdset.size()>maxsize) {
//				maxsize= sub.stdset.size();
//				findingSubject =sub;
//			}
//		}
		findingSubject = sublist.stream() //스트림
		        .sorted((sub1, sub2) -> Integer.compare(sub2.stdset.size(), sub1.stdset.size()))
		        .findFirst()
		        .orElse(null);

		return findingSubject;
	}
}
