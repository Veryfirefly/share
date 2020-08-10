package cool.likeu.share.controller;

import cool.likeu.share.dao.Movie;
import cool.likeu.share.mapper.ShareMovieMapper;
import cool.likeu.share.vo.ShareResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/share/movie")
public class ShareMovieController {

    @Autowired
    private ShareMovieMapper shareMovieMapper;

    @GetMapping("/list")
    public Object listAllMovie() {

        return null;
    }

    @GetMapping("/{id}/find")
    public ShareResult<Movie> findMovie(@PathVariable("id") Integer id) {
        Movie movie = shareMovieMapper.selectById(id);
        return ShareResult.success(200, movie);
    }
}
