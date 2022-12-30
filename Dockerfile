FROM tomcat:8.0.39-alpine
ENV dbDriver=com.mysql.jdbc.Driver dbConnectionUrl=jdbc:mysql://localhost:3306/time_table dbUserName=root dbPassword=87654321
