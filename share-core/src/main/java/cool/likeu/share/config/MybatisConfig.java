package cool.likeu.share.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"cool.likeu.share.mapper"})
public class MybatisConfig {
}
