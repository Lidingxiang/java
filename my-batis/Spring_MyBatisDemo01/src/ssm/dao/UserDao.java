package ssm.dao;

import ssm.po.User;

public interface UserDao {
	
	//�����û�id��ѯ�û���Ϣ
	User findUserById(int id) throws Exception;

}