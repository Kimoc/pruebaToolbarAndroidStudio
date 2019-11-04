package com.aarongutierrez.pruebatoolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button bActionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bActionBar=findViewById(R.id.bActionBar);

        if(getSupportActionBar().isShowing()){
            bActionBar.setText("Ocultar");
        }else{
            bActionBar.setText("Mostrar");
        }

        bActionBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionBar ab= getSupportActionBar();
                if(ab.isShowing()){
                    bActionBar.setText("Mostar");
                    ab.hide();
                }else{
                    bActionBar.setText("Ocultar");
                    ab.show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try{
            getMenuInflater().inflate(R.menu.main_menu,menu);
            return true;

        }catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.miSaluda:{
                Toast.makeText(this,"Saludos",Toast.LENGTH_SHORT).show();
                return  true;
            }
            case R.id.miDespedida:{
                Toast.makeText(this,"Despedir",Toast.LENGTH_SHORT).show();
                return true;
            }
            default:
                return false;
        }
    }
}
