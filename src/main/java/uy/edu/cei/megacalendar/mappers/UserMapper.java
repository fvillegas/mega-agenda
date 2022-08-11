package uy.edu.cei.megacalendar.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import uy.edu.cei.megacalendar.models.UserModel;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    public List<UserModel> fetchAll();

    @Select("SELECT * FROM users WHERE username = #{username}")
    public Optional<UserModel> findByUsername(@Param("username") final String username);
}
