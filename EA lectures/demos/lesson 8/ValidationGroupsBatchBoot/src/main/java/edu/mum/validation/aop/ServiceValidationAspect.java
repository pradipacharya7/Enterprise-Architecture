package edu.mum.validation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.domain.Member;
import edu.mum.domain.Product;
import edu.mum.domain.ProductionStatus;
import edu.mum.domain.workflow.WorkFlowQueue;
import edu.mum.service.WorkFlowQueueService;
import edu.mum.validation.GenericValidator;
import edu.mum.validation.dto.MemberValidationDtoImpl;
import edu.mum.validation.dto.ProductValidationDtoImpl;
import edu.mum.validation.dto.ValidationDto;
import edu.mum.workflow.WorkFlowProcess;

@Aspect
@Component
public class ServiceValidationAspect {


	@Autowired
	GenericValidator   genericValidator; 
	
	@Autowired
	WorkFlowProcess workFlowProcess;

	// ALL service methods...
	 @Pointcut("execution(* edu.mum.service..*(..))")
	    public void applicationMethod() {}

	   @Pointcut("@annotation(edu.mum.validation.aop.ServiceValidation)")
	    public void validate() {}
	
	   // Save & Update contain domain  Object
		 @Pointcut("args(object)")
		    public void argsMethod(Object object) {}

    @Around("validate() && applicationMethod() && argsMethod(object)")	
    public void  doValidate( ProceedingJoinPoint joinPoint, Object object) throws Throwable {
     	
    	String objectName = object.getClass().getSimpleName();
    	ValidationDto validationDto = null;
    	
    	switch (objectName) {
    		
		case "Product" :
			validationDto = new ProductValidationDtoImpl((Product)object);
			
 			break;
// If we were doing member also
		case "Member" :
			validationDto = new MemberValidationDtoImpl((Member)object);

 		}
 
		genericValidator.doValidate(joinPoint, validationDto);

   		ProductionStatus newStatus = workFlowProcess.setProductStatus(validationDto); 
    	System.out.println("Validation Success! setting Status to: " + newStatus);

     
       	/*
         * THIS is the AROUND part of the ASPECT
         * We have finished the "Before"
         * Now, Execute Lower priority Aspects &
       	 * THEN execute the join point code
       	 * that is, the SAVE or  UPDATE

       	 */
       joinPoint.proceed(new Object[]{validationDto.getValidationObject()}); 
       
       
       /*
       * "AFTER" joinpoint - complete the @Around by Updating work Queue
       *  If it is Valid in the current state [i.e., ProductStatus] 
       *  THEN move to the Status...to continue processing...
       */
    
       workFlowProcess.ProcessWorkflowItem(validationDto);

     }

}

 


