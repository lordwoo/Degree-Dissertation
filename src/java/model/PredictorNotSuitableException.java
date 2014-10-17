
package model;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * This exception is thrown any time a {@link Predictor} has insufficient
 * patient data to make a prediction, such as a missing field or invalid value.
 * 
 * <p>
 * Implements the standard exception constructors.
 */
public class PredictorNotSuitableException extends Exception
{
    private List<String> missingFields = new LinkedList<>();

    /**
     * A default message for the exception.
     */
    public static final String DEFAULT_MESSAGE = "Predictor model not suitable "
            + "for this patient.";

    /**
     * Sets the exception message to be the {@link #DEFAULT_MESSAGE}.
     */
    public PredictorNotSuitableException()
    {
        super(DEFAULT_MESSAGE);
    }

    public PredictorNotSuitableException(String message)
    {
        super(message);
    }

    public PredictorNotSuitableException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PredictorNotSuitableException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Gets a list of fields that were missing from the patient data.
     *
     * @return the missing fields
     */
    public List<String> getMissingFields()
    {
        return missingFields;
    }

    /**
     * Sets the list of fields that were missing from the patient data.
     *
     * @param missingFields the missing fields
     */
    public void setMissingFields(List<String> missingFields)
    {
        this.missingFields = missingFields;
    }

    /**
     * A convenience method to add a missing field to the missing field list.
     * Equivalent to calling {@code getMissingFields().add(fieldName)}.
     *
     * @param fieldName the name of the missing field
     */
    public void addMissingField(String fieldName)
    {
        missingFields.add(fieldName);
    }
}
