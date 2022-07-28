package com.iu.test;

import java.util.ArrayList;

import com.iu.countries.CountriesDAO;
import com.iu.regions.RegionsDAO;
import com.iu.regions.RegionsDTO;
import com.iu.regions.RegionsView;
import com.iu.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
		
		RegionsDAO regionsDAO = new RegionsDAO();
		CountriesDAO countriesDAO = new CountriesDAO();
		RegionsView regionsView = new RegionsView();
		try {
			ArrayList<RegionsDTO> ar = regionsDAO.getList();
			regionsView.view(ar);
			//countriesDAO.getList();
			//RegionsDTO regionsDTO = regionsDAO.getDetail(2);
			//regionsView.view(regionsDTO);
			//countriesDAO.getDetail("KO");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}