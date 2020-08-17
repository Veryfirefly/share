package cool.likeu.share.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.likeu.share.dao.User;
import cool.likeu.share.mapper.ShareUserMapper;
import cool.likeu.share.service.ShareUserService;
import org.springframework.stereotype.Service;

@Service
public class ShareUserServiceImpl extends ServiceImpl<ShareUserMapper, User> implements ShareUserService {

}
