  INSERT INTO quiz_types(type_name)
  	VALUES ('clean'),('draft');

  INSERT INTO question_types(type_name)
  	VALUES ('clean'),('draft');

  INSERT INTO answer_types(type_name)
  	VALUES ('clean'),('draft');

INSERT INTO quizes (quiz_name,author,quiz_type)
	VALUES ('default','admin','clean');

INSERT INTO questions (question_string,author,question_type )
	VALUES ('Which two statements are correct about External ID?','admin','clean');

INSERT INTO answers (answer_string,is_correct,question_id,answer_type)
	VALUES ('External IDs must be Text fields','false','1','clean'),('External IDs are always searchable','true','1','clean'),
	       ('External IDs fields are always unique','false','1','clean'),('External IDs can be used to upsert records','true','1','clean');

