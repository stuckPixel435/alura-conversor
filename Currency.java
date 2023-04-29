package Challange2;

public enum Currency {
    DOLARES(3.76f),
    PESOS_MEXICANOS(4.84f),
    EUROS(0.24f);

    private final float currency;

    Currency(float currency){
        this.currency = currency;
    }

    public float getCurrency(){
        return currency;
    }

}
