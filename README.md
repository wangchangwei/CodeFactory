# 🏭 代码工厂

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]

## 🚀 项目简介

代码工厂是一个基于Spring Boot2 + Beetl + MySQL的代码生成工具，能够根据代码模板自动生成各种代码。它支持生成需求文档、接口文档以及多种编程语言的代码。

### ✨ 主要特性

- 📝 支持生成Markdown格式的需求文档
- 📊 支持生成Swagger格式的接口文档
- 💻 支持生成多种编程语言代码（Vue、React、Java等）
- 🎨 基于前后端不分离架构
- 🔧 提供Docker部署支持

### 🎯 应用场景

- 快速生成项目基础代码
- 自动生成API文档
- 生成项目需求文档
- 提高开发效率，减少重复工作

## 🚀 快速开始

### 📋 环境要求

- JDK 1.8+
- Maven 3.6+
- MySQL 5.7+
- Docker（可选）

### 🔧 安装步骤

1. 克隆项目
```bash
git clone https://github.com/wangchangwei/CodeFactory.git
```

2. 初始化数据库
   - 执行 `db/init.sql` 创建数据表
   - 执行 `db/data.sql` 初始化数据

3. 配置数据库
   - 修改 `gen-admin/resources/application.yml` 中的数据库配置

4. 启动应用
   - 运行 `gen-admin` 模块下的 `cn.afterturn.gen.GenApplication`
   - 默认访问地址：http://127.0.0.1:7080
   - 默认账号：admin/123456

### 🐳 Docker部署

```bash
mvn clean package
docker build .
docker run -d -p 7080:7080 镜像ID
```

## 🔍 技术栈比较

| 特性 | 代码工厂 | 其他类似工具 |
|------|---------|------------|
| 代码生成 | ✅ 支持多种语言 | ⚠️ 通常只支持特定语言 |
| 文档生成 | ✅ 支持Markdown和Swagger | ⚠️ 通常只支持一种格式 |
| 部署方式 | ✅ 支持原生和Docker | ⚠️ 通常只支持一种方式 |
| 学习曲线 | ⭐ 中等 | ⭐ 通常较陡峭 |
| 社区支持 | ⭐ 活跃 | ⭐ 因项目而异 |

## 📚 项目结构

```
├── Dockerfile
├── LICENSE
├── README.md
├── db
├── gen-admin
├── gen-core
├── guns-core
├── logs
└── pom.xml
```

## 🤝 贡献指南

欢迎提交Issue和Pull Request来帮助改进项目！

## 📄 许可证

本项目采用MIT许可证 - 详见 [LICENSE](LICENSE) 文件

## 📞 联系方式

- 📧 Email: qq276709159@163.com
- 📺 Bilibili: 胡说八道的小哑巴

<!-- links -->
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
