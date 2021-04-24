package com.cg.go.service;

import com.cg.go.entity.SalesReportEntity;

public interface ISalesReportService {

void updateProductReport(String productId,Integer quantity,double totalSale);
	
	boolean existsByProductId(String productId);
	
	SalesReportEntity findByProductId(String productId);

}
