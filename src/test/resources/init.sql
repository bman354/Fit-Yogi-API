USE fityogimomma;

/*
due to the structure of the DB, I couldnt figure out how to drop everything
without foreign key errors, this is a hackey workaround to make sure all tables
exist, truncate all data out of the database, then drop the truncated tables

this ensures that when the tables are created any data left behind is
removed, and tables are recreated cleanly for re-initialization and testing
*/
SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE IF NOT EXISTS ClientPrompt(temp TINYINT);
CREATE TABLE IF NOT EXISTS ClientVideo(temp TINYINT);
CREATE TABLE IF NOT EXISTS Video(temp TINYINT);
CREATE TABLE IF NOT EXISTS Prompt(temp TINYINT);
CREATE TABLE IF NOT EXISTS FourWeekProgram(temp TINYINT);
CREATE TABLE IF NOT EXISTS Client(temp TINYINT);

TRUNCATE TABLE ClientPrompt;
TRUNCATE TABLE ClientVideo;
TRUNCATE TABLE Video;
TRUNCATE TABLE Prompt;
TRUNCATE TABLE FourWeekProgram;
TRUNCATE TABLE Client;  

-- Drop join tables
DROP TABLE IF EXISTS ClientPrompt;
DROP TABLE IF EXISTS ClientVideo;

-- Drop child tables
DROP TABLE IF EXISTS Video;
DROP TABLE IF EXISTS Prompt;
DROP TABLE IF EXISTS FourWeekProgram;

-- Drop parent table
DROP TABLE IF EXISTS Client;

SET FOREIGN_KEY_CHECKS = 1;


-- Create tables
CREATE TABLE IF NOT EXISTS Client (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(20),
    age INT,
    accountCreationDate DATE,
    adminNote TEXT,
    clientNote TEXT
);

CREATE TABLE IF NOT EXISTS Four_Week_Program ( 
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    startDate DATE,
    endDate DATE,
    lastPromptSentDate DATE,
    lastVideoSentDate DATE,
    isPaid BOOLEAN,
    FOREIGN KEY (client_id) REFERENCES Client(id)
);

CREATE TABLE IF NOT EXISTS Prompt (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    prompt TEXT,
    creationDate DATE
);

CREATE TABLE IF NOT EXISTS Video (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    link VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Client_Prompt (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    prompt_id INT,
    FOREIGN KEY (client_id) REFERENCES client(id),
    FOREIGN KEY (prompt_id) REFERENCES prompt(id)
);

CREATE TABLE IF NOT EXISTS Client_Video (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    video_id INT,
    FOREIGN KEY (client_id) REFERENCES client(id),
    FOREIGN KEY (video_id) REFERENCES video(id)
);
