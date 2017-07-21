package test.usermanage;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.loans.domain.CompanyOrIndividual;
import com.loans.domain.User;
import com.loans.service.UserInfoManage;

import test.base.BaseTest;

public class TestUserManger extends BaseTest
{
    @Autowired
    UserInfoManage userInfoManage;

    @Test
    public void addUser()
    {
        User user = new CompanyOrIndividual();
        user.setName("name1");
        user.setPhoneNumber("phone1");
        int state = userInfoManage.addUser(user);
        System.out.println(state);
        
        user.setName("name2");
        user.setPhoneNumber("phone1");
        state = userInfoManage.addUser(user);
        System.out.println(state);
        
        user.setName("name2");
        user.setPhoneNumber("phone2");
        state = userInfoManage.addUser(user);
        System.out.println(state);
        
        user.setName("name1");
        user.setPhoneNumber("phone2");
        state = userInfoManage.addUser(user);
        System.out.println(state);
    }
    
    @Test
    public void findUserByName()
    {
        List<User> state = userInfoManage.findByName("name1");
        System.out.println(state);
        state = userInfoManage.findByName("name2");
        System.out.println(state);
    }
    
    @Test
    public void findUserByPhoneNumber()
    {
        List<User> state = userInfoManage.findByPhoneNumber("phone1");
        System.out.println(state);
        state = userInfoManage.findByPhoneNumber("phone2");
        System.out.println(state);
    }
}
