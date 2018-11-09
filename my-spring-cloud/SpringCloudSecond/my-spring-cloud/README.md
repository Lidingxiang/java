#### Spring Cloud Eureka
##### > eureka-server-01
- 服务治理单节点模式用例
- 把服务注入进来的用例为：spring-boot-helloword-02

##### > spring-boot-helloword-02
- 把服务注入到单节点治理中心：eureka-server-01

##### > eureka-server-ha-03
- 服务治理多节点搭建

##### > spring-boot-helloword-04
- 把服务注入到多节点节点治理中心：eureka-server-ha-03

#### Spring Cloud Ribbon
##### > ribbon-consumer-05
- 通过服务治理（eureka-server-ha-03）调用服务提供者（spring-boot-helloword-04）

##### > ribbon-consumer-06
- 通过服务治理（eureka-server-ha-03）调用服务提供者（spring-boot-helloword-04）
- 加入断容器

##### > ribbon-consumer-07
- 通过服务治理（eureka-server-ha-03）调用服务提供者（spring-boot-helloword-04）
- 加入断容器
- 请求依赖服务的集中方式
- 出现异常处理的备用方法
- 添加请求缓存
- 请求合并

##### > hystrix-dashboard-08
- hystrix仪表盘

##### > turbine-09
- 集群监控

##### > turbine-amqp-10
- 集群监控通过消息代理组合
