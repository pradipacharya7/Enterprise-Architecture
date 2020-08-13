package edu.mum.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.builder.AddressBuilder;
import edu.mum.builder.MemberBuilder;
import edu.mum.domain.Address;
import edu.mum.domain.Member;
import edu.mum.service.AddressService;
import edu.mum.service.MemberService;

public class Main {
  public static void main(String[] args) {

    ApplicationContext ctx = new ClassPathXmlApplicationContext(
        "context/applicationContext.xml");

    AddressService addressService = (AddressService) ctx.getBean("addressServiceImpl");
    MemberService memberService = (MemberService) ctx.getBean("memberServiceImpl");

  
     	  Address address =  new AddressBuilder()
    		   .withCity("Batavia")
    		   .withState("Iowa")
     		   .build();
    	  addressService.save(address);

    	 Member member =  new MemberBuilder()
    	      	.withFirstName("Sean")
    	    	.withLastName("Smith")
    	    	.withAddress(address)
    	    	.withMemberNumber(1)
    	    	.build();     	      
 
     // Address is NOT updated with FK - so will NOT be saved
    // good practice - SET BOTH SIDES -
    	 //   	 ADD THIS so when Address is saved [cascade] it will have Member FK:
    	 //		address.setMember(member);
    	 member = memberService.update(member);
   
   member = memberService.findOne(member.getId());
   
   System.out.println();
   System.out.println("***********       Save Member ONLY - saves address  BUT no FK **************");

   System.out.println("Member Name : " + member.getFirstName() + "  " +  member.getLastName() );

   // No Addresses will Show up
   for (Address addresse : member.getAddresses()) {
       System.out.println("Address : " + addresse.getCity() + 
				"   " + addresse.getState());
   }


 //--------------------------------------------------------------------
  
	  address =  new AddressBuilder()
			.withCity("Red Rock")
			.withState("Iowa")
			.build();
	  addressService.save(address);
     
	member.getAddresses().add(address);
    memberService.update(member);
   
    member = memberService.findOne(member.getId());

    System.out.println();
    System.out.println("***********       Add Second  Address  **************");
    System.out.println("Member Name : " + member.getFirstName() + "  " +  member.getLastName() );

    for (Address addresse : member.getAddresses()) {
        System.out.println("Address : " + addresse.getCity() + 
 				"   " + addresse.getState());
    }

    address = addressService.findOne(address.getId());

    memberService.findOne(address.getMemberId());
    System.out.println();
    System.out.println("***********    - USE member findOne to get Member reflected in Address's FK  **************");
    System.out.println("Member Name : " + member.getFirstName() + "  " +  member.getLastName() );
    System.out.println();
 
    // Get Member for Address...SPECIAL NATIVE METHOD
     member = memberService.findByAddressNative(address.getId());
     System.out.println();
     System.out.println("***********    - USE NATIVE METHOD = get Member for Address  **************");
     System.out.println("Member Name : " + member.getFirstName() + "  " +  member.getLastName() );


  }
  
  }