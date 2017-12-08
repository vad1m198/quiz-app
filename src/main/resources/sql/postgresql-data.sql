  INSERT INTO quiz_types(type_name)
  	VALUES ('clean'),('draft');

  INSERT INTO question_types(type_name)
  	VALUES ('clean'),('draft');

  INSERT INTO answer_types(type_name)
  	VALUES ('clean'),('draft');

INSERT INTO quizes (quiz_name,author,quiz_type)
	VALUES ('default','admin','clean');

INSERT INTO questions (question_string,author,question_type )
	VALUES ('Which two statements are correct about External ID?','admin','clean'),
		   ('UC is hearing complaints from users that recently released changes are breaking existing functionality. What Type of testin should a Technical Architect implement to reduce this complaint?','admin','clean'),
		   ('UC has complex data transformation, error handling and process automation requirements as part as their integration strategy. What technology should an Architect recommend in order to minimize Salesforce code customizations?','admin','clean');
	
	INSERT INTO quizes_questions (quiz_id,question_id)
	VALUES ('1','1'),('1','2'),('1','3');

INSERT INTO answers (answer_string,is_correct,question_id,answer_type)
	VALUES ('External IDs must be Text fields','false','1','clean'),('External IDs are always searchable','true','1','clean'),
	       ('External IDs fields are always unique','false','1','clean'),('External IDs can be used to upsert records','true','1','clean'),
		   ('Performance Testing','false','2','clean'),('Unit Testing','false','2','clean'),
	       ('Regression Testing','true','2','clean'),('User Acceptance Testing','false','2','clean'),
		   ('Data Loader','false','3','clean'),('Canvas','false','3','clean'),
	       ('Process Builder','false','3','clean'),('Middleware','true','3','clean');

