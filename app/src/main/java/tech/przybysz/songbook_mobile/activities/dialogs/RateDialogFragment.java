package tech.przybysz.songbook_mobile.activities.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import org.jetbrains.annotations.NotNull;

import tech.przybysz.songbook_mobile.R;

public class RateDialogFragment extends DialogFragment {

    public interface RateDialogListener {
        void onDialogPositiveClick(DialogFragment dialog, float result);
        void onDialogNegativeClick(DialogFragment dialog);
        void onDialogDeleteClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    private RateDialogListener listener;
    private float rating = 0f;

    public RateDialogFragment(Float rating) {
        if(rating == null) {
            rating = 0f;
        }
        this.rating = rating;
    }

    @NotNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.d("Dialog", "create");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_rating, null);
        ImageButton deleteBtn = v.findViewById(R.id.delete_btn);
        deleteBtn.setOnClickListener(view -> {
            listener.onDialogDeleteClick(RateDialogFragment.this);
            this.dismiss();
        });
        RatingBar ratingBar =  v.findViewById(R.id.ratingBar);
        ratingBar.setRating(rating);
        ratingBar.setOnRatingBarChangeListener((view, barRating, fromUser) -> {
            rating = view.getRating();
        });
        builder.setView(v)
                .setPositiveButton("Rate", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onDialogPositiveClick(RateDialogFragment.this, rating);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onDialogNegativeClick(RateDialogFragment.this);
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(@NotNull Context context) {
        super.onAttach(context);
        listener = (RateDialogListener) context;
    }
}
