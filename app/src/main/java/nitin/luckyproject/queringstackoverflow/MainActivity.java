package nitin.luckyproject.queringstackoverflow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    private String token;
    private Button authenticateButton;
    private Spinner questionSpinner;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionSpinner = findViewById(R.id.questions_spinner);
        questionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "spinner item selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        List<Questions> questions =FakeDataProvider.getQuestions();
        ArrayAdapter<Questions> arrayAdapter = new ArrayAdapter<Questions>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,questions);
        questionSpinner.setAdapter(arrayAdapter);


        authenticateButton = findViewById(R.id.authenticate_button);
        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        List<Answer> answers = FakeDataProvider.getAnswers();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(answers);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
      switch (view.getId()){
          case android.R.id.text1:
              if (token != null)
              {
              }
              else{
                  Toast.makeText(this, "You need to authenticate first", Toast.LENGTH_SHORT).show();
              }
              break;
          case R.id.authenticate_button:

              break;
      }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(token!=null){
            authenticateButton.setEnabled(false);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode ==1){
            token = data.getStringExtra("token");
        }
    }
}
