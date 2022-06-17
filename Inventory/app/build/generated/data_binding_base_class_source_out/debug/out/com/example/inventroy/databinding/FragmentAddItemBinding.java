// Generated by view binder compiler. Do not edit!
package com.example.inventroy.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.inventroy.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAddItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextInputLayout addItemQuantity;

  @NonNull
  public final TextInputEditText addItemQuantityInput;

  @NonNull
  public final TextInputLayout addItemTitle;

  @NonNull
  public final TextInputEditText addItemTitleInput;

  @NonNull
  public final TextInputLayout addItemUnits;

  @NonNull
  public final TextInputEditText addItemUnitsInput;

  private FragmentAddItemBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextInputLayout addItemQuantity, @NonNull TextInputEditText addItemQuantityInput,
      @NonNull TextInputLayout addItemTitle, @NonNull TextInputEditText addItemTitleInput,
      @NonNull TextInputLayout addItemUnits, @NonNull TextInputEditText addItemUnitsInput) {
    this.rootView = rootView;
    this.addItemQuantity = addItemQuantity;
    this.addItemQuantityInput = addItemQuantityInput;
    this.addItemTitle = addItemTitle;
    this.addItemTitleInput = addItemTitleInput;
    this.addItemUnits = addItemUnits;
    this.addItemUnitsInput = addItemUnitsInput;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAddItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAddItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_add_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAddItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addItemQuantity;
      TextInputLayout addItemQuantity = ViewBindings.findChildViewById(rootView, id);
      if (addItemQuantity == null) {
        break missingId;
      }

      id = R.id.addItemQuantityInput;
      TextInputEditText addItemQuantityInput = ViewBindings.findChildViewById(rootView, id);
      if (addItemQuantityInput == null) {
        break missingId;
      }

      id = R.id.addItemTitle;
      TextInputLayout addItemTitle = ViewBindings.findChildViewById(rootView, id);
      if (addItemTitle == null) {
        break missingId;
      }

      id = R.id.addItemTitleInput;
      TextInputEditText addItemTitleInput = ViewBindings.findChildViewById(rootView, id);
      if (addItemTitleInput == null) {
        break missingId;
      }

      id = R.id.addItemUnits;
      TextInputLayout addItemUnits = ViewBindings.findChildViewById(rootView, id);
      if (addItemUnits == null) {
        break missingId;
      }

      id = R.id.addItemUnitsInput;
      TextInputEditText addItemUnitsInput = ViewBindings.findChildViewById(rootView, id);
      if (addItemUnitsInput == null) {
        break missingId;
      }

      return new FragmentAddItemBinding((ConstraintLayout) rootView, addItemQuantity,
          addItemQuantityInput, addItemTitle, addItemTitleInput, addItemUnits, addItemUnitsInput);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}