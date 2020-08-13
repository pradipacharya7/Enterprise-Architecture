package edu.mum.workflow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import edu.mum.domain.ProductionStatus;
import edu.mum.domain.UserCredentials;
import edu.mum.domain.workflow.WorkFlowQueue;
import edu.mum.domain.workflow.WorkFlowType;
import edu.mum.service.CredentialsService;
import edu.mum.service.WorkFlowQueueService;
import edu.mum.validation.dto.ValidationDto;

/*
 * This is the workflow process
 * The MAIN entry point is the method: public void ProcessWorkflowItem
 *                It is INVOKED from the ServiceVallidationAspect.
 *                It has 2 [private] helper methods: manageWorkQueue & determineOwner
 *  The other public method is: 
 *  		public ProductionStatus setProductStatus
 *          It is INVOKED from the ServiceVallidationAspect.
 */

@Component
public class WorkFlowProcess {
	

	@Autowired
	CredentialsService credentialsService;

	@Autowired
	WorkFlowQueueService workFlowQueueService;

	public void ProcessWorkflowItem(ValidationDto validationDto) {
		  
  		this.manageWorkQueue(validationDto);
  	
  		return;
  	
	}
 
//------------------     HELPER METHODS    ----------------------------------

/*
 *  Enter domain object[ValidationDto] on appropriate work queue
 *  
 */
@SuppressWarnings("unchecked")
private void manageWorkQueue(ValidationDto validationDto) {
	Long validationDtoId = validationDto.getId();
	WorkFlowType workFlowType = validationDto.getWorkFlowType();
	
	ProductionStatus validationDtoStatus = validationDto.getStatus();
	WorkFlowQueue workFlowQueue;

	UserCredentials owner = this.determineOwner(validationDtoId, validationDtoStatus);
	workFlowQueue = workFlowQueueService.findByMember(owner.getMember());

    switch (validationDtoStatus) {
 
    	case BASIC:
			workFlowQueue.getQueue(workFlowType).add(validationDtoId);
    		break;

		case DETAILS:
		   	// Remove Admin element from queue
 			workFlowQueue.getQueue(workFlowType).remove(validationDtoId);

	    	//Add Supervisor element to Queue
	    	owner = owner.getMember().getSupervisor().getUserCredentials();
			workFlowQueue = workFlowQueueService.findByMember(owner.getMember());
			workFlowQueue.getQueue(workFlowType).add(validationDtoId);

			break;
			
		case PRODUCTION:
			workFlowQueue.getQueue(workFlowType).remove(validationDtoId);

		default:
			break;
   
    }
}

/*
 * Determine NEW owner...to associated with Domain Object
 */
private UserCredentials determineOwner(Long id, ProductionStatus status) {
	UserCredentials owner = null;

    switch (status) {
    // "Round robin" assignment to ROLE_ADMIN
  	case BASIC:
    	List<UserCredentials> credentials = credentialsService.findAllAdmin();
     	Long ownerIndex =  id % credentials.size();
     	 owner = credentials.get(ownerIndex.intValue());
		break;

		case DETAILS:
		case PRODUCTION:
			// Logged in user is current owner - want to find him;
			String userName = ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
			owner = credentialsService.findOne(userName);
			break;
		default:
	    	 owner = null;

    }

 	return owner;
}

/*
 * Move the status to NEXT state
 */
public ProductionStatus setProductStatus(ValidationDto validationDto) {
    ProductionStatus returnStatus = null;
	ProductionStatus currentStatus  = validationDto.getStatus();

   switch (currentStatus) {
   case INVALID:
	   returnStatus = ProductionStatus.BASIC;
	   break;
	case BASIC:
		returnStatus = ProductionStatus.DETAILS;
		break;

	case DETAILS:
	case PRODUCTION:
		returnStatus =  ProductionStatus.PRODUCTION;

   }

   validationDto.setStatus(returnStatus);

   return returnStatus;

  }

}