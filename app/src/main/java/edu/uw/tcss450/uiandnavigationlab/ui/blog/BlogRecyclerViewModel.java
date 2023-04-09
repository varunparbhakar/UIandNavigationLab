package edu.uw.tcss450.uiandnavigationlab.ui.blog;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import edu.uw.tcss450.uiandnavigationlab.databinding.FragmentBlogCardBinding;

public class BlogRecyclerViewModel extends ViewModel {
    private FragmentBlogCardBinding binding;
    /**
     * No-arg constructor that initializes this object. Do not
     * Explicitly call this.
     */
    public BlogRecyclerViewModel(View view) {
        binding = FragmentBlogCardBinding.bind(view);
    }

// You may want to consider pass through methods for all observe and remove methods
// found in LiveData.
    /**
     * Return the current count.
     * @return the current count.
     */
    public FragmentBlogCardBinding getBinding() {
        return binding;
    }
}
