# Monomer_eShop
单体应用，简单电商Demo，基于Spring Boot，包括分布式Session等基本功能
配置文件在 main/resource/application.yaml中，包括数据库，redis连接信息
数据库初始化用户名，密码 guest/111111
启动redis, mysql
启动spring boot application
访问http://ip:8083

docker方式:
docker pull redis
docker pull mysql:5.7

docker run -d  -p 6379:6379 redis
docker run -d   -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=HPE_APP -e MYSQL_USER=lession -e MYSQL_PASSWORD=mypass -p 3306:3306 mysql:5.7

mvn install dockerfile:build
docker run -p 8033:8033 -t springio/gs-spring-boot-docker


