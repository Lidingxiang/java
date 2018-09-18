package ssm.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import ssm.dao.UserDao;
import ssm.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User findUserById(int id) throws Exception {
		
		//继承SqlSessionDaoSupport，通过this.getSqlSession()就能得到sqlSession，因为SqlSessionDaoSupport中有该方法
		SqlSession sqlSession = this.getSqlSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		return user;
	}
}
