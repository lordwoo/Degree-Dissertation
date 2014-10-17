
package model;

/**
 * Represents a risk prediction mechanism that can predict whether or not a
 * patient is likely to have developed a certain medical condition.
 */
public interface Predictor
{
    /**
     * Predicts whether or not a patient falls into an "at-risk" category for a
     * condition.
     *
     * @param patient the patient data
     * @return the risk prediction, true if the patient is "at-risk", false
     * otherwise
     * @throws PredictorNotSuitableException if the patient data supplied is
     * insufficient for the prediction model to make a prediction
     */
    public boolean predictRisk(Patient patient) throws PredictorNotSuitableException;
}
