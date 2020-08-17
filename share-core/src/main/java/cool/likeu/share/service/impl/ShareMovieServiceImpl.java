package cool.likeu.share.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cool.likeu.share.dao.Movie;
import cool.likeu.share.mapper.ShareMovieMapper;
import cool.likeu.share.service.ShareMovieService;
import org.springframework.stereotype.Service;

@Service
public class ShareMovieServiceImpl extends ServiceImpl<ShareMovieMapper, Movie> implements ShareMovieService {

}
