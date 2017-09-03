package cc.anjun.girl.service;

import cc.anjun.girl.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    GirlService girlService;
    @Test
    public  void findOneTest() throws  Exception{
        Girl girl = girlService.findOne(3);
        Assert.assertEquals(new Integer(32),girl.getAge());
    }
}