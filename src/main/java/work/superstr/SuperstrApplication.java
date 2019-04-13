package work.superstr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("work")//注释扫描，默认扫描使用@ComponentScan所的类所在包下
@EnableAutoConfiguration
public class SuperstrApplication {
	public static void main(String[] args) {
		//启动服务项目，默认端口8080
		SpringApplication.run(SuperstrApplication.class, args);
	}
	
	@Bean
    public TomcatServletWebServerFactory servletContainer(){
       TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
       tomcatServletWebServerFactory.setPort(8090);//修改默认启动端口
       return tomcatServletWebServerFactory;
    }

}