-- SQL statements which are executed at application startup if hibernate.hbm2ddl.auto is 'create' or 'create-drop'
INSERT INTO Person (id, birthday, name) VALUES (1, '2011-01-01', 'Person 1');
INSERT INTO ContactInfo (id, contact_type, contact_value, contact_id) VALUES (1, 'TELEPHONE', '+55-61-5555-1111', 1);
INSERT INTO ContactInfo (id, contact_type, contact_value, contact_id) VALUES (2, 'EMAIL', 'person1@redhat.com', 1);
INSERT INTO ContactInfo (id, contact_type, contact_value, contact_id) VALUES (3, 'EMAIL', 'person1@hotmail.com', 1);

INSERT INTO Person (id, birthday, name) VALUES (2, '2011-02-02', 'Person 2');
INSERT INTO ContactInfo (id, contact_type, contact_value, contact_id) VALUES (4, 'TELEPHONE', '+55-61-5555-2222', 2);
INSERT INTO ContactInfo (id, contact_type, contact_value, contact_id) VALUES (5, 'EMAIL', 'person2@redhat.com', 2);

INSERT INTO Person (id, birthday, name) VALUES (3, '2011-03-03', 'Person 3');
INSERT INTO ContactInfo (id, contact_type, contact_value, contact_id) VALUES (6, 'EMAIL', 'person3@redhat.com', 3);
INSERT INTO ContactInfo (id, contact_type, contact_value, contact_id) VALUES (7, 'EMAIL', 'person3@hotmail.com', 3);

INSERT INTO Person (id, birthday, name) VALUES (4, '2011-04-04', 'Person 4');
INSERT INTO ContactInfo (id, contact_type, contact_value, contact_id) VALUES (8, 'TELEPHONE', '+55-61-5555-4444', 4);

INSERT INTO Person (id, birthday, name) VALUES (5, '2011-05-05', 'Person 5');
INSERT INTO ContactInfo (id, contact_type, contact_value, contact_id) VALUES (9, 'TELEPHONE', '+55-61-5555-5555', 5);
INSERT INTO ContactInfo (id, contact_type, contact_value, contact_id) VALUES (10, 'EMAIL', 'person5@redhat.com', 5);
