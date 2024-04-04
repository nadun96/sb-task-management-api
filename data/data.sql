-- Populate teams
INSERT INTO team (name, leader_id) VALUES ('Team A', 1);
INSERT INTO team (name, leader_id) VALUES ('Team B', 2);

-- Populate users
INSERT INTO app_user (username, email, role, team_id) VALUES ('leader1', 'leader1@example.com', 'TEAM_LEAD', 1);
INSERT INTO app_user (username, email, role, team_id) VALUES ('leader2', 'leader2@example.com', 'TEAM_LEAD', 2);
INSERT INTO app_user (username, email, role, team_id) VALUES ('member1', 'member1@example.com', 'TEAM_MEMBER', 1);
INSERT INTO app_user (username, email, role, team_id) VALUES ('member2', 'member2@example.com', 'TEAM_MEMBER', 1);
INSERT INTO app_user (username, email, role, team_id) VALUES ('member3', 'member3@example.com', 'TEAM_MEMBER', 2);

-- Populate tasks
INSERT INTO task (title, description, status, assigned_to) VALUES ('Task 1', 'Description for Task 1', 'PENDING', 3);
INSERT INTO task (title, description, status, assigned_to) VALUES ('Task 2', 'Description for Task 2', 'IN_PROGRESS', 4);
INSERT INTO task (title, description, status, assigned_to) VALUES ('Task 3', 'Description for Task 3', 'COMPLETED', 5);

-- Populate task assignments
INSERT INTO task_assign (task_id, assigned_by) VALUES (1, 1);
INSERT INTO task_assign (task_id, assigned_by) VALUES (2, 2);
INSERT INTO task_assign (task_id, assigned_by) VALUES (3, 1);
