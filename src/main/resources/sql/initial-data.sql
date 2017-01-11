INSERT INTO Role (id,code,label) VALUES
(1,'USER','USER');

INSERT INTO Account (id,credentialsexpired,enabled,expired,locked,password,username) VALUES
  (1,0,1,0,0,'$2a$06$gKFQfHYeoGPpXvya6dedeeAeQDt6rhbppyViI8JWjgB4HMJ0WNB0.','clint@');

INSERT INTO AccountRole (accountId,roleId) VALUES
  (1,1);

INSERT INTO Person (id,birthday,firstname,lastname) VALUES
  (1,NULL,'clint','atmo');