package com.cg.go.service;

//import java.util.ArrayList;
import java.util.List;

import com.cg.go.dao.IGrowthReportRepository;
import com.cg.go.entity.GrowthReportEntity;
import com.cg.go.exception.GrowthReportException;
import com.cg.go.exception.SalesReportException;

public class GrowthReportServiceImpl implements IGrowthReportService {
    private IGrowthReportRepository daoGrowthReport;
    
	@Override
	public List<GrowthReportEntity> findAllGrowthReport() {
		//List<GrowthReportEntity> list=new ArrayList<GrowthReportEntity>();
		return daoGrowthReport.findAllGrowthReport();
		//return list;
	}

	@Override
	public void addGrowthReport() throws SalesReportException {

			daoGrowthReport.addGrowthReport();
	}

	@Override
	public void deleteAllGrowthReport() throws GrowthReportException {
		daoGrowthReport.deleteAllGrowthReport();
		
	}

	@Override
	public void deleteGrowthReportById(Long growthReportId) throws GrowthReportException {
		daoGrowthReport.deleteGrowthReportById(growthReportId);		
	}

}
