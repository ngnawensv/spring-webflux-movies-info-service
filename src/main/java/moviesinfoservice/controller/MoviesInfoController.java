package moviesinfoservice.controller;

import moviesinfoservice.domain.MovieInfo;
import moviesinfoservice.service.MoviesInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
public class MoviesInfoController {

  private MoviesInfoService moviesInfoService;

  public MoviesInfoController(MoviesInfoService moviesInfoService) {
    this.moviesInfoService = moviesInfoService;
  }

  @PostMapping("/movieinfos")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<MovieInfo> addMovieInfo(@RequestBody MovieInfo movieInfo){
    return moviesInfoService.addMovieInfo(movieInfo).log();
  }

  @GetMapping("/movieinfos")
  public Flux<MovieInfo> getAllMovieInfos(){
    return moviesInfoService.getAllMovieInfos().log();
  }

  @GetMapping("/movieinfos/{id}")
  public Mono<MovieInfo> getMovieInfosById(@PathVariable String id){
    return moviesInfoService.getMovieInfosById(id).log();
  }

  @PutMapping("/movieinfos/{id}")
  public Mono<MovieInfo> updateMovieInfo(@RequestBody MovieInfo updateMovieInfo,@PathVariable String id){
    return moviesInfoService.updateMovieInfo(updateMovieInfo,id).log();
  }

  @DeleteMapping("/movieinfos/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteMovieInfo(@PathVariable String id){
    return moviesInfoService.deleteMovieInfo(id).log();
  }

}
