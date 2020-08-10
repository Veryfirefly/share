package cool.likeu.share.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.likeu.share.dao.Movie;
import cool.likeu.share.mapper.ShareMovieMapper;
import cool.likeu.share.service.ShareMovieService;
import cool.likeu.share.vo.SharePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShareMovieServiceImpl implements ShareMovieService {

    @Autowired
    private ShareMovieMapper shareMovieMapper;

    @Override
    public SharePage<Movie> listAllMovies(Integer current, Integer size) {
        Page<Movie> pagedData = shareMovieMapper.selectPage(new Page<>(current, size), null);
        SharePage<Movie> sharePage = new SharePage<>();
        sharePage.setCurrent(pagedData.getCurrent());
        sharePage.setSize(pagedData.getSize());
        sharePage.setTotal(pagedData.getTotal());
        sharePage.setData(pagedData.getRecords());
        return sharePage;
    }

    @Override
    public List<Movie> searchMovie(String keyword) {
        List<Movie> movies = shareMovieMapper.selectList(
                Wrappers.<Movie>lambdaQuery()
                        .like(Movie::getTitle, keyword));
        if (CollectionUtils.isEmpty(movies)) {
            return Collections.emptyList();
        }
        return movies;
    }
}
