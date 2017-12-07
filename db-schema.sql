DROP TABLE IF EXISTS quizes;
DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS quiz_types;
DROP TABLE IF EXISTS question_types;
DROP TABLE IF EXISTS answer_types;

CREATE TABLE quiz_types (
  id bigserial PRIMARY KEY,
  type_name text UNIQUE
);

CREATE TABLE question_types (
  id bigserial PRIMARY KEY,
  type_name text UNIQUE
);

CREATE TABLE answer_types (
  id bigserial PRIMARY KEY,
  type_name text UNIQUE
);

CREATE TABLE quizes (
  id bigserial PRIMARY KEY,
  quiz_name text NOT NULL,
  author text NOT NULL,
  created_date TIMESTAMP default current_timestamp,
  quiz_type text NOT NULL,
    FOREIGN KEY (quiz_type) REFERENCES quiz_types(type_name)
);

CREATE TABLE questions (
  id bigserial PRIMARY KEY,
  question_string text NOT NULL,
  author text NOT NULL,
  created_date TIMESTAMP default current_timestamp,
  question_type text NOT NULL,
    FOREIGN KEY (question_type) REFERENCES question_types(type_name)
);

CREATE TABLE answers (
  id bigserial PRIMARY KEY,
  answer_string text NOT NULL,
  is_correct BOOLEAN NOT NULL,
  question_id BIGINT NOT NULL,
  answer_type text NOT NULL,
	FOREIGN KEY (question_id) REFERENCES questions(id),
	FOREIGN KEY (answer_type) REFERENCES answer_types(type_name)
);


ALTER TABLE question_types
	ADD CONSTRAINT type_name CHECK (type_name IN ('draft','clean'));
  
ALTER TABLE quiz_types
	ADD CONSTRAINT type_name CHECK (type_name IN ('draft','clean'));