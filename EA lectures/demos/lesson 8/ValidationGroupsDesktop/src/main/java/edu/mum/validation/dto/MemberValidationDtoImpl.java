package edu.mum.validation.dto;

import edu.mum.domain.Member;
import edu.mum.domain.ProductionStatus;
import edu.mum.domain.workflow.WorkFlowType;

public class MemberValidationDtoImpl implements ValidationDto{

	private Member member;
	WorkFlowType workFlowType = WorkFlowType.MEMBER;
	
	MemberValidationDtoImpl() {}

	public MemberValidationDtoImpl(Member member) {
		this.member = member;
	}
	
	@Override
	public Long getId() {
		return member.getId();
 	}
	
	public WorkFlowType getWorkFlowType() {
		return workFlowType;
	}


	@Override
	public ProductionStatus getStatus() {
		return null;
 	}

	@Override
	public void setStatus(ProductionStatus status) {
		;
		
	}

	@Override
	public Object getValidationObject() {
		 
		return member;
	}

}
