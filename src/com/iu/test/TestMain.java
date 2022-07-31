package com.iu.test;

import java.util.ArrayList;

import com.iu.countries.CountriesDAO;
import com.iu.countries.CountriesDTO;
import com.iu.countries.CountriesView;
import com.iu.employees.EmployeesDAO;
import com.iu.employees.EmployeesDTO;
import com.iu.employees.EmployeesView;
import com.iu.regions.RegionsDAO;
import com.iu.regions.RegionsDTO;
import com.iu.regions.RegionsView;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<RegionsDTO> arr = new ArrayList<>();
		ArrayList<CountriesDTO> arr1 = new ArrayList<>();
		ArrayList<EmployeesDTO> arr2 = new ArrayList<>();
		RegionsDTO regionsDTO = new RegionsDTO();
		CountriesDTO countriesDTO = new CountriesDTO();
		EmployeesDTO employeesDTO = new EmployeesDTO();
		RegionsDAO dao = new RegionsDAO();
		CountriesDAO countriesDAO = new CountriesDAO();
		EmployeesDAO employeesDAO = new EmployeesDAO();
		RegionsView rv = new RegionsView();
		CountriesView cv = new CountriesView();
		EmployeesView ev = new EmployeesView();
		try {
			arr = dao.getList();
			rv.view(arr);
			System.out.println("===============================");
			regionsDTO = dao.getDetail(1);
			rv.view(regionsDTO);
			System.out.println("===============================");
			arr1 = countriesDAO.getList();
			cv.view(arr1);
			System.out.println("===============================");
			countriesDTO = countriesDAO.getDetail("US");
			cv.view(countriesDTO);
			System.out.println("===============================");
			arr2 = employeesDAO.getList();
			ev.view(arr2);
			System.out.println("===============================");
			employeesDTO = employeesDAO.getDetail(100);
			ev.view(employeesDTO);
			System.out.println("===============================");
			employeesDAO.getSalaryInfo();
			System.out.println("===============================");
			RegionsDTO dto = new RegionsDTO();
			dto.setRegionId(6); dto.setRegionName("Mars");
			int row = dao.setRegion(dto);
			if(row > 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			System.out.println("===============================");
			countriesDTO.setCountryId("PO");
			countriesDTO.setCountryName("Portugal");
			countriesDTO.setRegionId(1);
			row = countriesDAO.setCountries(countriesDTO);
			if(row > 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}