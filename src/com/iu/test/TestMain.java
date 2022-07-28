package com.iu.test;

import java.util.ArrayList;

import com.iu.countries.CountriesDAO;
import com.iu.employees.EmployeesDAO;
import com.iu.regions.RegionsDAO;
import com.iu.regions.RegionsDTO;
import com.iu.regions.RegionsView;
import com.iu.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		
		RegionsDAO regionsDAO = new RegionsDAO();
		CountriesDAO countriesDAO = new CountriesDAO();
		RegionsView regionsView = new RegionsView();
		EmployeesDAO employeesDAO = new EmployeesDAO();
		try {
			//ArrayList<RegionsDTO> ar = regionsDAO.getList();
			//regionsView.view(ar);
			//countriesDAO.getList();
			//RegionsDTO regionsDTO = regionsDAO.getDetail(2);
			//regionsView.view(regionsDTO);
			//countriesDAO.getDetail("KO");
			RegionsDTO regionDTO = new RegionsDTO();
			RegionsDTO regionsDTO;
			regionsDTO.setRegion_id(6);
			regionsDAO.setRegion("Mars");
			regionsDTO.setRegion(regionsDTO); {
				if(result >0) {
					System.out.println("성공");
				}else {
					System.out.println("실패");
				}
			}
			regionsDAO.setRegion(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}