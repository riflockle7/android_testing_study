package riflocike.co.kr.androidtesttdd.ui_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_uitest.*
import riflocike.co.kr.androidtesttdd.R

class UITestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uitest)

        setupView()
    }

    fun setupView(){
        btn_float.apply {
            btn_float.isSelected = false

            setOnClickListener {
                Log.d("btn_float isSelected : ", "${isBtnSelected()}")
                btn_float.isSelected = !btn_float.isSelected
            }
        }
    }

    fun isBtnSelected() : Boolean {
        return btn_float.isSelected
    }
}
