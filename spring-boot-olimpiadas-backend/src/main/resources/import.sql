/*/* Populate tabla clientes */
INSERT INTO entrenador (nombre, apellido, email, create_at) VALUES('Andrés', 'Guzmán', 'profesor@bolsadeideas.com', '2018-01-01');
INSERT INTO entrenador (nombre, apellido, email, create_at) VALUES('Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02');
INSERT INTO entrenador (nombre, apellido, email, create_at) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2018-01-03');
INSERT INTO entrenador (nombre, apellido, email, create_at) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04');
INSERT INTO entrenador (nombre, apellido, email, create_at) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01');
INSERT INTO entrenador (nombre, apellido, email, create_at) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10');
INSERT INTO entrenador (nombre, apellido, email, create_at) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18');
INSERT INTO entrenador (nombre, apellido, email, create_at) VALUES('John', 'Vlissides', 'john.vlissides@gmail.com', '2018-02-28');
INSERT INTO entrenador (nombre, apellido, email, create_at) VALUES('Dr. James', 'Gosling', 'james.gosling@gmail.com', '2018-03-03');
INSERT INTO entrenador (nombre, apellido, email, create_at) VALUES('Magma', 'Lee', 'magma.lee@gmail.com', '2018-03-04');
INSERT INTO entrenador (nombre, apellido, email, create_at) VALUES('Tornado', 'Roe', 'tornado.roe@gmail.com', '2018-03-05');
INSERT INTO entrenador (nombre, apellido, email, create_at) VALUES('Jade', 'Doe', 'jane.doe@gmail.com', '2018-03-06');


/* Creamos algunos usuarios con sus roles */
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('andres','$2a$10$v/AM/Xy9y97TlIamZTJY8eN3A8OTBYW834wHYETUWpY3t3KZltKym',1, 'Andres', 'Guzman','profesor@bolsadeideas.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$OulLeyzJq92vuUa4ir5yhew6HE6Z1./thggbvKSxqgDhwwNsdRXMy',1, 'John', 'Doe','jhon.doe@bolsadeideas.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);