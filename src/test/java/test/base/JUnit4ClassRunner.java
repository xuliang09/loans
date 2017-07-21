package test.base;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * 初始化log4j配置
 *
 * 初始化log4j配置
 * 
 * @author xul 2017年7月21日
 * @see [相关类/方法]
 * @since 1.0
 */
public class JUnit4ClassRunner extends SpringJUnit4ClassRunner
{
    public JUnit4ClassRunner(Class<?> clazz) throws InitializationError
    {
        super(clazz);
    }
}
