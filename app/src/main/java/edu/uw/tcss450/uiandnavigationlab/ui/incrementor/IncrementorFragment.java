package edu.uw.tcss450.uiandnavigationlab.ui.incrementor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uw.tcss450.uiandnavigationlab.R;
import edu.uw.tcss450.uiandnavigationlab.databinding.FragmentIncrementorBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IncrementorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IncrementorFragment extends Fragment {

    public IncrementorFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_incrementor, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Gain access to the ViewBinding object as a local variable instead of instance var
        FragmentIncrementorBinding binding = FragmentIncrementorBinding.bind(getView());
        binding.textCount.setText("TEST ER");
        //Obtain access to the ViewModel. If this fragment object is new, the ViewModel
        //will be re/created. Note the parameter to the ViewModelProvider constructor - this.
        IncrementorViewModel model =
                new ViewModelProvider(getActivity()).get(IncrementorViewModel.class);
        //Add an observer the the MutableLiveData - mCount.

        model.addCountObserver(getViewLifecycleOwner(), count -> {
            if(model.getCount() == 5){
                binding.textCount.setText("OMG ITS A 5");
            } else {
                binding.textCount.setText("My Count is: " + model.getCount());
            }
                });
        //On button click, increase the MutableLiveData - mCount
        binding.buttonIncrease.setOnClickListener(button -> model.increment());

    }
}