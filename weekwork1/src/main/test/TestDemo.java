import com.itdr.pojo.Users;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

public class TestDemo {
    @Test
    public void test2(){
        DriverManagerDataSource dmd=new DriverManagerDataSource();
        dmd.setDriverClassName("com.mysql.jdbc.Driver");
        dmd.setUrl("jdbc:mysql://localhost:3306/shop");
        dmd.setUsername("root");
        dmd.setPassword("123456");
        JdbcTemplate jdt=new JdbcTemplate(dmd);
        String sql="select * from users where id='1'";
        List<Map<String, Object>> map= jdt.queryForList(sql);
        for(Map<String,Object> maps:map){
            for(String s:maps.keySet()){
                System.out.println(maps.get(s));
            }
        }

    }
    @Test
    public void test3(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdt=ac.getBean(JdbcTemplate.class);
        String sql="select * from users";
        List<Map<String, Object>> map= jdt.queryForList(sql);
        for(Map<String,Object> maps:map){
            for(String s:maps.keySet()){
                System.out.println(maps.get(s));
            }
        }

    }
    @Test
    public void test4(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdt=ac.getBean("jdt1",JdbcTemplate.class);
        String sql="select * from users";
        List<Map<String, Object>> map= jdt.queryForList(sql);
        for(Map<String,Object> maps:map){
            for(String s:maps.keySet()){
                System.out.println(maps.get(s));
            }
        }

    }
}
