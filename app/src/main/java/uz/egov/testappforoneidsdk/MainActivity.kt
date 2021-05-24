package uz.egov.testappforoneidsdk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import uz.egov.one_id.data.dto.res.UserPersonalInfo
import uz.egov.one_id.model.Config.LOGIN_REQUEST_CODE
import uz.egov.one_id.model.Config.PERSONAL_INFO
import uz.egov.one_id.view.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gotoBtn.setOnClickListener {
            gotoLogin()
        }
    }
    private fun gotoLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivityForResult(intent, LOGIN_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == LOGIN_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                //here all needed user data
                val personalInfo = data?.getSerializableExtra(PERSONAL_INFO) as UserPersonalInfo
                Log.d("MainActivity", "Personal Info : $personalInfo")
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}