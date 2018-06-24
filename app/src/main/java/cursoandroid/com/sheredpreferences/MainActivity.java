package cursoandroid.com.sheredpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textoNome;
    private TextView nomeResultado;
    private Button btnSalvar;
    private static  final  String ARQUIRO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNome = findViewById(R.id.editNomeID);
        nomeResultado = findViewById(R.id.editResultadoId);
        btnSalvar = findViewById(R.id.btnSalvarId);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIRO_PREFERENCIA,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(textoNome.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "O campo nome está vazio",Toast.LENGTH_SHORT).show();

                }else{
                    editor.putString("nome", textoNome.getText().toString());
                    editor.commit();
                    nomeResultado.setText("Olá "+ textoNome.getText().toString());
                }


            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIRO_PREFERENCIA,0);
        if(sharedPreferences.contains("nome")){
            String nomeUsuario= sharedPreferences.getString("nome","usuario não definito");
            nomeResultado.setText("Olá "+nomeUsuario);

        }else{
            nomeResultado.setText("Olá usuario não definido.");
        }
    }
}
