package co.jessie.lms.student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
	public List<StudentDto> allStudent();
	public StudentDto select(StudentDto dto);
	public int insert(StudentDto dto);
	public int update(StudentDto dto);
	public int delete(StudentDto dto);
}
