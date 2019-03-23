package cn.org.chris.newlife;

import cn.org.chris.newlife.model.TestGenerator;
import cn.org.chris.newlife.service.ITestGeneratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewlifeApplicationTests {
    @Autowired
    private ITestGeneratorService testGeneratorService;

    @Test
    public void contextLoads() {
        TestGenerator tg = testGeneratorService.findById(1);
        System.out.println(tg.getName() + "   " + tg.getContact());
        System.out.println(tg.toString());
    }

}

