package org.csystem.samples.sampleappwithjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText m_editTextMessage;
    private TextView m_textViewMessage;

    private void initViews()
    {
        m_editTextMessage = this.findViewById(R.id.MAINACTIVITY_EDITTEXT_MESSAGE);
        m_textViewMessage = this.findViewById(R.id.MAINACTIVITY_TEXTVIEW_MESSAGE);
    }

    private void init()
    {
        this.initViews();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
    }

    public void onOKButtonClicked(View view)
    {
        m_textViewMessage.setText(m_editTextMessage.getText().toString());
    }
}
