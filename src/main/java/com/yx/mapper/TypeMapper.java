package com.yx.mapper;

import com.yx.domain.Type;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TypeMapper {
    int countByExample(TypeExample example);

    int deleteByExample(TypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
    
    @Select(" select * from type a where exists (select 1 from category b where a.category_type = b.id and b.categoryName=#{categoryname}) and a.typeName = #{typename}")
    List<Type> selectByName(@Param("categoryname")String categoryname, @Param("typename")String typename);
}