package cool.likeu.share.mapper;

import cool.likeu.share.dao.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static junit.framework.TestCase.assertTrue;

@SpringBootTest
class TestShareMovieMapper {

    @Autowired
    private ShareMovieMapper shareMovieMapper;

    @Test
    void testInsertMovieMapperAction() {
        Movie movie = new Movie();
        movie.setTitle("寻枪");
        movie.setDescription("《寻枪》是2002年上映的一部悬疑电影，本片是由陆川根据凡一平原著同名小说拍摄，" +
                "主要演员有姜文、宁静等。该片讲述了，警察马山一夜梦醒后，发现自己的枪不见了，" +
                "在丢失的枪里面有三颗子弹。于是，马山开始走上了一条不寻常的寻枪之路。");
        movie.setUrl("https://www.iqiyi.com/v_19rrjujjjg.html?vfm=2008_aldbd&fc=828fb30b722f3164&fv=p_02_01");
        movie.setCoverImageUrl("https://img9.doubanio.com/view/photo/s_ratio_poster/public/p1325360577.webp");
        movie.setScore(7.7F);

        int insert = shareMovieMapper.insert(movie);
        assertTrue(insert > 0);
    }

}
