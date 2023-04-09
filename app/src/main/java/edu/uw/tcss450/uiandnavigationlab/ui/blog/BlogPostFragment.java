package edu.uw.tcss450.uiandnavigationlab.ui.blog;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.uw.tcss450.uiandnavigationlab.R;
import edu.uw.tcss450.uiandnavigationlab.databinding.FragmentBlogPostBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlogPostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlogPostFragment extends Fragment {


    public BlogPostFragment() {
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
        return inflater.inflate(R.layout.fragment_blog_post, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BlogPostFragmentArgs args = BlogPostFragmentArgs.fromBundle(getArguments());
        FragmentBlogPostBinding binding = FragmentBlogPostBinding.bind(getView());
        binding.textPubdate.setText(args.getBlog().getPubDate());
        binding.textTitle.setText(args.getBlog().getTitle());
        final String preview = Html.fromHtml(
                        args.getBlog().getTeaser(),
                        Html.FROM_HTML_MODE_COMPACT)
                .toString();
        binding.textPreview.setText(preview);
        //Note we are using an Intent here to start the default system web browser
        binding.buttonUrl.setOnClickListener(button ->
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse(args.getBlog().getUrl()))));
    }
}