package com.example.oddeven;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.oddeven.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private EditText inputEditText;
    private Button checkButton;
    private TextView resultView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputEditText = view.findViewById(R.id.inputEditText);
        checkButton = view.findViewById(R.id.checkButton);
        resultView = view.findViewById(R.id.resultTextView);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkOddEven();
            }
        });

    }

    private void checkOddEven() {
        String inputText = inputEditText.getText().toString();
        if (inputText.isEmpty()) {
            resultView.setText("Please enter a number.");
            return;
        }
        int n = Integer.parseInt(inputText);

        if(n % 2 == 0){
            resultView.setText("Number is even");
        }
        else{
            resultView.setText("Number is odd");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}