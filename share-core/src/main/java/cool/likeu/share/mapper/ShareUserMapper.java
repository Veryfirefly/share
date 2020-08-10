package cool.likeu.share.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.likeu.share.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShareUserMapper extends BaseMapper<User> {

}
