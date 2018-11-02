package com.grateful.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class DemoApplicationTests extends BaseJunit {

    @Test
    public void contextLoads() {
    }

    @Test
    //@PostMapping("/hello")
    public void hello(){
        Integer id = -1;
        System.out.println("Hello word!" + id);
    }
}
