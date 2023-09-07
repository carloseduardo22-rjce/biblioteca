INSERT INTO table_author (author_id, name, birth_date, country) VALUES (default, 'John Smith', '1980-05-15', 'United States');
INSERT INTO table_author (author_id, name, birth_date, country) VALUES (default, 'Maria Silva', '1975-12-10', 'Brazil');
INSERT INTO table_author (author_id, name, birth_date, country) VALUES (default, 'Thomas Johnson', '1982-09-25', 'United Kingdom');
INSERT INTO table_author (author_id, name, birth_date, country) VALUES (default, 'Anna Müller', '1990-03-20', 'Germany');
INSERT INTO table_author (author_id, name, birth_date, country) VALUES (default, 'Luis Rodriguez', '1985-07-08', 'Spain');
INSERT INTO table_author (author_id, name, birth_date, country) VALUES (default, 'Sophie Dupont', '1978-11-03', 'France');
INSERT INTO table_author (author_id, name, birth_date, country) VALUES (default, 'Mikhail Ivanov', '1987-01-12', 'Russia');
INSERT INTO table_author (author_id, name, birth_date, country) VALUES (default, 'Yuki Tanaka', '1984-06-30', 'Japan');
INSERT INTO table_author (author_id, name, birth_date, country) VALUES (default, 'Elena Petrov', '1981-04-18', 'Russia');
INSERT INTO table_author (author_id, name, birth_date, country) VALUES (default, 'Alessia Rossi', '1992-08-05', 'Italy');

INSERT INTO table_publishing_company (publisher_id, name, address, telephone) VALUES (1, 'Editora ABC', '123 Main Street, Cityville, USA', '+1-555-123-4567');
INSERT INTO table_publishing_company (publisher_id, name, address, telephone) VALUES (2, 'Editora XYZ', '456 Elm Avenue, Townsville, Canada', '+1-416-789-2345');
INSERT INTO table_publishing_company (publisher_id, name, address, telephone) VALUES (3, 'Editora Livros Inc.', '789 Oak Lane, Villageton, UK', '+44-20-1234-5678');
INSERT INTO table_publishing_company (publisher_id, name, address, telephone) VALUES (4, 'Editorial Libros SA', 'Av. Buenos Aires 123, Ciudad de México, Mexico', '+52-55-6789-1234');
INSERT INTO table_publishing_company (publisher_id, name, address, telephone) VALUES (5, 'Edizioni Libri SRL', 'Via Roma 456, Roma, Italy', '+39-06-7890-5678');
INSERT INTO table_publishing_company (publisher_id, name, address, telephone) VALUES (6, 'Éditions Livres SAS', 'Rue de Paris 789, Paris, France', '+33-1-2345-6789');
INSERT INTO table_publishing_company (publisher_id, name, address, telephone) VALUES (7, 'Издательство Книги', 'ул. Московская 10, Москва, Russia', '+7-495-678-90-12');
INSERT INTO table_publishing_company (publisher_id, name, address, telephone) VALUES (8, '出版社书籍有限公司', '北京路123号, 北京, China', '+86-10-1234-5678');
INSERT INTO table_publishing_company (publisher_id, name, address, telephone) VALUES (9, 'Editora dos Livros', 'Rua das Flores 789, Lisboa, Portugal', '+351-21-678-3456');
INSERT INTO table_publishing_company (publisher_id, name, address, telephone) VALUES (10, 'Ediciones de Libros SL', 'Calle Madrid 234, Madrid, Spain', '+34-91-789-5678');

INSERT INTO table_book (book_id, livro_year, author_id, available_quantity,publisher_id, title) VALUES (default, 2020, 1, 15, 1, 'O Senhor dos Anéis');
INSERT INTO table_book (book_id, livro_year, author_id, available_quantity,publisher_id, title) VALUES (default, 2019, 2, 8, 2, 'A Revolução dos Bichos');
INSERT INTO table_book (book_id, livro_year, author_id, available_quantity,publisher_id, title) VALUES (default, 2021, 3, 20, 3, 'Harry Potter e a Pedra Filosofal');
INSERT INTO table_book (book_id, livro_year, author_id, available_quantity,publisher_id, title) VALUES (default, 2018, 4, 12, 4, '1984');
INSERT INTO table_book (book_id, livro_year, author_id, available_quantity,publisher_id, title) VALUES (default, 2022, 5, 5, 5, 'A Dança dos Dragões');
INSERT INTO table_book (book_id, livro_year, author_id, available_quantity,publisher_id, title) VALUES (default, 2017, 6, 10, 6, 'A Culpa é das Estrelas');
INSERT INTO table_book (book_id, livro_year, author_id, available_quantity,publisher_id, title) VALUES (default, 2015, 7, 18, 7, 'Dom Quixote');
INSERT INTO table_book (book_id, livro_year, author_id, available_quantity,publisher_id, title) VALUES (default, 2016, 8, 7, 8, 'Cem Anos de Solidão');
INSERT INTO table_book (book_id, livro_year, author_id, available_quantity,publisher_id, title) VALUES (default, 2014, 9, 14, 9, 'O Pequeno Príncipe');
INSERT INTO table_book (book_id, livro_year, author_id, available_quantity,publisher_id, title) VALUES (default, 2023, 10, 3, 10, 'Duna');

