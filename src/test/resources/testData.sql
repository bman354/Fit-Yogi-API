-- Insert test data into Client table
INSERT INTO Client (name, email, phone, age, accountCreationDate, adminNote, clientNote)
VALUES
    ('John Doe', 'john@example.com', '123-456-7890', 30, '2023-01-01', 'Admin note for John', 'Client note for John'),
    ('Jane Smith', 'jane@example.com', '987-654-3210', 25, '2023-02-01', 'Admin note for Jane', 'Client note for Jane');

-- Insert test data into Four_Week_Program table
INSERT INTO Four_Week_Program (startDate, endDate, lastPromptSentDate, lastVideoSentDate, isPaid)
VALUES
    ('2023-01-01', '2023-01-28', '2023-01-14', '2023-01-21', true),
    ('2023-02-01', '2023-02-28', '2023-02-14', '2023-02-21', false);

-- Insert test data into Prompt table
INSERT INTO Prompt (prompt, creationDate)
VALUES
    ('Test prompt 1', '2023-01-05'),
    ('Test prompt 2', '2023-01-10'),
    ('Test prompt 3', '2023-02-05'),
    ('Test prompt 4', '2023-02-10');

-- Insert test data into Video table
INSERT INTO Video (link)
VALUES
    ('https://www.example.com/video1'),
    ('https://www.example.com/video2'),
    ('https://www.example.com/video3');

-- Insert test data into Client_Prompt table
INSERT INTO Client_Prompt (client_id, prompt_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4);

-- Insert test data into Client_Video table
INSERT INTO Client_Video (client_id, video_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2),
    (2, 3);
