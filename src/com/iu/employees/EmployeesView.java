package com.iu.employees;

import java.util.ArrayList;

public class EmployeesView {
	
	public void view(ArrayList<EmployeesDTO> arr) {
		System.out.println("Eid\tF_Name\t\tL_Name\t\tEmail\tPhone_Number\tHire_Date\tJob_Id\tSalary\tPCT\tMId\tDId");
		for(EmployeesDTO dto: arr) {
			System.out.println(dto.getEmployee_id()+"\t"+dto.getFirst_name()+"\t\t"+dto.getLast_name()+"\t\t"+dto.getEmail()+"\t"+dto.getPhone_number()+"\t"
					+dto.getHire_date()+"\t"+dto.getJob_id()+"\t"+dto.getSalary()+"\t"+dto.getCommission_pct()+"\t"+dto.getManager_id()+"\t"+dto.getDepartment_id());
		}
	}
	
	public void view(EmployeesDTO dto) {
		System.out.println("Eid\tF_Name\t\tL_Name\t\tEmail\tPhone_Number\tHire_Date\tJob_Id\tSalary\tPCT\tMId\tDId");
		System.out.println(dto.getEmployee_id()+"\t"+dto.getFirst_name()+"\t\t"+dto.getLast_name()+"\t\t"+dto.getEmail()+"\t"+dto.getPhone_number()+"\t"
				+dto.getHire_date()+"\t"+dto.getJob_id()+"\t"+dto.getSalary()+"\t"+dto.getCommission_pct()+"\t"+dto.getManager_id()+"\t"+dto.getDepartment_id());
	}
}