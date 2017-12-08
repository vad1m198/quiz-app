SELECT questions.question_string,questions.author,questions.created_date,questions.question_type,
	answers.answer_string,answers.is_correct,answers.answer_type
FROM questions, answers WHERE answers.question_id = questions.id