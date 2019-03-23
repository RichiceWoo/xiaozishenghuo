package cn.org.chris.newlife;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.org.chris.newlife.dao")
@SpringBootApplication
public class NewlifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewlifeApplication.class, args);
    }

}

