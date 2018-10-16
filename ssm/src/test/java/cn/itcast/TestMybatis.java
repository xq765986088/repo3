package cn.itcast;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void run() throws Exception {
        //加载配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //获取AccountDao动态代理对象
        AccountDao dao = sqlSession.getMapper(AccountDao.class);
        //执行方法
        List<Account> list = dao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }
        //释放资源
        sqlSession.close();
        is.close();
    }
}
