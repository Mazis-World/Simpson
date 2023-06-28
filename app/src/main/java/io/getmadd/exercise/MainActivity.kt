package io.getmadd.exercise

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.getmadd.exercise.api.DuckDuckGoResponse
import io.getmadd.exercise.api.DuckDuckGoService
import io.getmadd.exercise.api.RelatedTopic
import io.getmadd.exercise.api.RetrofitClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    val retrofit = RetrofitClient().getClient()
    val duckDuckGoService = retrofit?.create(DuckDuckGoService::class.java)
    var charactersList = listOf<RelatedTopic>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.character_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val query = "simpsons characters"
        val format = "json"

        GlobalScope.launch {
            val result = duckDuckGoService?.getResponse(query, format)

            result?.enqueue(object : Callback<DuckDuckGoResponse?>{
                override fun onResponse(call: Call<DuckDuckGoResponse?>?, response: Response<DuckDuckGoResponse?>) {
                    val statusCode: Int = response.code()
                    val response: DuckDuckGoResponse? = response.body()
                    Log.d("getData",statusCode.toString())

                    charactersList = response?.RelatedTopics!!
                    recyclerView.adapter = CharacterAdapter(charactersList)
                }

                override fun onFailure(call: Call<DuckDuckGoResponse?>?, t: Throwable?) {
                    Log.d("getData","Api Call Failure + ${t.toString()}")
                }
            })
        }
    }
}