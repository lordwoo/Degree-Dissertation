
package misc;

import java.text.DecimalFormat;

/**
 * Performs unit conversion.
 */
public class UnitConverter
{
    // Declared privately as this class contains only static members
    private UnitConverter()
    {
    }

    /**
     * Ratio of pounds to kilograms for weight conversion.
     */
    public static final double POUNDS_PER_KG = 2.20462262185;

    /**
     * Converts a weight in kilograms to pounds.
     *
     * @param kg the weight in kilograms
     * @return the weight in pounds to one decimal place
     */
    public static double kgToLbs(double kg)
    {
        DecimalFormat decForm = new DecimalFormat("0.#");
        String lbs = decForm.format(kg * POUNDS_PER_KG);

        return Double.parseDouble(lbs);
    }

    /**
     * Converts a weight in pounds to kilograms.
     *
     * @param lbs the weight in pounds
     * @return the weight in kilograms to one decimal place
     */
    public static double lbsToKg(double lbs)
    {
        DecimalFormat decForm = new DecimalFormat("0.#");
        String kg = decForm.format(lbs / POUNDS_PER_KG);

        return Double.parseDouble(kg);
    }
}
