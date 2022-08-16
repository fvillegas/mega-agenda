package uy.edu.cei.megacalendar.mappers;

import org.apache.ibatis.annotations.*;
import uy.edu.cei.megacalendar.models.UserModel;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    public List<UserModel> fetchAll();

    @Select("SELECT * FROM users WHERE username = #{username}")
    public Optional<UserModel> findByUsername(@Param("username") final String username);

    @Select("SELECT * FROM users WHERE id = #{id}")
    public UserModel fetchUserById(Long id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @SelectKey(statement = "SELECT nextval('user_seq')", keyProperty = "id", before = true, resultType = long.class)
    @Insert("INSERT INTO users(id, username, password, created_at) VALUES(#{id}, #{username}, #{password}, 'now')")
    public boolean insertUser(UserModel userModel);
}
