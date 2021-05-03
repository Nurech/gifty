# gifty

## Users can setup birthday events and invite users to organize (choose) gifts.
## Users can access events via unique url ID to edit or via login.

###
https://gifter-b50fc.web.app/

### 
https://gifter-b50fc-default-rtdb.firebaseio.com/

## Site function
```
├─── Event creator
│     ├─ Create event (unique UUID)
│     ├─ Get email invite link with unique url to the event with role as editor
│     ├─ Set event theme (custom message)
│     ├─ Set event name
│     ├─ Set event date
|     ├─ Set gift list
│     │   └─ For each gift set name, description and number available (can be unlimited)
│     ├─ Set number of participants by email
│     │   └─ Generate unique password for each user event access
│     │   └─ Email event link
│     │   └─ Use unique url for all users to access event and gift list
│     │       └─ Edit options visible when creator has logged-in
│     │       └─ When gift is choosen and 0 left, then will not be visible anymore
│     │   └─ Email event link and link for copying
│     │
│     ├─ Delete event
│         └─ Replace event page with landing page (deleted) on same url
│ 
│ 
│ 
└──┬─ Event participant
   ├─ Get email invite link with unique url to the event with role as participant
   ├─ Add gift
   ├─ Remove gift
   ├─ Set gift title
   ├─ Set gift description
   
```


## Access points
```
├─── api
      ├── login
      ├─── user 
      ├─── list 
      ├─── gift
      ├─── event
```
## Deployment
```
├─── AWS Elastic Beanstalk Hosting
│     ├── Github workflow on commit to master
│     ├─── Deploy SNAPSHOT.jar to Elastic Beanstalk
│      
├─── AWS RDS Postgres DB
│     ├── databse instance (database-1)
```

## Source architecture

```
1. build gifter (maven install, build)
2. build frontend (install node, npm, build, test)
3. build backend (copy frontend/target/dist build to backend/target/SNAPSHOT.jar)

gifter (Maven project)
│ 
│─┬ backend (Java Spring Boot, JPArepository, Postgres on AWS, Liquibase, Tomcat-jdbc, Spring security)
│   ├─ target
│   ├─ src
│       ├─ main
│       │    ├─ java
│       │    |   ├─ com.example.demo
│       │    │       ├─ configuration (security)
│       │    │       ├─ controller
│       │    │       ├─ domain (entity, dao's)   
│       │    │       ├─ service
│       │    |       ├─ exeption
│       │    │       ├─ repository
│       │    │
│       │    ├─ resources
│       │        ├─ public (frontend build)
│       │        ├─ application.properties (server config, databse config)
│       │        ├─ liquibase.properties (changelog config)
│       │
│       ├─ test*
│
├─┬ frontend (Vue2 framework, Bootstrap css, Axios )
│ ├── public
│ ├── src
│      ├─ assets
│      ├─ components
│      ├─ router
│      ├─ views
│      │   ├── Home *index* (create event, register
│      │   ├── Login
│      │   ├── Event
│      │   ├── About
│      │   ├── Contact
│      │   
│      ├─ App.vue
│      ├─ main.js
```

## Databse
```
├─┬─ user
│     ├─ username (primary, unique)
│     ├─ first_name
│     ├─ last_name 
│     ├─ password 
│     ├─ role
│     ├─ status 
│     ├─ register_date 
│     ├─ e-mail 
│
├─── events 
│     ├─ uuid (primary, unique)
│     ├─ event_name
│     ├─ event_description
│     ├─ event_date
│     ├─ event_create_date
│     ├─ owner (username)
│     ├─ gifts_list
│
├─── lists
│     ├─ id (primary, unique)
│     ├─ list_author
│     ├─ list_description
│     ├─ gift_id (ID from gift)
│     
├─── gifts
│     ├─ id (unique, auto generated)
│     ├─ gift_author
│     ├─ gift_title
│     ├─ gift_description
│     
```

Axios use: https://blog.logrocket.com/how-to-make-http-requests-like-a-pro-with-axios/

Vue vuex: https://medium.com/codingthesmartway-com-blog/vue-js-2-state-management-with-vuex-introduction-db26cb495113

Beanstalk deploy: https://github.com/marketplace/actions/beanstalk-deploy#:~:text=Beanstalk%20Deploy%20is%20a%20GitHub,that%20version%20to%20the%20environment.

Vue single-page app: https://www.digitalocean.com/community/tutorials/how-to-generate-a-vue-js-single-page-app-with-vue-create

Springboot vue CRUD operations: https://bezkoder.com/spring-boot-vue-js-crud-example/

Springboot backend with vue: https://bezkoder.com/integrate-vue-spring-boot/

AWS deployment: https://medium.com/bb-tutorials-and-thoughts/aws-deploying-vue-js-with-java-backend-on-elastic-beanstalk-45cf282366e5

Email sending: https://www.freecodecamp.org/news/send-emails-from-your-vue-application/

Oauth use: https://fusionauth.io/blog/2020/08/06/securely-implement-oauth-vuejs/

CRUD operations: https://grokonez.com/firebase/vue-js-firebase-database-example-crud-operations
