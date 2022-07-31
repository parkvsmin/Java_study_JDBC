package com.iu.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.iu.util.DBConnector;

public class EmployeesDAO {
	
	public void getJoinTest()throws Exception {
		//1.DB연결
		Connection con = DBConnector.getConnection();
		//2.SQL문작성
		String sql = "SELECT E.LAST_NAME,E.SALARY, D.DEPARTMENT_NAME "
				+ "FROM EMPLOYEES E "
				+ "    INNER JOIN "
				+ "    DEPARTMENTS D "
				+ "    ON E.DEPARTMENT_ID = D.DEPARTMENT_ID "
				+ "    WHERE E.EMPLOYEE_ID=?";
		
		//3.미리전송
		PreparedStatement st = con.prepareStatement(sql);
		Object employeesDTO;
		//4.?가 있으면 값 세팅
		st.setInt(1, employeesDTO.getEmployee_id());
		//5.전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next() ) {
			employeesDTO = new EmployeesDTO();
			employeesDTO.setLast_name(rs.getString("LAST_NAME"));
			employeesDTO.setSalary(rs.getInt("SALARY"));
			DepartmentsDTO dt = new DepartmentsDTO();
			dt.setDepartment_name(rs.getString("department_name"));
			
			
		}
		//6.연결해제
	}
	
	public void getSalaryInfo() throws Exception {
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		//2. SQL문작성
		String sql = "SELECT SUM(SALARY), AVG(SALARY), MAX(SALARY) FROM EMPLOYEES";
		//3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		//4. ?가 있으면 값 세팅 
		
		//5. 최종 전송 후 결과처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			int sum = rs.getInt("SUM(SALARY)");
			double avg = rs.getDouble(2); //인덱스번호
			int max = rs.getInt("MAX");
			System.out.println(sum);
			System.out.println(avg);
			System.out.println(max);
		}
		
		//6.자원 해제
		DBConnector.disConnect(rs, st, con);
		
	}

}