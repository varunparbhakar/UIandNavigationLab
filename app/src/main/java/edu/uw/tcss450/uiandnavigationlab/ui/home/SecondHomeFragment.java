package edu.uw.tcss450.uiandnavigationlab.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uw.tcss450.uiandnavigationlab.R;
import edu.uw.tcss450.uiandnavigationlab.databinding.FragmentSecondHomeBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondHomeFragment extends Fragment {


    public SecondHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Local access to the ViewBinding object. No need to create as Instance Var as it is only
        //used here.
        FragmentSecondHomeBinding binding = FragmentSecondHomeBinding.bind(requireView());

        //On button click, navigate to Third Home
        binding.buttonNext.setOnClickListener(button ->
                Navigation.findNavController(requireView()).navigate(
                        SecondHomeFragmentDirections
                                .actionSecondHomeFragmentToThirdHomeFragment())
        );
    }
}
