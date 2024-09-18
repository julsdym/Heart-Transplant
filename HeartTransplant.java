/**
 * 
 * HeartTransplant class
 * 
 * @author Julia Dymnicki
 */
public class HeartTransplant {

    // patient array, each Patient is read from the data file
    private Patient[] patients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause survivabilityByCause;

    /*
     * Default constructor
     * Initializes patients to null.
     * Initializes survivabilityByAge to null.
     * Initializes survivabilityByCause to null. 
     */
    public HeartTransplant() {
       patients = null;
       survivabilityByAge = null;
       survivabilityByCause = null;
    }

    /*
     * Returns patients
     */
    public Patient[] getPatients() {

        return this.patients;
    }
    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge getSurvivabilityByAge() {
        return this.survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause getSurvivabilityByCause() {
        return this.survivabilityByCause;
    }

    /*
     * 1) Initialize the instance variable patients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file, use StdIn.readInt() to read an integer.
     *    File Format: 
     *      ID, ethnicity, Gender, Age, Cause, Urgency, State of health
     * 
     *    Each line refers to one Patient, all values are integers.
     * 
     */
    public void readPatients (int numberOfLines) {
        patients = new Patient[numberOfLines];

        for(int i =0; i < numberOfLines; i++)
        {
            patients[i] =new Patient(StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
            
        }
        
    }

    /*
     * 1) Initialize the instance variable survivabilityByAge with a new survivabilityByAge object.
     * 
     * 2) Reads from the command line file to populate the object. 
     *    Use StdIn.readInt() to read an integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     */
    public void readSurvivabilityByAge (int numberOfLines) {
        survivabilityByAge = new SurvivabilityByAge();
        for (int i =0; i < numberOfLines; i++){
            survivabilityByAge.addData(StdIn.readInt(), StdIn.readInt() , StdIn.readDouble()); 
        }
    }

    /*
     * 1) Initialize the instance variable survivabilityByCause with a new survivabilityByCause object.
     * 
     * 2) Reads from the command line file to populate the object. Use StdIn.readInt() to read an 
     *    integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     */
    public void readSurvivabilityByCause (int numberOfLines) {
        survivabilityByCause = new SurvivabilityByCause();
        for (int i = 0; i <numberOfLines;i++){
            survivabilityByCause.addData(StdIn.readInt(), StdIn.readInt(), StdIn.readDouble());
        }
    }
    
    /*
     * Returns a Patient array containing the patients, 
     * from the patients array, that have age above the parameter age.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with age above the parameter age.
     * 
     * Return null if there is no Patient with age above the 
     * parameter age.
     */ 
    public Patient[] getPatientsWithAgeAbove(int age) {
        int count =0;
        for(int i =0; i < patients.length; i++){
            if(this.patients[i].getAge() > age){
                count++;
            }
        }

        Patient[] agePatients = new Patient[count];
      
        int k=0;
        int i=0;
        while(i < agePatients.length){
            
            if(patients[k].getAge() > age){
                agePatients[i] = patients[k];
                i++;
            } 
                k++;
        }
        if(count==0){
            return null;
        }
            
        return agePatients;
    }

    /*
     * Returns a Patient array containing the patients, from the patients array, 
     * that have the heart condition cause equal to the parameter cause.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Patient with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Patient[] getPatientsByHeartConditionCause(int cause) {
        int count = 0;
        for(int i =0; i< patients.length;i++){
            if(patients[i].getCause() == cause) count++;
        }

        Patient[] arr = new Patient[count];

        int k=0;
        int i=0;
        while(i < arr.length){
            
            if(patients[k].getCause() == cause){
                arr[i] = patients[k];
                i++;
            } 
                k++;
            
        }

        if(count==0){
            return null;
        }
        return arr;
    }


    
    /*
     * Returns a Patient array containing patients, from the patients array,
     * that have the state of health equal to the parameter state.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the state of health equal to the parameter state.
     * 
     * Return null if there is no Patient with the state of health 
     * equal to the parameter state.
     */ 
    public Patient[] getPatientsByUrgency(int urgency) {
        int count = 0;
        for(int i =0; i < patients.length;i++){
            if(patients[i].getUrgency() == urgency) count++;
            }
        
            Patient[] urg = new Patient[count];
            
        int k=0;
        int i=0;
        while(i < urg.length){
            
            if(patients[k].getUrgency() == urgency){
                urg[i] = patients[k];
                i++;
            } 
                k++;
        }
        if(count==0){
            return null;
        }
	    return urg;
    }


    //creates patient array with patients that need a heart
    public Patient[] getPatientsByHeart(Patient[] heartArr){ 
        int count = 0;
        for(int i =0; i < heartArr.length;i++){
            if(heartArr[i].getNeedHeart() == true) count++;
            }
        Patient[] arr = new Patient[count];

        int k=0;
        int i=0;
        while(i < arr.length){
            
            if(heartArr[k].getNeedHeart() == true){
                arr[i] = heartArr[k];
                i++;
            } 
                k++;
        }
        if(count==0){
            return null;
        }
        return arr;
    }
    /*
     * Assume there is a heart available for transplantation surgery.
     * Also assume that the heart is of the same blood type as the
     * Patients on the patients array.
     * This method finds the Patient to be the recepient of this
     * heart.
     * 
     * The method returns a Patient from the patients array with
     * he highest potential for survivability after the transplant.
     * 
     * Assume the patient returned by this method will receive a heart,
     * therefore the Patient will no longer need a heart.
     * 
     * There is no correct solution, you may come up with any 
     * function to find the patient with the highest potential 
     * for survivability after the transplant.
     * 
     * 
     */ 

     private static void swap(Object[] a, int i, int j){
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

     

    public Patient getPatientForTransplant () {
      Patient extreme[] = getPatientsByUrgency(8); //get array of patients with extreme urgency
      Patient needHeart[] = getPatientsByHeart(extreme); //get array of patients with extreme urgency and need a heart
      double[] rate = new double[needHeart.length]; //create array of survivability rates
      

      for(int i=0; i < rate.length;i++){
        rate[i] = ((survivabilityByAge.getRate(needHeart[i].getAge(), 5)) + (survivabilityByCause.getRate(needHeart[i].getCause(),5)) /2.0);
    }

    for(int i=0; i<rate.length;i++){
        for(int j=i;j>0;j--){
            if(rate[j-1] > rate[j]){
                swap(needHeart, j-1, j);
            } else break;
        }
    }

      Patient p = needHeart[0];
        p.setNeedHeart(false);
        return p;
        
      
       // return null;
    }
}
