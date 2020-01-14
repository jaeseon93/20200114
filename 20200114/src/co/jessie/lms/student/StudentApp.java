package co.jessie.lms.student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {
	StudentServiceImpl student = new StudentServiceImpl();
	Scanner sc = new Scanner(System.in);
	StudentDto dto;

	public void selectAll() { // 전체학생 보기
		List<StudentDto> list = new ArrayList<StudentDto>();
		list = student.allStudent();
		studentList(list);
	}

	public void select() {
		dto = new StudentDto();
		System.out.println("검색할 학생의 학번을 입력하세요.");
		dto.setStudent_id(sc.next());
		dto = student.select(dto);
		searchStudentDto(dto);
		sc.next();
	}

	public void insert() {
		dto = new StudentDto();
		boolean b;
		do {
			System.out.println("입력할 학생의 학번을 입력하세요.");
			dto.setStudent_id(sc.nextLine());
			b = student.isCheckId(dto.getStudent_id()); // dto.getStudent_id값을 던져주기.
			if (!b) { //b= false
				System.out.println("이미 존재하는 학번입니다.");
				b = true; //true로 바꿔주기.
			} else {
				System.out.println("입력된 아이디는 사용가능한 학번입니다.");
				break;
			}
		} while(true); //무한 반복
		System.out.println("입력할 학생의 이름을 입력하세요.");
		dto.setStudent_name(sc.nextLine());
		System.out.println("입력할 학생의 학과코드를 입력하세요.");
		dto.setStudent_dept(sc.nextLine());
		System.out.println("입력할 학생의 생년월일을 입력하세요.");
		dto.setStudent_birthday(Date.valueOf(sc.nextLine())); // 타입 맞춰주기.문자열을 날짜형으로 바꿔달라는 뜻.
		int n = student.insert(dto);
		if (n != 0) {
			System.out.println("성공적으로 입력되었습니다.");
			selectAll(); // 전체리스트를 한번 보여달라는 뜻
		} else {
			System.out.println("입력에 실패하였습니다.");
		}
	}

	public void login() {
		System.out.println("학번을 입력하세요.");
		String id = sc.nextLine();
		System.out.println("패스워드를 입력하세요.");
		String pw = sc.nextLine();
		String name = student.loginCheck(id, pw);
		if(name == null) {
			System.out.println("로그인에 실패하였습니다.");
		} else {
			System.out.println(name + "님 환영합니다. ");
		}
	}
	
	
	public void update() {
		dto = new StudentDto();
		System.out.println("업데이트 할 학생의 학번을 입력하세요.");
		dto.setStudent_id(sc.nextLine());
		System.out.println("업데이트 할 학과코드를 입력하세요.");
		dto.setStudent_dept(sc.nextLine());
		int n = student.update(dto);
		if(n) {
			
		}
	}

	private void searchStudentDto(StudentDto dto) {
		System.out.print(dto.getStudent_id() + " ");
		System.out.print(dto.getStudent_name() + " ");
		System.out.print(dto.getStudent_dept() + " ");
		System.out.print(dto.getDept_name() + " ");
		System.out.println(dto.getStudent_birthday() + " ");
	}

	private void studentList(List<StudentDto> list) {
		for (StudentDto dto : list) { // (배열이나 리스트안에 있는 데이터타입을 명시해야함 FOR문안에서만 쓸수 있는 변수이름 : 배열,리스트의 이름 )
										// for문안에 있는 실행구문을 처음부터끝까지 실행.
			System.out.print(dto.getStudent_id() + " ");
			System.out.print(dto.getStudent_name() + " ");
			System.out.print(dto.getStudent_dept() + " ");
			System.out.print(dto.getDept_name() + " ");
			System.out.println(dto.getStudent_birthday() + " ");
		}
	}
}
