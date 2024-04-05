# API Endpoints Reference Documentation
***
### Auth JWT
* **POST** [```/api/v1/auth/signup```](http://localhost:8080/api/v1/auth/signup) *To Sign up User @Params( username , email , password )*
* **POST** [```/api/v1/auth/signin```](http://localhost:8080/api/v1/auth/signin) *To Sign in User @Params( username , password )*
### Task
* **POST** [```/api/v1/task/```](http://localhost:8080/api/v1/auth/signup) *Assign Task to User @Params( title , description , assignedTo )*
* **GET**  [```/api/v1/task/team/{teamId}```](http://localhost:8080/api/v1/task/team/{teamId}) *Get User Team Tasks*
* **GET**  [```/api/v1/task/user/{userId}```](http://localhost:8080/api/v1/task/user/{userId}) *Get User Tasks*
* **GET**  [```/api/v1/task/all```](http://localhost:8080/api/v1/task/all) *Get All Tasks*
* **PUT**  [```/api/v1/task/status```](http://localhost:8080/api/v1/task/status?taskId={taskId}&newStatus=IN_PROGRESS) *Update Task Status @Params( taskId , newStatus(IN_PROGRESS || PENDING || COMPLETED) )*
* **DELETE**  [```/api/v1/task/task/{taskId}```](http://localhost:8080/api/v1/task/task/{taskId}) *Delete a Task*
### Team
* [```/api/v1/team/{teamId}/leader/{userId}```](http://localhost:8080/api/v1/team/{teamId}/leader/{userId}) *Assign Team Leader*
### User
* [```/api/v1/user/{userId}/team/{teamId}```](http://localhost:8080/api/v1/user/{userId}/team/{teamId}) *Assign Team To User*
