package cool.likeu.share.controller;

import cool.likeu.share.dao.Movie;
import cool.likeu.share.service.ShareMovieService;
import cool.likeu.share.vo.SharePage;
import cool.likeu.share.vo.ShareResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ShareResult<SharePage<Movie>> listAllMovie(@RequestParam("current") Integer current,
                                                      @RequestParam(value = "size", defaultValue = "2") Integer size) {
        SharePage<Movie> pageMovies = shareMovieService.listAllMovies(current, size);
        return ShareResult.success(200, pageMovies);
    }

    @GetMapping("/search")
    public ShareResult<List<Movie>> search(@RequestParam("keyword") String keyword) {
        List<Movie> movies = shareMovieService.searchMovie(keyword);
        return ShareResult.success(200, movies);
    }

    @GetMapping("/{id}/find")
    public ShareResult<Movie> findMovie(@PathVariable("id") Integer id) {
        return ShareResult.failure(500, "This interface is not currently supported");
    }
}
