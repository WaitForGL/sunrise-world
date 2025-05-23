package com.september;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author september
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SeptemberApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(SeptemberApplication.class, args);
        System.out.println("///////////////////////////////////////////////////\n" +
                "   //     (♥◠‿◠)ﾉﾞ  start success！   ლ(´ڡ`ლ)ﾞ  //\n" +
                "////////////////////////////////////////////////////");
    }
}
