
package model;

/**
 * The Osteoporosis Self-assessment Tool for Asians is a medical pre-screening
 * tool for identifying patients who are at risk for having developed
 * osteoporosis.
 * <p>
 * OSTA uses the following algorithm for risk point generation: take the
 * patient's weight in kilograms, subtract their age in years, multiply by 0.2,
 * and truncate to an integer.
 */
public class OSTA extends SimplePredictor
{
    /**
     * Default cutpoint for OSTA, as determined by the original development
     * study.
     */
    public static final int STD_CUTPOINT = 3;

    /**
     * Sets the cutpoint to the default, {@link #STD_CUTPOINT}.
     */
    public OSTA()
    {
        setCutpoint(STD_CUTPOINT);
    }

    public OSTA(int cutpoint)
    {
        super(cutpoint);
    }

    @Override
    public int riskPoints(Patient patient)
    {
        return (int) ((patient.getWeight() - patient.getAge()) * 0.2);
    }

    /**
     * Overrides the parent method as the risk prediction logic is slightly
     * different: patient is considered at risk if the result is equal to or
     * <em>lower</em>
     * than the cutpoint, rather than higher.
     *
     * @param patient the patient data
     * @return the risk prediction, true if the patient is "at-risk", false
     * otherwise
     */
    @Override
    public boolean predictRisk(Patient patient)
    {
        return riskPoints(patient) <= getCutpoint();
    }
}
