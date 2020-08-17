package cool.likeu.share.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cool.likeu.share.dao.Movie;
import cool.likeu.share.service.ShareMovieService;
import cool.likeu.share.vo.MovieDTO;
import cool.likeu.share.vo.ShareResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class ShareMovieController {

    @Autowired
    private ShareMovieService shareMovieService;

    @GetMapping("/list")
    public ShareResult<IPage<Movie>> listAllMovie(@RequestParam("current") Integer current,
                                                  @RequestParam(value = "size", defaultValue = "2") Integer size) {
        return ShareResult.success(() ->
                shareMovieService.page(new Page<>(current, size)));
    }

    @GetMapping("/search")
    public ShareResult<List<Movie>> search(@RequestParam("keyword") String keyword) {
        List<Movie> searchMovie = shareMovieService.list(
                Wrappers.<Movie>lambdaQuery()
                        .like(Movie::getTitle, keyword));
        return ShareResult.success(200, searchMovie);
    }

    @PostMapping
    public ShareResult<Boolean> addMovie(@Validated @RequestBody MovieDTO movieDTO) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieDTO, movie);

        return ShareResult.success(() -> shareMovieService.save(movie));
    }

    @GetMapping("/{id}")
    public ShareResult<Movie> findMovie(@PathVariable("id") Integer id) {
        Movie movie = shareMovieService.getOne(
                Wrappers.<Movie>lambdaQuery()
                        .eq(Movie::getId, id));
        return ShareResult.success(200, movie);
    }
}
