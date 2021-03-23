package org.match.dataassert.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.match.dataassert.datadomain.PhontomText;

public interface PhontomTextMapper  extends BaseMapper<PhontomText> {
    int deleteByPrimaryKey(Integer id);

    @Override
    int insert(PhontomText record);

    int insertSelective(PhontomText record);

    PhontomText selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PhontomText record);

    int updateByPrimaryKey(PhontomText record);
}