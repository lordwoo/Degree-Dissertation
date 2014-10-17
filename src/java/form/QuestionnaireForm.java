
package form;

import framework.Validation;
import misc.UnitConverter;
import framework.FormField;
import framework.Form;
import model.Patient;

/**
 * A form that corresponds to the HTML form in questionnaire.jsp.
 */
public final class QuestionnaireForm extends Form
{
    @FormField(displayName = "Age", min = 0, max = 130)
    private int age;
    
    @FormField(displayName = "Weight", min = 0)
    private double weight;
    
    @FormField(displayName = "Gender")
    private Patient.Gender gender;
    
    @FormField(displayName = "Weight unit")
    private String weightUnit;

    /**
     * Checks if weight was supplied in pounds and, if so, converts it to
     * kilograms for use by the risk prediction systems.
     */
    @Validation
    public void convertWeight()
    {
        if (weightUnit.equalsIgnoreCase("pounds"))
        {
            weight = UnitConverter.lbsToKg(weight);
        }
    }

    /**
     * @return the patient's age
     */
    public int getAge()
    {
        return age;
    }

    /**
     * @return the patient's weight
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     * @return the patient's gender
     */
    public Patient.Gender getGender()
    {
        return gender;
    }
}