INSERT INTO table_users (user_id, name, birth_date, address, email) VALUES (default, 'João Silva', '1990-05-15', 'Rua das Flores, 123, Cidade A', 'joao@email.com');
INSERT INTO table_users (user_id, name, birth_date, address, email) VALUES (default, 'Maria Souza', '1985-12-10', 'Avenida Principal, 456, Cidade B', 'maria@email.com');
INSERT INTO table_users (user_id, name, birth_date, address, email) VALUES (default, 'José Santos', '1982-09-25', 'Rua das Árvores, 789, Cidade C', 'jose@email.com');
INSERT INTO table_users (user_id, name, birth_date, address, email) VALUES (default, 'Ana Ferreira', '1995-03-20', 'Alameda das Praias, 101, Cidade D', 'ana@email.com');
INSERT INTO table_users (user_id, name, birth_date, address, email) VALUES (default, 'Luís Rodrigues', '1987-07-08', 'Travessa do Lago, 22, Cidade E', 'luis@email.com');
INSERT INTO table_users (user_id, name, birth_date, address, email) VALUES (default, 'Sofia Lima', '1992-11-03', 'Praça Central, 33, Cidade F', 'sofia@email.com');
INSERT INTO table_users (user_id, name, birth_date, address, email) VALUES (default, 'Mário Costa', '1989-01-12', 'Rua das Montanhas, 55, Cidade G', 'mario@email.com');
INSERT INTO table_users (user_id, name, birth_date, address, email) VALUES (default, 'Carla Pereira', '1994-06-30', 'Avenida do Rio, 44, Cidade H', 'carla@email.com');
INSERT INTO table_users (user_id, name, birth_date, address, email) VALUES (default, 'Elena Petrov', '1984-04-18', 'Rua do Bosque, 66, Cidade I', 'elena@email.com');
INSERT INTO table_users (user_id, name, birth_date, address, email) VALUES (default, 'Alessia Rossi', '1990-08-05', 'Avenida das Estrelas, 77, Cidade J', 'alessia@email.com');

INSERT INTO table_loans (loan_id, loan_date, return_date, user_id, book_id) VALUES (1, '2023-09-10 11:30:00', '2023-09-20 13:45:00', 1, 1);
INSERT INTO table_loans (loan_id, loan_date, return_date, user_id, book_id) VALUES (2, '2023-09-12 14:45:00', '2023-09-22 16:20:00', 2, 2);
INSERT INTO table_loans (loan_id, loan_date, return_date, user_id, book_id) VALUES (3, '2023-09-15 13:20:00', '2023-09-25 15:50:00', 3, 3);
INSERT INTO table_loans (loan_id, loan_date, return_date, user_id, book_id) VALUES (4, '2023-09-18 12:00:00', '2023-09-28 14:30:00', 4, 4);
INSERT INTO table_loans (loan_id, loan_date, return_date, user_id, book_id) VALUES (5, '2023-09-20 10:10:00', '2023-09-30 12:40:00', 5, 5);
INSERT INTO table_loans (loan_id, loan_date, return_date, user_id, book_id) VALUES (6, '2023-09-22 08:15:00', '2023-10-02 10:45:00', 6, 6);
INSERT INTO table_loans (loan_id, loan_date, return_date, user_id, book_id) VALUES (7, '2023-09-25 10:00:00', '2023-10-05 15:30:00', 7, 7);
INSERT INTO table_loans (loan_id, loan_date, return_date, user_id, book_id) VALUES (8, '2023-09-28 16:00:00', '2023-10-08 18:30:00', 8, 8);
INSERT INTO table_loans (loan_id, loan_date, return_date, user_id, book_id) VALUES (9, '2023-09-30 09:00:00', '2023-10-10 10:30:00', 9, 9);
INSERT INTO table_loans (loan_id, loan_date, return_date, user_id, book_id) VALUES (10, '2023-10-02 09:15:00', '2023-10-12 11:45:00', 10, 10);