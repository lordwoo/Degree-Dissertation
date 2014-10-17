
package model;

/**
 * <p>
 * A base class representing the prediction mechanism of simple medical
 * pre-screening tools, such as the Osteoporosis Pre-screening Risk Assessment
 * (OPERA). This class can be extended by a concrete implementation of one of
 * these tools, implementing the {@link #riskPoints(Patient)} method with it's
 * prediction algorithm.
 *
 * <p>
 * Pre-screening tools work by first generating a point total for the patient
 * based on the values of certain risk factors, e.g. if age > 60, +3 points.
 * This points total is then compared to a threshold, called the cutpoint: if it
 * equals or exceeds the cutpoint, the patient is considered to be at risk.
 */
public abstract class SimplePredictor implements Predictor
{
    private int cutpoint;

    public SimplePredictor()
    {
    }

    public SimplePredictor(int cutpoint)
    {
        this.cutpoint = cutpoint;
    }

    public int getCutpoint()
    {
        return cutpoint;
    }

    public void setCutpoint(int cutpoint)
    {
        this.cutpoint = cutpoint;
    }

    /**
     * Predicts whether or not a patient falls into an "at-risk" category for a
     * condition by calling the {@link #riskPoints(Patient)} method and
     * comparing the result to the cutpoint: if the result >= the cutpoint, the
     * patient is considered at-risk.
     *
     * @param patient the patient data
     * @return the risk prediction, true if the patient is "at-risk", false
     * otherwise
     * @throws PredictorNotSuitableException if the patient data supplied is
     * insufficient for the prediction model to make a prediction
     */
    @Override
    public boolean predictRisk(Patient patient) throws PredictorNotSuitableException
    {
        return riskPoints(patient) >= cutpoint;
    }

    /**
     * Calculates the patient's risk points total.
     *
     * @param patient the patient data
     * @return the risk points total
     * @throws PredictorNotSuitableException if the patient data supplied is
     * insufficient for the prediction model to make a prediction
     */
    public abstract int riskPoints(Patient patient) throws PredictorNotSuitableException;

    /**
     * Gets the name of the class, as returned by {@code getSimpleName()}.
     *
     * @return the name of the class
     */
    @Override
    public String toString()
    {
        return this.getClass().getSimpleName();
    }
}
