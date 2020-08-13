package edu.mum.validation.dto;

import edu.mum.domain.Product;
import edu.mum.domain.ProductionStatus;
import edu.mum.domain.workflow.WorkFlowType;

public class ProductValidationDtoImpl implements ValidationDto{

	private Product product;
	WorkFlowType workFlowType = WorkFlowType.PRODUCT;
	
	
	ProductValidationDtoImpl() {}

	public ProductValidationDtoImpl(Product product) {
		this.product = product;
	}
	
	@Override
	public Long getId() {
		return product.getId();
 	}

	public WorkFlowType getWorkFlowType() {
		return workFlowType;
	}

	@Override
	public ProductionStatus getStatus() {
		return product.getStatus();
 	}

	@Override
	public void setStatus(ProductionStatus status) {
		product.setStatus(status);
		
	}

	@Override
	public Object getValidationObject() {
		 
		return product;
	}

}
