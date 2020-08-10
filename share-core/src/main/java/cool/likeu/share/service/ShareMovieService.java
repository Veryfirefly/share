package cool.likeu.share.service;

import cool.likeu.share.dao.Movie;
import cool.likeu.share.vo.SharePage;

import java.util.List;

public interface ShareMovieService {

    /**
     *
     * @param current current page
     * @param size page size
     * @return {@link SharePage}
     */
    SharePage<Movie> listAllMovies(Integer current, Integer size);

    List<Movie> searchMovie(String keyword);

}
