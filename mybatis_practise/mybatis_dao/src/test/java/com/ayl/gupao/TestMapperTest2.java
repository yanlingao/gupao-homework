package com.ayl.gupao;

import com.ayl.gupao.dao.Test2;
import com.ayl.gupao.dao.TestMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author AYL    2018/4/6 18:03
 */
public class TestMapperTest2 extends BaseTest {
    @Autowired
    private TestMapper testMapper;

    @Test
    public void testselect(){
        System.out.println(testMapper.selectByPrimaryKey(4231));
    }

    @Test
    public void testInsert(){
        Test2 test2 = new Test2();
        test2.setName("sun");
        test2.setNums(100);
        testMapper.insert(test2);
        System.out.println(test2);
    }
}
