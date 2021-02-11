package com.yx.mapper;

import com.yx.domain.Indexdetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexdetailMapper {
    int countByExample(IndexdetailExample example);

    int deleteByExample(IndexdetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Indexdetail record);

    int insertSelective(Indexdetail record);

    List<Indexdetail> selectByExample(IndexdetailExample example);

    Indexdetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Indexdetail record, @Param("example") IndexdetailExample example);

    int updateByExample(@Param("record") Indexdetail record, @Param("example") IndexdetailExample example);

    int updateByPrimaryKeySelective(Indexdetail record);

    int updateByPrimaryKey(Indexdetail record);
}