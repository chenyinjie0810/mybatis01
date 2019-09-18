package com.chenyj.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 整合Swagger方便rest应用测试
 * @author lfy
 *	
 *
 * 1、可以使用SpringBoot的工程创建向导，快速的来创建一个SpringBoot的应用
 * 2、创建SpringBoot应用只需要选好自己的功能模块；
 * 3、我们只要在配置文件中做少量的配置，SpringBoot应用就成功
 * 4、SpringBoot自带了嵌入式的Tomcat容器；
 * 5、整个应用开发完成以后，可以使用docker的maven插件直接将应用打包成镜像发布在远程的docker容器里面
 * 6、远程的docker容器就可以很方便的启动应用；
 * =======持续集成====
 */

@EnableSwagger2 //开启Swagger2的功能
@SpringBootApplication
@MapperScan("com.chenyj.mybatis.mapper")
public class SpringBootSsmApplication {

	//将应用打包成一个镜像发布在远程的docker容器中；
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSsmApplication.class, args);
	}

}
