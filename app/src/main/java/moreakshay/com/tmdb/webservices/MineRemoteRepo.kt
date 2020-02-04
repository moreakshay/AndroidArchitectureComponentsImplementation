package moreakshay.com.tmdb.webservices

import io.reactivex.Observable
import moreakshay.com.tmdb.data.models.Movie
import moreakshay.com.tmdb.data.models.RequestToken

interface MineRemoteRepo {

    fun getToken(param: String): Observable<RequestToken>
    fun getNowPlayingMovies(param: HashMap<String, Any>): Observable<List<Movie>>
    fun getPopularMovies(param: HashMap<String, Any>): Observable<List<Movie>>
}