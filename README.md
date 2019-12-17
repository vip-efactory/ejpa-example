# ejpa-example
ejpa框架使用的案例项目

# 特性说明：
- 基础的CRUD：增删改查
- 实体属性的检查
- 国际化
- 复杂条件的高级搜索
- 自动跟踪记录的：创建时间、更新时间、创建人、更新人


# 测试案例
- 测试案例参见：resources/static/usege

# 如何使用
- 引入已发布的starter依赖即可：
`                <dependency>
                     <groupId>vip.efactory</groupId>
                     <artifactId>ejpa-spring-boot-starter</artifactId>
                     <version>${ejpa.version}</version>
                     <type>pom</type>
                 </dependency>`

# 注意事项：
- 关于校验文件的占位符
    - 实现校验国际化信息里的占位符处理：占位符支持注解的属性占位例如{min}-{max}，不支持{0}-{1}这样的占位，因为校验注解不支持传参，只能使用已有的属性信息当参数。
- 

- 

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
        A.找到本机maven仓库目录，例如我的是：/media/dbdu/BK/m2/repository;
        B.删除vip目录下的所有文件；
        C.重新Maven编译出本地安装包即可

# 捐赠支持
- 支付宝：
- 微信：

# 技术交流群：
- QQ群：
- 微信群：