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
