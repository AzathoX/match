package org.match.dataassert.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.match.dataassert.datadomain.MatchTempDomain;

import java.util.List;

@Mapper
public interface MatchTempMapper extends BaseMapper<MatchTempMapper> {
    int deleteByPrimaryKey(Integer id);

    int insert(MatchTempDomain record);

    int insertSelective(MatchTempDomain record);

    MatchTempDomain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MatchTempDomain record);

    int updateByPrimaryKey(MatchTempDomain record);

    List<MatchTempDomain> selectCompeleteTemplete();

    int batchInsert(List<MatchTempDomain> list);

    /**
     *  int batchInsert(List<VmatchTempDomain> list);
     *     <insert id="batchInsert" parameterType="map" >
     *     <!--@mbg.generated temp_config,-->
     *     insert into tb_vmatch_temp
     *             (temp_uniname,event_id,temp_count,outline_rule,start_time)
     *     values
     *             <foreach collection="list" item="item" separator=",">
     *             (#{item.tempUniname,jdbcType=VARCHAR},
     *             #{item.eventId,jdbcType=INTEGER},
     *             #{item.tempConfig,jdbcType=OTHER},
     *             #{item.tempCount,jdbcType=INTEGER},
     *             #{item.outlineRule,jdbcType=INTEGER},
     *             #{startTime,jdbcType=TIMESTAMP})
     *     </foreach>
     *   </insert>
     * @param list
     * @return
     */

}