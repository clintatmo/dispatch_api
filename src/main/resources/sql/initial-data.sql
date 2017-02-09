INSERT INTO Role (id, name, description) VALUES
  (1, "USER", "USER");

INSERT INTO Account (id, credentialsexpired, enabled, expired, locked, password, username) VALUES
  (1, 0, 1, 0, 0, "$2a$06$gKFQfHYeoGPpXvya6dedeeAeQDt6rhbppyViI8JWjgB4HMJ0WNB0.", "clint@");

INSERT INTO users_roles (user_id, role_id) VALUES
  (1, 1);

INSERT INTO Person (id, birthday, firstname, lastname) VALUES
  (1, NULL, "clint", "atmo");

INSERT INTO roles_privileges (role_id, privilege_id) VALUES
  (1, 1);