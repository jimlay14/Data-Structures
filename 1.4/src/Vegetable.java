/**
 * A class representing a vegetable; an extension of the Food class
 * @author Jacob
 *
 */
public class Vegetable extends Food
{
	//Data Fields
	
	public static double VEG_PROTEIN_CAL;
	public static double VEG_FAT_CAL;
	public static double VEG_CARBO_CAL;
	
	public Vegetable(double calories, int protein, double fat)
	{
		super.setCalories(calories);
		do{
			protein = protein / 2;
		}
		while(protein > calories);
		VEG_PROTEIN_CAL = (protein / calories); //ROUGH formula to ensure that there are less protein calories then there are calories
		double remainder = calories - VEG_PROTEIN_CAL;
		do{
			fat = fat / 2;
		}
		while(fat > remainder);
		VEG_FAT_CAL = (fat / remainder); //same with fat calories
		remainder -= VEG_FAT_CAL;
		VEG_CARBO_CAL = remainder; //and carbohydrates
	}

	@Override
	public double percentProtein() 
	{
		return VEG_PROTEIN_CAL / (VEG_PROTEIN_CAL + VEG_FAT_CAL + VEG_CARBO_CAL);
	}

	@Override
	public double percentFat() 
	{
		return VEG_FAT_CAL / (VEG_PROTEIN_CAL + VEG_FAT_CAL + VEG_CARBO_CAL);
	}

	@Override
	public double percentCarbohydrates()
	{
		return VEG_CARBO_CAL / (VEG_PROTEIN_CAL + VEG_FAT_CAL + VEG_CARBO_CAL);
	}

}
