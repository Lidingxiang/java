##### > Spring Cloud Eureka
- 服务治理

##### > Spring Cloud Ribbon
- 客户端负载均衡
    - 轮询
    - 权重
    - 随机
    - 重试
- 客户端调用的REST方式【RestTemplate】

##### > Spring Cloud Hystrix
- 服务容错保护
- 依赖隔离
- 服务降级【fallback处理】
- 捕获指定异常进行降级
- 捕获异常进行降级
- 命令名称，分组以及线程池部分（用于统计部分）
- 请求缓存
    - 添加缓存
    - 刷新缓存 
- 请求合并
    - 请求命令本身的延迟
    - 延迟时间窗内的并发量 
- Hystrix仪表盘
- Turbine集群监控
    - 可与消息进行整合传输


##### > Spring Cloud Feign
- 对Ribbon和Hystrix进行整合
- 声明式接口调用
- 日志配置

##### > Spring Cloud Zuul
- 请求路由
- 负载均衡
- 校验过滤
- 请求生命周期
    - pre:前置加工，比如请求校验
    - routing:路由转发到具体服务实例
    - post:可以获得请求信息和相应信息，可以进行在加工
    - error:出现异常时触发，最终还是流向post过滤器
- 动态路由
- 动态加载

##### > Spring Cloud Config
- 分布式系统中的基础设施和微服务应用提供集中化的外部配置支持
- 服务端：分布式配置中心，用来链接配置仓库，为客户端提供获取配置信息
- 客户端：微服务架构中的各个微服务，通过指定的配置中心获取相关的配置内容


##### > Spring Cloud Bus
- 应用配置的动态刷新【请求一个接口】
- 将ConfigServer与SpringCloudBus进行整合，然后刷新ConfigServer

##### > Spring Cloud Stream
- 通过使用Spring Integration来链接消息代理中间件以实现消息时间驱动
- 引入发布-订阅，消费组以及分区
- 轻量级的消息驱动服务框架

##### > Spring Cloud Sleuth
- 分布式跟踪的核心
    - 第一个值，引用名称
    - TraceID标识一条请求链路（一个TraceID多个SpanID）
    - SpanID表示一个基本单元，比如发送一个http请求
    - 第四个值标识是否将该信息输出到Zipken等服务来收集和展示
- 抽样收集 
- 整合ELK（Logstash）
- 整合Zipkin监控链路请求时间
- 通过消息中间件收集
- 对跟踪信息进行存储（MySQL）