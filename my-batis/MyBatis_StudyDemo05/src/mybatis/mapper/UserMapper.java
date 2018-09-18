package mybatis.mapper;

import mybatis.po.User;
import mybatis.po.UserQueryVo;

import java.util.List;

//mapper�ӿڣ��൱��dao�ӿ�
public interface UserMapper {

    //����id��ѯ�û���Ϣ
    User findUserById(int id) throws Exception;

    //�����û���ģ����ѯ
    List<User> findUserByName(String name) throws Exception;

    //����û���Ϣ
    void insertUser(User user) throws Exception;

    //ɾ���û���Ϣ
    void deleteUser(int id) throws Exception;

    //�����û���Ϣ
    void updateUser(User user) throws Exception;

    //�û���Ϣ�ۺϲ�ѯ
    List<User> findUserList(UserQueryVo userQueryVo) throws Exception;

    //����id��ѯ�û���Ϣ��ʹ��resultMap���
    User findUserByIdResultMap(int id) throws Exception;
}	
