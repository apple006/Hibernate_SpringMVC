package Login.DAO;


import Entity.User;
import Entity.UserToken;
import Entity.UserType;
import Tool.HibernateUtil.java.HibernateUtil;
import org.hibernate.*;
import org.junit.Test;
import org.springframework.stereotype.Repository;


import java.util.*;
import java.util.logging.Logger;

/**
 * Login_registerDAO实现类
 * 状态码：1成功 0失败
 */
@Repository
public class Login_registerDAOImp implements Login_registerDAO  {

    private Logger logger=Logger.getLogger(Login_registerDAOImp.class.getName());

    @Override
    public int SaveUserData(User user) {
        Session session= HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {

            user.setProfile("");
            user.setSchool_name("深圳大学");
            user.setIntroduction("");
            UserType userType=new UserType();
            userType.setId(Long.valueOf(1));
            user.setUserType(userType);
            session.save(user);

            String sql="select new User(u1.id) from User u1 where u1.login_name=:name";
            Query query = session.createQuery(sql);
            query.setString("name",user.getLogin_name());
            List<User> list= (List<User>) query.list();
            User u1=list.get(0);
            UserToken token=new UserToken();
            token.setUser(u1);
            token.setToken(UUID.randomUUID().toString());
            session.save(token);
            tx.commit();
            return 1;
        }catch (HibernateException e){
            e.printStackTrace();
            logger.info("用户已经存在...不能注册");
            if (tx!=null){
                tx.rollback();
            }
            return 0;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Override
    public String GetUserToken(Long userId) {
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            String sql="select new UserToken (t.token) from UserToken t where t.id=:user_id";
            Query query = session.createQuery(sql);
            query.setLong("user_id",userId);
            List<UserToken> list= (List<UserToken>) query.list();
            if (!list.isEmpty()){
                UserToken token=list.get(0);
                return token.getToken();
            }else {
                return "";
            }
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
            return "";
        }catch (NullPointerException e){
            return "";
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Override
    public Map<String,Object> query_user_login(String name, String password) {
        Session session= HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        Map<String,Object> map=new HashMap<>();
        try {
            String sql="select new User(a.login_name,a.password,a.id,a.userType) from User a WHERE a.login_name=:name and a.password=:password";
            Query query = session.createQuery(sql);
            query.setString("name",name);
            query.setString("password",password);
            List<User> list= (List<User>) query.list();

            if (list.isEmpty()){
              logger.info("没有 "+name+" 这个用户...");
            }else {
                User user=list.get(0);
//                String sql1="select e.id from Expert e where e.user.id=:user_id";
//                Query query1 = session.createQuery(sql1);
//                query1.setLong("user_id",user.getId());
//                Long expert_id = (Long) query1.uniqueResult();
//                System.out.println(expert_id);
                  map.put("user_id",user.getId());
                  map.put("user_type",user.getUserType().getId());
//                if (expert_id!=null){
//                    map.put("expert_id",expert_id);
//                }else{
//                    map.put("expert_id",Long.valueOf(0));
//                }
            }
            tx.commit();
            return map;
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
            return map;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

    public int cache_User(){
        Session session=HibernateUtil.getSession();
        Transaction tx=HibernateUtil.getTransaction();
        try {
            User user = (User) session.load(User.class,(long)4);
            System.out.println(user.getLogin_name());
            System.out.println(user.getProfile());
            tx.commit();
            if (user.getLogin_name()!=null){
                return 1;
            }else{
                return 2;
            }
        }catch (HibernateException e){
            e.printStackTrace();
            if (tx!=null){
                tx.rollback();
            }
            return 0;
        }finally {
            HibernateUtil.closeSession(session);
        }
    }
    @Test
    public void test(){
        cache_User();
    }
}
