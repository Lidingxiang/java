package ssm.mapper;

import ssm.po.User;

//mapper�ӿڣ��൱��dao�ӿ�
public interface UserMapper {

	//����id��ѯ�û���Ϣ
	User findUserById(int id) throws Exception;

}	