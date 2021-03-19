spring boot 启动时加载配置文件的顺序 以及优先级

调用链：

> `org.springframework.boot.SpringApplication#run(java.lang.String...)`
> `org.springframework.boot.SpringApplication#prepareEnvironment()`
> 	//  发送配置准备好的事件，由配置监听器做接下来的工作。
> 	`listeners.environmentPrepared(environment);`
> 	
> // 监听器监听触发方法
> `org.springframework.boot.context.config.ConfigFileApplicationListener#postProcessEnvironment(xxx,xxx)`



源码所在类: `org.springframework.boot.context.config.ConfigFileApplicationListener.Loader`

spring boot 的配置文件的加载顺序与配置文件的优先级，以如下配置激活文件为例：

1. `application.properties`

2. `application.yaml`

3. `application-dev.properties`

4. `application-dev.yml`

5. `application-dev.yaml`

6. `application-defaultInner.properties`

7. `application-defaultInner.yaml`

8. `application-defaultOuter.properties`

9. `application-defaultOuter.yaml`

   其中，`spring.profiles.incloud = defaultInner, defaultOuter `被配置

   则优先级顺序为: 

   ​	`application-dev.properties`  > `application-dev.yml` > `application-dev.yaml` > 

   ​	`application-defaultOuter.properties` > `application-defaultOuter.yaml` > 

   ​	`application-defaultInner.properties` > `application-defaultInner.yaml` > 

   ​	`application.properties` > `application.yaml`

   如果按类型分：`*.properties` > `*.yml` > `*.yaml`

   优先级最低的是: `application.*`

   优先级最高的是: 由配置项`spring.profiles.active=xxx` 所激活的环境配置文件

   对于配置项`spring.profiles.include = xxx,xxx`同时指定多的情况，则越靠后优先级越高。

