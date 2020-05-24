# recommendationengine
Simple recommendation engine

1. Provided functionality
   - Add User (User is added given it passes the required validation)
       -  post api http://hostname:port/user/add
       - curl
       curl --location --request POST 'http://localhost:8080/user/add' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"UserC",
	"gender":"Male",
	 "age": 26,
	 "interest":
	 	[
	 	"Movies",
	 	"Tennis",
	 	"Football",
	 	"Cricket"
	 	]

}'
       
   - Get Recommendation 
      -  get api http://hostname:port/user/recommend
      - curl 
      curl --location --request GET 'http://localhost:8080/user/recommend?userId=UserB&top=2' \
--header 'Content-Type: application/json' \
--data-raw ''
 
 2. How To run 
  - Make jar using command mvn package 
  - Now run command java -jar pathtojar/recommendationengine-0.0.1.jar
    (Now server will be running)
    (logs will be printed on console as well as file)
    
 3. How to test
  - Use postman or below curl to test 
  - add user
     curl --location --request POST 'http://localhost:8080/user/add' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"UserC",
	"gender":"Male",
	 "age": 26,
	 "interest":
	 	[
	 	"Movies",
	 	"Tennis",
	 	"Football",
	 	"Cricket"
	 	]

}'
 - now get recommendation 
 curl --location --request GET 'http://localhost:8080/user/recommend?userId=UserB&top=2' \
--header 'Content-Type: application/json' \
--data-raw ''
 
  
    
  
  
