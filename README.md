The project aims to implement a secure user authentication and authorization system for a web application using JSON Web Tokens (JWT) and auth2(resource manager).
This setup will ensure secure user login, enforce role-based permissions, and JPA security.

Key Features
1. Secure User Authentication : Users authenticate using their credentials (username and password).Upon successful authentication, a Token is generated and returned to the client.The JWT includes encoded user information and roles, and is signed to ensure its integrity.
2. JWT-Based Authentication : The application uses JWTs to verify user identity on each request.The token is sent in the HTTP Authorization header as a Bearer token.JWTs are validated on the server to check their authenticity and to extract user roles and other claims.
3. Role-Based Access Control :Users are assigned specific roles (e.g., ADMIN, USER) that determine their access permissions.Role information is encoded in the Token, which is used to control access to various endpoints.Controllers are protected based on user roles using method-level security annotations.
