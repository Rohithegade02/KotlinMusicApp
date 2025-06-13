package com.example.musicapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp.ui.theme.MusicAppTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.actvity_view)

        val retroFitBuilder=Retrofit.
        Builder().
        baseUrl("https://deezerdevs-deezer.p.rapidapi.com").
                addConverterFactory(GsonConverterFactory.create()).
                build().
                create(ApiInterface::class.java)

        val retroFitData=retroFitBuilder.getData("eminem")

        retroFitData.enqueue(object:Callback<MyData?>{
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val dataList=response.body()
                val textView=findViewById<TextView>(R.id.textView)

                textView.text=dataList.toString()
                Log.d(
                    "onResponse",
                   "onResponse Data:"+ response.body()
                )
            }
            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d(
                    "onFailure",
                    "onFailure Data:"+t.message.toString()
                )
            }

        })

    }
}
