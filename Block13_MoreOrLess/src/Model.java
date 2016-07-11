

/**
 * Created by User on 15.04.2016.
 */
public class Model {
    /**
     *
     */
    private int minBarrier;
    /**
     *
     */
    private int maxBarrier;
    /**
     *
     */
    private int secretValue;
Model(){
	setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER,
            GlobalConstants.PRIMARY_MAX_BARRIER);
	setPrimaryBarrier(GlobalConstants.PRIMARY_MIN_BARRIER, GlobalConstants.PRIMARY_MAX_BARRIER);
	setSecretValue();
}
    /**
     *
     * @param value
     * @return
     */
    public boolean checkValue (int value){
        if (value == secretValue){
            return true;
        } else if (value > secretValue){
            maxBarrier = value;
        } else {
            minBarrier = value;
        }
      return false;
    }

    /**
     *
     * @param minBarrier
     * @param maxBarrier
     */
    public void setPrimaryBarrier(int minBarrier, int maxBarrier){
        this.minBarrier = minBarrier; // check
        this.maxBarrier = maxBarrier;
    }

    /**
     *
     */
    public void setSecretValue() {
        secretValue = (int)Math.ceil(Math.random() *
                (maxBarrier - minBarrier -1) + minBarrier);
    }

    public int getSecretValue() {
        return secretValue;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }
}
