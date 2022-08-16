package uy.edu.cei.megacalendar.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import uy.edu.cei.megacalendar.models.EventModel;

import java.util.Optional;

@Mapper
public interface EventMapper {

    @Select("SELECT id, name FROM events WHERE id = #{id}")
    public Optional<EventModel> fetchById(@Param("id") Long id);

}
