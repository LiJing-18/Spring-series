package spring.springmvc.mybatis.mapper;

import spring.springmvc.mybatis.pojo.User;
import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(String id);

    int insert(User record);

    List<User> selectByExample();

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

}