# springboot 快速集成 dubbo

### zookeeper 服务安装
```bash
    # 1: 将 script/docker-compose.yaml 文件拷贝到服务器上
    
    # 2: 执行启动命令
    docker-compose -f docker-compose.yaml up -d
```

&nbsp;

### [dubbo admin 服务安装](https://github.com/apache/incubator-dubbo-admin)
```bash
    # 下载 dubbo-admin 源码
    git clone https://github.com/apache/incubator-dubbo-admin.git
    
    # 切换至 master 分支
    git checkout -b master  remotes/origin/master
    
    cd dubbo-admin/
    
    # 编译源码
    mvn package
    
    cd target/
    
    # 修改 dubbo-admin 项目的配置文件信息
    vim dubbo-admin-0.0.1-SNAPSHOT.jar
    BOOT-INF/classes/application.properties
        server.port=7050
        spring.velocity.cache=false
        spring.velocity.charset=UTF-8
        spring.velocity.layout-url=/templates/default.vm
        spring.messages.fallback-to-system-locale=false
        spring.messages.basename=i18n/message
        spring.root.password=answer
        spring.guest.password=guest
        dubbo.registry.address=zookeeper://127.0.0.1:2181
     
    # 如果修改配置文件保存时报错： your system doesn't appear to have the zip pgm, 执行以下命令
    sudo apt-get install zip
    sudo apt-get install unzip
    
    
    # 启动 dubbo-admin 服务
    java -jar dubbo-admin-0.0.1-SNAPSHOT.jar

    # 访问
    http://192.168.XXX.XXX:7050
```
 - [dubbo-admin version 2.6 版本已编译可执行 jar 下载](https://download.csdn.net/download/u010979642/11085369)

&nbsp;

### 项目运行
```bash
    # 1: 拉取 springboot-dubbo 项目到本地
    
    # 2: 修改 spring-dubbo.xml 配置文件中 zookeeper 的注册地址 dubbo:registry address
    
    # 3: 修改 springboot-dubbo-provider 项目下 application.properties 配置文件 zookeeper 的注册地址 spring.dubbo.registry.address
    
    # 4: 运行 ProviderApplication 服务
    
    # 5: 运行 ConsumerApplication 服务
    
    # 5: 访问
    http://127.0.0.1:9093/sdc/notice/answer
    http://127.0.0.1:9093/sdc/insertUser/answer
    http://127.0.0.1:9093/sdc/findUser/answer
```

&nbsp;

### zookeeper 命令手册
```bash
    # 查看 zk 服务运行状态
    bin/zkServer.sh status
    
    # 进入 zk 命令行
    bin/zkCli.sh -server 127.0.0.1:2181
    
    # 查看命令行帮助， 命令行不熟悉的可使用 zk 可视化图形工具
    help
```
 - [zookeeper可视化图形工具下载]()

&nbsp;

### Reference
 
 - [dubbo github 地址](https://github.com/apache/incubator-dubbo)
 
 - [dubbo-admin github 地址](https://github.com/apache/incubator-dubbo-admin)

 - [dubbo-api 文档](http://dubbo.apache.org/zh-cn/docs/user/preface/background.html)
 
 - [dubbo-spring-boot-starter](https://github.com/alibaba/dubbo-spring-boot-starter)
