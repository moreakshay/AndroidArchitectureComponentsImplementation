package moreakshay.com.tmdb.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_home.*
import moreakshay.com.tmdb.R
import moreakshay.com.tmdb.data.*
import moreakshay.com.tmdb.webservices.MineRemoteRepo
import moreakshay.com.tmdb.webservices.MineRemoteRepoImpl

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bnv.setupWithNavController(findNavController(R.id.fr_container))
        var remoteRepo: MineRemoteRepo = MineRemoteRepoImpl()
        var mineDBImpl: MineDatabase = Room.databaseBuilder(this, MineDatabase::class.java, "sdfsdf").build()
        var localRepo: MineLocalRepo = MineLocalRepoImpl(mineDBImpl.movieDao(), mineDBImpl.teleDao())
        var mineRepo: MineRepository = MineRepositoryImpl(localRepo, remoteRepo)

        var body: HashMap<String, Any> = HashMap()
        body.put("api_key", getString(R.string.API_KEY))
        mineRepo.getToken(getString(R.string.API_KEY))

//        var list = mineRepo.getNowPlayingMovies(getString(R.string.API_KEY))
        var list = mineRepo.getNowPlayingMovies(getString(R.string.API_KEY))
        list.forEach {
            Log.e("Bhenchod database se", it.originalName)
        }
    }
}
