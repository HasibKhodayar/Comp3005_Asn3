CREATE TABLE STUDENTS
(
	student_id SERIAL PRIMARY KEY,
	first_name Text NOT NULL,
	last_name Text NOT NULL,
	email Text NOT NULL Unique,
	enrollment_date Date
)


INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');
