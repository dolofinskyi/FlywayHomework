-- filling worker table
INSERT INTO worker(NAME, BIRTHDAY, LEVEL, SALARY) VALUES
('Bobby', '2002-09-25', 'Middle', 3500),
('Robert', '1994-04-17', 'Trainee', 799),
('Rafael', '1990-03-20', 'Junior', 1800),
('Christopher', '1987-05-21', 'Senior', 6650),
('Ryan', '1997-04-13', 'Junior', 1500),
('Jenny', '1989-07-17', 'Trainee', 1124),
('George', '1993-11-23', 'Trainee', 1286),
('Ilon', '2004-03-27', 'Middle', 3465),
('Max', '2001-07-15', 'Middle', 3097),
('John', '1998-05-14', 'Trainee', 1232),
('Richard', '1975-06-07', 'Senior', 5567),
('Larry', '1989-01-10', 'Trainee', 1053),
('Sally', '1985-02-06', 'Junior', 1879);

-- filling client table
INSERT INTO client(NAME) VALUES
('Taras'),
('Anna'),
('Klaudia'),
('Alexandr'),
('Carl'),
('Tommy'),
('Claude');

-- filling project table
INSERT INTO project(CLIENT_ID, START_DATE, FINISH_DATE) VALUES
(1, '2023-04-19', '2025-04-19'),
(2, '2023-03-24', '2026-09-25'),
(3, '2023-07-05', '2029-02-10'),
(4, '2023-04-12', '2024-07-12'),
(5, '2023-02-10', '2025-09-17'),
(6, '2023-01-18', '2027-10-26'),
(7, '2023-09-13', '2028-03-09'),
(4, '2023-08-07', '2025-06-17'),
(3, '2023-10-25', '2027-05-15'),
(2, '2023-11-27', '2025-01-14'),
(6, '2023-03-14', '2024-12-01');

-- filling project_worker table
INSERT INTO project_worker(PROJECT_ID, WORKER_ID) VALUES
(1, 1), (1, 2), (1, 3), (1, 4),
(2, 5), (2, 6),
(3, 7),
(4, 8), (4, 9), (4, 10),
(5, 11), (5, 12),
(6, 13),
(7, 2), (7, 7), (7, 4),
(8, 4), (8, 3), (8, 11), (8, 13),
(9, 10), (9, 5),
(10, 5), (10, 6), (10, 1),
(11, 2), (11, 8), (11, 9);