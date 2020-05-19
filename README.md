# ejpa-example
ejpa框架使用的案例项目

# 初衷
- 在项目开发中，经常发现大多数的情况下都是一些频次非常高的，相似性非常大的操作，如果为了便捷复制粘贴代码，是可以快速完成任务，但也会为后来的维护带来痛苦的体验。
- 故，本项目的目的就是充分思考抽取项目中具有[频次非常高的，相似性非常大的操作]来实现，来方便维护，同时提高开发效率。

# ejpa框架原理
- 其实就是基于SpringDataJpa的再封装，同时提供一些常用操作的模板以便使用。
- 从Controller-->Service-->Repository-->Entity,都有相应的模板代码.

# 框架特性(v3.5.0)
## 多租户模式
### 基于独立数据库的多租户
- 接口测试效果说明：
  <http://note.youdao.com/noteshare?id=88b0bd6eee11e9ccf2955e5023775305>
- 使用过程：<http://note.youdao.com/noteshare?id=f07a282613a2e52ebc14027759b99a07>

### 基于数据列的多租户
- Hibernate还没有实现这种方式；
- 可以自己考虑用复合主键的方式来实现。

### 基于Scheme的多租户
- 在MySQL数据库中和基于数据库模式似乎没有什么不同。

# 框架特性(v3.0.0)
- 基本的CRUD模板，即增删改查操作，此处的查是指正常的分页、排序及id查询；
- 较复杂的多条件的高级查询；
- 提供对持久化实体属性操作检查功能；
- 提供接口的国际化功能；
- 自动跟踪记录的：创建时间、更新时间、创建人、更新人
- 更具体文档说明见：/docs下文件
    
# V4.0.0 计划
- 加持redis的缓存配置；
- 对请求加持日志记录；
- 对底层的数据库异常增加处理；
- 对敏感信息脱敏处理

## 详细版本说明参见
- <https://docs.efactory.vip/ejpa/version.html>

# 相关项目说明
- 国际化实现：https://github.com/vip-efactory/common-i18n
    - 通用国际化功能实现，被ejpa框架依赖。
- ejpa框架项目：https://github.com/vip-efactory/ejpa
    - ejpa的主体实现
- ejpa框架Starter：https://github.com/vip-efactory/ejpa-spring-boot-starter
    - 封装了ejpa需要的所有依赖
- ejpa案例项目：https://github.com/vip-efactory/ejpa-example
    - ejpa的使用案例，以及功能是否正常的测试项目
    
# 如何使用
- 1.引入已发布的starter依赖：

```
    <properties>
        <java.version>1.8</java.version>
        <ejpa.version>3.0.0</ejpa.version>
        <mysql.driver.version>8.0.18</mysql.driver.version>
    </properties>
    <dependency>
        <groupId>vip.efactory</groupId>
        <artifactId>ejpa-spring-boot-starter</artifactId>
        <version>${ejpa.version}</version>
        <type>pom</type>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
        <version>${mysql.driver.version}</version>
    </dependency>
```

- 2.编写application主文件
```
ackage vip.efactory.ejpa.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // 创建时间、创建人等字段的处理
@SpringBootApplication
public class EjpaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjpaExampleApplication.class, args);
    }

}
```

- 3.用IDEA运行项目即可

- 更详细使用方式，请参考案例项目：https://github.com/vip-efactory/ejpa-example

# 测试案例图片
- 测试案例参见：resources/static/usege

# 如何贡献代码
- 克隆代码
    - git clone https://github.com/vip-efactory/common-i18n.git
    - git clone https://github.com/vip-efactory/ejpa.git
    - git clone https://github.com/vip-efactory/ejpa-example.git
- Maven编译出本地安装包
    - 在common-i18n项目根目录执行：mvn clean install
    - 在ejpa项目根目录执行：mvn clean install
    - 在ejpa-example项目根目录执行：mvn clean install
- 运行样例项目
    - 在本地的MySQL数据库中创建：db_ejpa_example,相关的表会在项目运行时自动创建
    - 编译后直接在IDEA中运行ejpa-example项目即可；
- 若更改common-i18n或ejpa项目的源码，需要删除本地maven仓库的jar，否则冲突。
    - 清除方式：
        - A.找到本机maven仓库目录，例如我的是：/media/dbdu/BK/m2/repository;
        - B.删除vip目录下的所有文件；
        - C.重新Maven编译出本地安装包即可
- 修改源码增加新特性
- 在github上提交pull请求
- 

# 相关说明：
- 关于校验文件的占位符
    - 实现校验国际化信息里的占位符处理：占位符支持注解的属性占位例如{min}-{max}，不支持{0}-{1}这样的占位，因为校验注解不支持传参，只能使用已有的属性信息当参数。
- 关于案例项目中创建人和更新人为空的问题，是因为没有加持登录功能，所以系统抓不到这两个字段的信息。


# 已知问题

# 注意
- 请不要直接使用ejpa项目的master分支代码,在开发中可能非常不稳定,可以使用已发布的分支!

# 捐赠支持
- 如果项目对您有帮助，就支持一下吧，你可以：
- 对项目进行star
- 赏杯雪碧吧
- 支付宝、微信：

![image](https://github.com/vip-efactory/ejpa-example/raw/master/src/main/resources/static/payimg/ali-pay.png)
![image](https://github.com/vip-efactory/ejpa-example/raw/master/src/main/resources/static/payimg/wx-pay.png)

# 技术交流群：
- QQ群：1013796294
- 微信群：
