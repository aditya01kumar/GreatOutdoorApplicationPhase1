package com.cg.go.service;

import java.util.List;

import com.cg.go.dao.ISalesReportRepository;
import com.cg.go.entity.SalesReportEntity;
import com.cg.go.exception.SalesReportException;

public class SalesReportServiceImpl implements ISalesReportService {
	private ISalesReportRepository daoSalesReport;

	@Override
	public void updateProductReport(String productId, Integer quantity, double totalSale) {
	
		
	}

	@Override
	public boolean existsByProductId(String productId) {

		return false;
	}

	@Override
	public SalesReportEntity findByProductId(String productId) {
	
		return null;
	}

}
