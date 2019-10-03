package riflocike.co.kr.androidtesttdd.network

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import riflocike.co.kr.androidtesttdd.R
import riflocike.co.kr.androidtesttdd.network.util.NetworkModel
import riflocike.co.kr.androidtesttdd.network.util.getInstance

class NetworkUnitTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_unit_test)

        getInstance()?.get_userLogin("riflockle7", "abcd")?.apply {
            enqueue(object : Callback<NetworkModel>{
                override fun onFailure(call: Call<NetworkModel>, t: Throwable) {
                    Toast.makeText(this@NetworkUnitTestActivity, t.toString(), Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<NetworkModel>, response: Response<NetworkModel>) {
                    // 1. Toast로 확인
                    Toast.makeText(this@NetworkUnitTestActivity, response.body().toString(), Toast.LENGTH_SHORT).show()

                    // 2. Log 로 확인
                    Log.d(TAG, response.body().toString())

                    // 3. Retrofit2 -> HttpLoggingInterceptor 으로 확인
                }

            })
        }
    }

    companion object {
        const val TAG = "NetworkUnitTestActivity"
    }
}
