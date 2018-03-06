package person.hwj.mockdog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import person.hwj.mockdog.entity.MockEntity;

@Mapper
public interface MockDao {

    public List<MockEntity> list();

    public MockEntity selectById(int mockId);

    public List<MockEntity> selectByUri(String uri);

    public int insert(@Param("mockEntity") MockEntity mockEntity);

    public int update(@Param("mockEntity") MockEntity mockEntity);

    public int delete(int mockId);
}
