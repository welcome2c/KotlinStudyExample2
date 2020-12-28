package com.example.kotlinstudy.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.kotlinstudy.R
import com.example.kotlinstudy.databinding.ActivityMainBinding
import com.example.kotlinstudy.ui.base.BaseActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding {
            mainVm = mainViewModel
            btnGetWeather.setOnClickListener {
                if (etLongitude.text.isEmpty() || etLatitude.text.isEmpty()) {
                    Snackbar.make(parentView, "위도, 경도를 입력해주세요.", Snackbar.LENGTH_SHORT).show()
                } else {
                    mainViewModel.getWeatherData(etLongitude.text.toString().toDouble(), etLatitude.text.toString().toDouble())
                }
            }
        }

        observing {
            errorMsg.observe(this@MainActivity, Observer {
                Snackbar.make(parentView, it, Snackbar.LENGTH_SHORT).show()
            })

            weatherData.observe(this@MainActivity, Observer {
                tvCoord.text = "Coord : " + "\n\tlon : " + it.coord.lon + "\n\tlat : " + it.coord.lat
                tvWeather.text = "Weather : " + "\n" + "\tid : " + it.id + "\n\tmain : " + it.main +
                        "\n\tdescription : " + it.weather[0].description + "\n\ticon : " + it.weather[0].icon
                tvBase.text = "Base : " + it.base
                tvMain.text = "Main : " + "\n\ttemp : " + it.main.temp + "\n\tfeels_like : " + it.main.feels_like + "\n\ttemp_main : " + it.main.temp_min +
                        "\n\ttemp_max : " + it.main.temp_max + "\n\tpressure : " + it.main.pressure + "\n\thumidity : " + it.main.humidity
                tvVisibility.text = "Visibility : " + it.visibility
                tvWind.text = "Wind : " + "\n\tspeed : " + it.wind.speed + "\n\tdeg : " + it.wind.deg
                tvClouds.text = "Clouds : " + "\n\tall : " + it.clouds.all
                tvDt.text = "Dt : " + it.dt
                tvSys.text = "Sys : " + "\n\tcountry : " + it.sys.country + "\n\tsunrise : " + it.sys.sunrise + "\n\tsunset : " + it.sys.sunset
                tvTimeZone.text = "TimeZone : " + it.timezone
                tvId.text = "Id : " + it.id
                tvName.text = "Name : " + it.name
                tvClouds.text = "Cod : " + it.cod
            })
        }
    }

    private fun observing(action: MainViewModel.() -> Unit) {
        mainViewModel.run(action)
    }
}