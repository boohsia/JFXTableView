package em.libs.jfxtableview.validators;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.base.ValidatorBase;
import em.libs.jfxtableview.FilteredJFXComboBoxWithClear;
import em.libs.jfxtableview.FilteredJFXComboBox;

public class LongRangeValidator extends ValidatorBase {

    public LongRangeValidator(String message) {
        super(message);
    }

    @Override
    protected void eval() {
        String text = null;

        if (srcControl.get() instanceof FilteredJFXComboBoxWithClear) {
            FilteredJFXComboBoxWithClear comboField = (FilteredJFXComboBoxWithClear) srcControl.get();
            text = comboField.getEditor().getEditor().getText();
        } else if (srcControl.get() instanceof FilteredJFXComboBox) {
            FilteredJFXComboBox comboField = (FilteredJFXComboBox) srcControl.get();
            text = comboField.getEditor().getText();
        } else if (srcControl.get() instanceof JFXTextField) {
            JFXTextField textField = (JFXTextField) srcControl.get();
            text = textField.getText();
        }

        if (text == null || text.equals("")) {
            hasErrors.set(false);
        } else {

            try {
                Long.valueOf(text);
                hasErrors.set(false);
            } catch (Exception e) {
                hasErrors.set(true);
            }
        }
    }
}