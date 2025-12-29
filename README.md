# 代码工厂



<!-- PROJECT SHIELDS -->

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

<!-- PROJECT LOGO -->

<br />

<p align="center">
<p>
  <h1 align="center">代码工厂</h1>
  <p align="center">
    根据代码模板生产各种代码。基于前后端不不不不不不不不分离。<br />技术栈：Spring Boot2+Beetl+mysql
    <br />
      能够生成需求文档 markdown、接口文档 swagger.json、程序代码（vue、react、java）等
  </p>
</p></p>


### 上手指南

###### 开发前的配置要求

1. 一双干净小巧的手
2. 一台跟随多年的笔记本
3. 一杯85°的拿铁

###### **安装步骤**

1. 下载源码

```sh
git clone https://github.com/wangchangwei/CodeFactory.git
```

2. `db` 文件夹中有创建数据表结构的脚本 `init.sql`
3. `db` 文件夹中有初始化数据执行的 `data.sql`
4. 修改 `gen-admin/resources/application.yml` 数据库配置项
5. 启动在`gen-admin` 模块下 `cn.afterturn.gen.GenApplication` 
6. 访问端口默认7080，http://127.0.0.1:7080
7. 账号密码：admin/123456

### 文件目录说明

eg:

```
filetree 
|-- Dockerfile
|-- LICENSE
|-- README.md
|-- db
|-- gen-admin
|-- gen-core
|-- guns-core
|-- lemur-gen-parent.iml
|-- logs
`-- pom.xml
```

### 开发的架构 

请阅读[ARCHITECTURE.md](https://github.com/wangchangwei/CodeFactory/blob/master/ARCHITECTURE.md) 查阅为该项目的架构。

### 部署

**原生部署**

```sh
mvn clean package
java -jar ./gen-admin/target/gen.jar
```

**Docker 部署（单容器）**

```sh
mvn clean package
docker build -t code-factory:latest .
docker run -d -p 7080:7080 code-factory:latest
```

**Docker 部署（使用 docker-compose，推荐用于本地开发/演示）**

下面为一个最小示例 `docker-compose.yml`，包含 MySQL 与 `gen-admin` 服务：

```yaml
version: '3.8'
services:
  db:
    image: mysql:5.7
    environment:
      MYSQL_ROOT_PASSWORD: rootpassword
      MYSQL_DATABASE: codefactory
      MYSQL_USER: cfuser
      MYSQL_PASSWORD: cfpass
    ports:
      - "3306:3306"
    volumes:
      - db_data:/var/lib/mysql

  gen-admin:
    build:
      context: .
      dockerfile: Dockerfile
    image: code-factory:latest
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/codefactory?useUnicode=true&characterEncoding=UTF-8&useSSL=false
      SPRING_DATASOURCE_USERNAME: cfuser
      SPRING_DATASOURCE_PASSWORD: cfpass
    ports:
      - "7080:7080"

volumes:
  db_data:
```

使用步骤：

- 在项目根目录执行打包并构建镜像（`docker-compose` 也会在需要时构建）：

```sh
mvn clean package
docker-compose up -d --build
```

- 停止并删除容器与网络：

```sh
docker-compose down
```

说明：
- 请确保 `gen-admin/src/main/resources/application.yml`（或 `gen-admin/resources/application.yml`）中的数据库配置与上面 `docker-compose.yml` 的环境变量一致，或通过环境变量覆盖对应配置。
- 默认访问地址：`http://127.0.0.1:7080`
- 默认账号：`admin` / `123456`



****

### 使用到的框架

- [SpringBoot](https://getbootstrap.com)
- [Beetl](https://www.kancloud.cn/xiandafu/beetl3_guide/1992542)
- [Thymeleaf](https://www.thymeleaf.org/index.html)


### 作者

- Bilibili：胡说八道的小哑巴
- Email: qq276709159@163.com

### 鸣谢

- [Guns Admin](https://github.com/stylefeng/Guns)
- [ai code](https://gitee.com/lemur/aicode)

<!-- links -->
[your-project-path]:wangchangwei/CodeFactory
[contributors-shield]: https://img.shields.io/github/contributors/wangchangwei/CodeFactory.svg?style=flat-square
[contributors-url]: https://github.com/wangchangwei/CodeFactory/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/wangchangwei/CodeFactory.svg?style=flat-square
[forks-url]: https://github.com/wangchangwei/CodeFactory/network/members
[stars-shield]: https://img.shields.io/github/stars/wangchangwei/CodeFactory.svg?style=flat-square
[stars-url]: https://github.com/wangchangwei/CodeFactory/stargazers
[issues-shield]: https://img.shields.io/github/issues/wangchangwei/CodeFactory.svg?style=flat-square
[issues-url]: https://img.shields.io/github/issues/wangchangwei/CodeFactory.svg
[license-shield]: https://img.shields.io/github/license/wangchangwei/CodeFactory.svg?style=flat-square
[license-url]: https://github.com/wangchangwei/CodeFactory/blob/master/LICENSE.txt
