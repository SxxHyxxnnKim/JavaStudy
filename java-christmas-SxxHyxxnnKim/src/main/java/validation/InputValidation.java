package validation;

import view.ErrorMessage;

public class InputValidation {
    public boolean isInputInteger(String inputByUser) {
        try {
            Integer.parseInt(inputByUser);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR.getMessage() + ErrorMessage.ERROR_IS_NOT_NUMBER.getMessage());
        }
    }

    public void validationDate(String inputDate) {
        int date = Integer.parseInt(inputDate);
        checkDateRange(date);
    }

    private void checkDateRange(int date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(
                    ErrorMessage.ERROR.getMessage() + ErrorMessage.ERROR_DATE_RANGE_WRONG.getMessage());
        }
    }
}
