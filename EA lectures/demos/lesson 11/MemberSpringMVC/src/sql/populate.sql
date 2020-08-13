 
INSERT INTO credentials(username,password,enabled) VALUES ('guest','guest', TRUE);
INSERT INTO credentials(username,password,enabled) VALUES ('admin','admin', TRUE);
 
INSERT INTO authority (id,username, authority,credentials_id) VALUES (1,'guest', 'ROLE_USER','guest');
INSERT INTO authority (id,username, authority,credentials_id) VALUES (2,'admin', 'ROLE_ADMIN','admin');
INSERT INTO authority (id,username, authority,credentials_id) VALUES (3,'admin', 'ROLE_USER','admin');

INSERT INTO  `membr` (id,firstname, lastname,age,title,membernumber, member_id) VALUES (1,'Curious','George',12,'Boy Monkey', 8754,'admin');
INSERT INTO `membr` (id,firstname, lastname,age,title,membernumber,member_id) VALUES (2,'Allen','Rench',123,'Torque Master', 8733,'guest');


					