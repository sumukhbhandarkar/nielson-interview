INSERT INTO user (id, name) VALUES (1, 'Tom');
INSERT INTO user (id, name) VALUES (2, 'Jerry');
INSERT INTO room (id, name) VALUES(1, 'Meeting Room A')
INSERT INTO room (id, name) VALUES(2, 'Meeting Room B')



--SELECT r from room r WHERE r.id NOT IN (SELECT m.room.id FROM meeting m WHERE m.startTime < :end AND m.endTime > :start

--SELECT m FROM meeting m JOIN m.users u WHERE u.id IN :userIds AND m.startTime <:end AND m.endTime > :start