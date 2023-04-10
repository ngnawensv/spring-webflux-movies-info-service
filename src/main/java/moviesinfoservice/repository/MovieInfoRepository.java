package moviesinfoservice.repository;

import moviesinfoservice.domain.MovieInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieInfoRepository  extends ReactiveMongoRepository<MovieInfo,String> {

}
