package com.example.myapplicationmoviessenior.ui.movies


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.Resource
import com.example.myapplicationmoviessenior.R
import com.example.myapplicationmoviessenior.databinding.FragmentMoviesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MoviesFragment : Fragment() {

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding
    private val viewModel by viewModels<MoviesVieModel>()

    @Inject
    lateinit var moviesDataAdapterRec: MoviesDataAdapter

    @Inject
    lateinit var moviesDataAdapterRat: MoviesDataAdapter

    @Inject
    lateinit var moviesDataAdapterPop: MoviesDataAdapter

    @Inject
    lateinit var tvDataAdapterRec: TvDataAdapter

    @Inject
    lateinit var tvDataAdapterRat: TvDataAdapter

    @Inject
    lateinit var tvDataAdapterPop: TvDataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(inflater, container, false)
        return fragmentMoviesBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setActionBarTitle()
        initRecyclerView()

        if (isNetworkAvailable(requireContext())) {
            Toast.makeText(
                context, getString(R.string.sin),
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(
                context, getString(R.string.refresh),
                Toast.LENGTH_LONG
            ).show()
        }

        viewModel.getMoviesRec()
        viewModel.getTvRec()

        viewModel.getMoviesRecLoc().observe(viewLifecycleOwner, {
            moviesDataAdapterRec.differ.submitList(it)
        })

        viewModel.getMoviesRatLoc().observe(viewLifecycleOwner, {
            moviesDataAdapterRat.differ.submitList(it)
        })

        viewModel.getMoviesPopLoc().observe(viewLifecycleOwner, {
            moviesDataAdapterPop.differ.submitList(it)
        })

        viewModel.getTvRecLoc().observe(viewLifecycleOwner, {
            tvDataAdapterRec.differ.submitList(it)
        })

        viewModel.getTvRatLoc().observe(viewLifecycleOwner, {
            tvDataAdapterRat.differ.submitList(it)
        })

        viewModel.getTvPopLoc().observe(viewLifecycleOwner, {
            tvDataAdapterPop.differ.submitList(it)
        })

    }

    private fun initRecyclerView() {
        fragmentMoviesBinding.rvMoviesA.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            adapter = moviesDataAdapterRec
        }

        fragmentMoviesBinding.rvMoviesB.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            adapter = moviesDataAdapterRat
        }

        fragmentMoviesBinding.rvMoviesC.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            adapter = moviesDataAdapterPop
        }

        fragmentMoviesBinding.rvTvA.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            adapter = tvDataAdapterRec
        }

        fragmentMoviesBinding.rvTvB.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            adapter = tvDataAdapterRat
        }

        fragmentMoviesBinding.rvTvC.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            adapter = tvDataAdapterPop
        }
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun isNetworkAvailable(context: Context) =
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
            getNetworkCapabilities(activeNetwork)?.run {
                hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                        || hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                        || hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            } ?: false
        }

    private fun setActionBarTitle() {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = ""
    }

}