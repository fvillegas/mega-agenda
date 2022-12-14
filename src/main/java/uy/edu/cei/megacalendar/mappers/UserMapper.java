package uy.edu.cei.megacalendar.mappers;

import org.apache.ibatis.annotations.*;
import uy.edu.cei.megacalendar.models.NoUserModel;
import uy.edu.cei.megacalendar.models.UserModel;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    public void resultsMaps();

    @Select("SELECT * FROM users")
    public List<UserModel> fetchAll();

    @Select("SELECT * FROM users WHERE username = #{username}")
    public Optional<UserModel> findByUsername(@Param("username") final String username);

    @Select("SELECT * FROM users WHERE id = #{id}")
    public UserModel fetchUserById(Long id);

    @Results(id = "userToNoUser", value = {
            @Result(property = "u", column = "username")
    })
    @Select("SELECT username FROM users WHERE id = #{id}")
    public NoUserModel fetchNoUserModel(Long id);

    @ResultMap("userToNoUser")
    @Select("SELECT username FROM users WHERE id = #{id}")
    public NoUserModel fetchAnotherNoUserModel(Long id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @SelectKey(statement = "SELECT nextval('user_seq')", keyProperty = "id", before = true, resultType = long.class)
    @Insert("INSERT INTO users(id, uuid, username, password, created_at) " +
            "VALUES(#{id}, uuid_generate_v4(), #{username}, #{password}, 'now')")
    public boolean insertUser(UserModel userModel);
}
