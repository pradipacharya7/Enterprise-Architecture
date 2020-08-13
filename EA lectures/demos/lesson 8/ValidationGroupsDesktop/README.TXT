

FOLLOW ON TO BATCH Process [ValidationGroupsBatch]..This is interactive part.,...
NOTE NEED TO RUN BATCH Process FIRST!!!!
ValidationGroupsBatch

Validation OF core data.

Composite validation:   EmptyOrSize; NullMinNumber

AOP to run validation based on Service methods
Methods annotated with @ServiceValidation : e.g. Save; Update


AOP is an AROUND type AOP
When AOP has been  "activated":
   Validates domain object [BEFORE]
   Executes join point [SAVE or UPDATE domain object]
   Runs the workflow process [AFTER]
 

Validate has also been put in to Hierarchical groups ...See Product...

(1,'ROLE_ADMIN','Sean','Sean'),
 (2,'ROLE_ADMIN','Bill','Bill'),
 (3,'ROLE_SUPERVISOR','Pete','Pete'),
 (4,'ROLE_SUPERVISOR','Paul','Paul');
 (5,'ROLE_SUPERVISOR','Batch','Batch')
 
 Pete SUPERVISES Bill
 Paul SUPERVISES Sean
  
	 EOD Batch job Loads the products with INVALID Status
	 If product "passes" default validation
	 	product is set to BASIC status & assigned to an Admin [Sean or Bill]
	 Admin "fixes" product
	  If product "passes" details validation
	 	   product is set to DETAILS  status & assigned to the Admin's Supervisor
	 Supervisor "fixes" product
	       product is set to Production status
 
 WorkFlow Setup:
 NOTE: CURRENTLY Classes are shared between BATCH & DESKTOP projects!!! Need to be updated in BOTH Places
WorkFlowQueue Domain Object [in edu.mum.domain.workflow]
 			Look in Class to see description of functionality
 			Populated at BATCH start up through data_member_workflow_queue.sql [BATCH version only]
WorkFlowType ENUM [in edu.mum.domain.workflow]
			Used to identify Target domain Object being validated [set in appropriate ValidationDto]
WorkFlowProcess [in edu.mum.workflow]
			Manages the state transitions & task assignment to Process users [BATCH,ADMIN,SUPERVISOR]

To Add a new Validaton Target [Product,Member are current as targets] for Validation Processing:
			Create ValidationDto [in AOP aspect]
			Modify WorkFlowQueue - add new ElementCollection [e.g. see memberQueue, productQueue]
			Modify WorkFlowQueue getQueue method to recognize new Domain Object
			Modify data_member_workflow_queue.sql to recognize it [BATCH version only]