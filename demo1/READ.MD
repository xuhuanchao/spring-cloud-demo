#### 服务的注册与发现
##### server : 

    application.yml
    
    @EnableEurekaServer
    
##### client :
 
    bootstrap.yml 
    
    spring: application: name: 服务名称
    
    @EnableEurekaClient
    
    @RestController
    
##### ribbon



