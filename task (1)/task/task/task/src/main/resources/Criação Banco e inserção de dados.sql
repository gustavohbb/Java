CREATE DATABASE trabalho;
USE trabalho;

INSERT INTO usuarios (email, nome) VALUES
('usuario1@email.com', 'Usuário 1'),
('usuario2@email.com', 'Usuário 2'),
('usuario3@email.com', 'Usuário 3'),
('usuario4@email.com', 'Usuário 4'),
('usuario5@email.com', 'Usuário 5');

INSERT INTO tarefas (nome, descricao, agendamento, status, id_usuario) VALUES
('Tarefa 1', 'Descrição da tarefa 1', '2025-03-28 10:00:00', 1, 'usuario1@email.com'),
('Tarefa 2', 'Descrição da tarefa 2', '2025-03-29 11:00:00', 1, 'usuario2@email.com'),
('Tarefa 3', 'Descrição da tarefa 3', '2025-03-30 14:00:00', 4, 'usuario3@email.com'),
('Tarefa 4', 'Descrição da tarefa 4', '2025-04-01 16:00:00', 3, 'usuario4@email.com'),
('Tarefa 5', 'Descrição da tarefa 5', '2025-04-02 09:00:00', 3, 'usuario5@email.com'),
('Tarefa 6', 'Descrição da tarefa 6', '2025-04-03 13:30:00', 2, 'usuario1@email.com'),
('Tarefa 7', 'Descrição da tarefa 7', '2025-04-04 15:00:00', 1, 'usuario2@email.com');
