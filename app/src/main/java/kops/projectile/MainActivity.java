package kops.projectile;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText angleEditText;
    private EditText velocityEditText;
    private EditText timeEditText;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angleEditText = (EditText) findViewById(R.id.angleET);
        velocityEditText = (EditText) findViewById(R.id.velocityET);
        timeEditText = (EditText) findViewById(R.id.timeET);

        // creates preferences for sharing date
        preferences = this.getSharedPreferences("DEFAULT" , MODE_PRIVATE);


    }


    @Override
    protected void onResume() {
        super.onResume();

        angleEditText.setText(preferences.getString("ANGLE",""));
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("ANGLE", angleEditText.getText().toString());
        editor.apply();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
