package com.codinginflow.disablebuttonwhenedittextisempty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.internal.TextWatcherAdapter;

public class MainActivity extends AppCompatActivity {

	private EditText editTextUsername, editTextPassword;
	private Button buttonConfirm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editTextUsername = findViewById(R.id.edit_text_username);
		editTextPassword = findViewById(R.id.edit_text_password);
		buttonConfirm = findViewById(R.id.button_confirm);

		editTextUsername.addTextChangedListener(loginTextWatcher);
		editTextPassword.addTextChangedListener(loginTextWatcher);
	}

	private TextWatcher loginTextWatcher = new TextWatcher() {
		@Override
		public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

		}

		@Override
		public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
			String usernameInput = editTextUsername.getText().toString().trim();
			String passwordInput = editTextPassword.getText().toString().trim();

			buttonConfirm.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
		}

		@Override
		public void afterTextChanged(Editable editable) {

		}
	};
}