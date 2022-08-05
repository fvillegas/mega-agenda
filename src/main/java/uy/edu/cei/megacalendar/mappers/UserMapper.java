package uy.edu.cei.megacalendar.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import uy.edu.cei.megacalendar.models.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    public List<User> fetchAll();
}
