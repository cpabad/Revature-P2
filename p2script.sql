-- Ctrl+a then ctrl+enter to reset tables
DROP TABLE user_comment;
DROP TABLE lesson;
DROP TABLE course;
DROP TABLE users;

------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE users(
	userId serial PRIMARY KEY,
	email varchar NOT NULL UNIQUE,
	user_password varchar NOT NULL,
	first_name varchar NOT NULL,
	last_name varchar NOT NULL
);
INSERT INTO users values(DEFAULT,'a@email.com','userpass','John', 'Smith');
INSERT INTO users values(DEFAULT,'b@email.com','userpass','Maggie', 'Rose');
INSERT INTO users values(DEFAULT,'c@email.com','userpass','Kara', 'Hill');
INSERT INTO users values(DEFAULT,'d@email.com','userpass','Ross', 'Hawkins');
INSERT INTO users values(DEFAULT,'e@email.com','userpass','Dale', 'Herrera');
INSERT INTO users values(DEFAULT,'f@email.com','userpass','Hubert', 'Butler');
INSERT INTO users values(DEFAULT,'g@email.com','userpass','Marion', 'Crawford');
INSERT INTO users values(DEFAULT,'h@email.com','userpass','Elijah', 'Munoz');
INSERT INTO users values(DEFAULT,'i@email.com','userpass','Danny', 'Tyler');
INSERT INTO users values(DEFAULT,'j@email.com','userpass','Oliver', 'Casey');

CREATE TABLE course(
	courseId serial PRIMARY KEY,
	title varchar NOT NULL,
	creator integer REFERENCES users(userId),
	student integer REFERENCES users(userId),
	description varchar,
	public_access boolean,
	access_code integer
);
INSERT INTO course values(DEFAULT, 'Basic Computer Skills', 1, 2, 'Learning how to create folders, cut and paste, copy and paste, and undo', 'true', 0);
INSERT INTO course values(DEFAULT, 'Cooking Basics', 2, 1, 'Learning how to boil, scramble, and poach an egg', 'true', 5432);
INSERT INTO course values(DEFAULT, 'Cooking Basics', 2, 3, 'Learning how to boil, scramble, and poach an egg', 'true', 5432);
INSERT INTO course values(DEFAULT, 'Advanced Computer Skills', 1, 2, 'Learning how to create files, remove files using the terminal, and copy files using the terminal', 'false', 8080);
INSERT INTO course values(DEFAULT, 'Advanced Computer Skills', 1, 3, 'Learning how to create files, remove files using the terminal, and copy files using the terminal', 'false', 8080);

CREATE TABLE lesson(
	lessonId serial PRIMARY KEY,
	title varchar NOT NULL,
	courseId integer REFERENCES course(courseId),
	file_location varchar
);
INSERT INTO lesson values(DEFAULT,'Create a new folder',1,'howtocreatefolder.mp4');
INSERT INTO lesson values(DEFAULT,'Cut, Copy, Paste',1,'cutcopypaste.mp4');
INSERT INTO lesson values(DEFAULT,'How to undo deletions',1,'undodeletions.mp4');
INSERT INTO lesson values(DEFAULT, 'How to boil an egg', 2, 'location 1');
INSERT INTO lesson values(DEFAULT, 'How to scramble an egg', 2, 'location 2');
INSERT INTO lesson values(DEFAULT, 'How to poache an egg', 2, 'location 3');
INSERT INTO lesson values(DEFAULT, 'How to create a file', 4, 'location 4');
INSERT INTO lesson values(DEFAULT, 'How to remove files using the terminal', 4, 'location 5');
INSERT INTO lesson values(DEFAULT, 'How to copy files using the terminal', 4, 'location 6');

CREATE TABLE user_comment(
	commentId serial PRIMARY KEY,
	lessonId integer REFERENCES lesson(lessonId),
	authorId integer REFERENCES users(userId),
	lesson_comment varchar NOT NULL,
	comment_date timestamp NOT NULL,
	like_counter integer,
	dislike_counter integer
);
INSERT INTO user_comment values(DEFAULT, 1,1,'If I could I would. Wether or not I should, I still would.',current_timestamp,0,0);
INSERT INTO user_comment values(DEFAULT, 1,2,'If I roll once and you roll twice. What does that mean?',current_timestamp,0,0);
INSERT INTO user_comment values(DEFAULT, 1,3,'Microsoft bought Skype for 8,5 billion!.. what a bunch of idiots! I downloaded it for free!',current_timestamp,0,0);
INSERT INTO user_comment values(DEFAULT, 2,4,'Life is full of temporary situations, ultimately ending in a permanent solution.',current_timestamp,0,0);
INSERT INTO user_comment values(DEFAULT, 2,5,'A good lawyer knows the law; a clever one takes the judge to lunch.',current_timestamp,0,0);
INSERT INTO user_comment values(DEFAULT, 2,6,'lol',current_timestamp,0,0);
INSERT INTO user_comment values(DEFAULT, 3,7,'Why go to college? Theres Google.',current_timestamp,0,0);
INSERT INTO user_comment values(DEFAULT, 3,9,'A good lawyer knows the law; a clever one takes the judge to lunch.',current_timestamp,0,0);