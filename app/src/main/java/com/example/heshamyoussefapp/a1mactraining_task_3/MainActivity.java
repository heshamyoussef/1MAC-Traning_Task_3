package com.example.heshamyoussefapp.a1mactraining_task_3;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView red;
    TextView blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        red = (TextView) findViewById(R.id.textView);
        blue = (TextView) findViewById(R.id.textView4);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                red.setBackgroundColor(Color.rgb(200, seekBar.getProgress(), seekBar.getProgress()));
                blue.setBackgroundColor(Color.rgb(seekBar.getProgress(), seekBar.getProgress(), 200));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // red.setBackgroundColor(Color.rgb(255, 0 , 0));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // red.setBackgroundColor(Color.rgb(0, 255 , 255));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu:

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

                // Setting Dialog Message
                alertDialog.setMessage("For more info about this Training Task."
                        + "\nPlease visit 1MAC discussion forums!");


                alertDialog.setNegativeButton("NOT NOW", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

                // Setting visit forums Button
                alertDialog.setPositiveButton("VISIT FORUMS", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        // Visit the forums when visit forums button is clicked
                        Uri webpage = Uri.parse("https://macdiscussions.udacity.com/t/topic/99751");
                        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                    }
                });

                // Showing Alert Message
                alertDialog.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

