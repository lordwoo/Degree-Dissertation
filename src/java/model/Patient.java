
package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a patient being sent for a medical risk prediction.
 */
public class Patient
{
    public enum Gender
    {
        MALE, FEMALE;
    }

    public enum Ethnicity
    {
        BLACK, OTHER;
    }

    private Gender gender;
    private int age;            // age in years
    private double weight;      // weight in kilograms
    private Map optionalFields = new HashMap();
    private boolean prediction = false;

    public Patient()
    {
    }

    public Patient(Gender gender, int age, double weight)
    {
        this.gender = gender;
        this.age = age;
        this.weight = weight;
    }

    public Patient(Gender gender, int age, double weight, Map optionalFields)
    {
        this(gender, age, weight);
        this.optionalFields = optionalFields;
    }

    /**
     * @return the gender of the patient
     */
    public Gender getGender()
    {
        return gender;
    }

    /**
     * @param gender a gender
     */
    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    /**
     * @return the age of the patient in years
     */
    public int getAge()
    {
        return age;
    }

    /**
     * @param age an age in years
     */
    public void setAge(int age)
    {
        this.age = age;
    }

    /**
     * @return the weight of the patient in kilograms
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     * @param weight a weight in kilograms
     */
    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    /**
     * @return any optional patient data
     */
    public Map getOptionalFields()
    {
        return optionalFields;
    }

    /**
     * @param optionalFields optional patient data
     */
    public void setOptionalFields(Map optionalFields)
    {
        this.optionalFields = optionalFields;
    }

    /**
     * A convenience method to check if an optional field is present.
     *
     * @param fieldName the field to check for
     * @return true if the field is present, false otherwise
     */
    public boolean hasOptionalField(String fieldName)
    {
        return optionalFields.containsKey(fieldName);
    }

    /**
     * A convenience method to get the value of an optional field.
     *
     * @param fieldName the field to get
     * @return the value of the field, or null if it is not present
     */
    public Object getOptionalField(String fieldName)
    {
        return optionalFields.get(fieldName);
    }

    /**
     * A convenience method to add an optional field. If the field already
     * exists, it will be overwritten, and the previous value will be returned.
     *
     * @param fieldName the name of the field
     * @param value the value of the field
     * @return the previous value of this field if it already existed, otherwise
     * null
     */
    public Object addOptionalField(String fieldName, Object value)
    {
        return optionalFields.put(fieldName, value);
    }

    /**
     * @return the risk prediction
     */
    public boolean isPrediction()
    {
        return prediction;
    }

    /**
     * @param prediction a risk prediction
     */
    public void setPrediction(boolean prediction)
    {
        this.prediction = prediction;
    }

    /**
     * @return a list of the patient's fields and their values
     */
    @Override
    public String toString()
    {
        String str = "";
        str += "Gender: " + gender + ", Age: " + age + ", Weight: " + weight + ", ";
        for (Object key : optionalFields.keySet())
        {
            str += key + ": " + optionalFields.get(key) + ", ";
        }
        str += "Osteoporotic: " + prediction;

        return str;
    }
}
