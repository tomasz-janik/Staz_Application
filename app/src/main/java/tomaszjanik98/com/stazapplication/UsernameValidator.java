package tomaszjanik98.com.stazapplication;

import android.text.Editable;
import android.text.TextWatcher;

public class UsernameValidator implements TextWatcher {

    private boolean mIsValid = false;

    public boolean isValid() {
        return mIsValid;
    }

    /**
     * Validates if the given input is a valid username.
     * @param username        The email to validate.
     * @return {@code true} if the input is a valid username. {@code false} otherwise.
     */
    static boolean isValidUsername(CharSequence username) {
        return username != null && !username.toString().isEmpty();
    }

    @Override
    final public void afterTextChanged(Editable editableText) {
        mIsValid = isValidUsername(editableText);
    }

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {}
}
