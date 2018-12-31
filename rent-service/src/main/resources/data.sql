
INSERT INTO movie (id, name, rank, ) VALUES
(1, 'Mad Max', 1),
(2, 'Batman', 2),
(3, 'Predator', 3),
(4, 'Runner', 4),
(5, 'Lord Of the rings', 5);


INSERT INTO user (id, first_name, last_name, user_name, email) VALUES
(1, 'Sasa', 'Prsic', 'sprsic','sasa.prsic@test.com'),
(2, 'John', 'Doe', 'john', 'john.doe@test.com'),
(3, 'Jane', 'Doe', 'jane', 'jane.doe@test.com');

INSERT INTO lease (id, user_id) VALUES
(1, 1);

INSERT INTO lease_movie (lease_id, movie_id) VALUES
(1, 1),
(1, 2),
(1, 3)