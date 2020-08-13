
Implements  one To Many bidirectional functionality using unidirectional One to Many  JoinColumn  
Association is Member --> Address

Like OneToManyBiCol...example

You can declare the Fk in Address to access from the domain Object
You can then get the Member associated with the Address by using the member findOne
  AS AN ALTERNATIVE
 There is a special NATIVE SQL method findByAddressNative
 to get member for Address [ see MemberDaoImpl]
 In this way,  we can directly access the foreign key WITHOUT declaring the FK in the Address Domain object/
 
 See OneToManyBiColManyToOne for unidirectional Address --> Member 