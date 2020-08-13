package edu.mum.validation.dto;

import edu.mum.domain.ProductionStatus;
import edu.mum.domain.workflow.WorkFlowType;

/*
 * Wrapper interface to avoid Reflection in ServerValidationProcess
 * Accesses domain object [ Product, Member,..specific info necessary for process]
 */
		
	
public interface ValidationDto {

	public Long getId();
	public ProductionStatus getStatus();
	public void setStatus(ProductionStatus status);
	
	public Object getValidationObject();
	
	public WorkFlowType getWorkFlowType();


}
