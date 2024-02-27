package com.techelevator;

import java.math.BigDecimal;

public class FlowerShopOrder {

    private final BigDecimal BASE_PRICE = BigDecimal.valueOf(19.99);
    private final BigDecimal PRICE_PER_ROSE = BigDecimal.valueOf(2.99);

    private String bouquetType;
    private int numRoses;

    //private BigDecimal subtotal;    // derived property instead

    public BigDecimal subtotal(){
        BigDecimal numRosesBigDecimal = BigDecimal.valueOf(numRoses);
        BigDecimal costOfRoses = PRICE_PER_ROSE.multiply(numRosesBigDecimal);
        return BASE_PRICE.add(costOfRoses);
    }

    public FlowerShopOrder(String bouquetType, int numRoses){
        this.bouquetType = bouquetType;
        this.numRoses = numRoses;
    }

    /*
     * Method:
     *  1. inputs
     *  2. output (return type)
     *  3. name
     *  4. (optional) access modifier
     */
    public BigDecimal getDeliveryTotal(boolean sameDayDelivery, String zipCode){

        // 1a. Create variable for the return
        BigDecimal deliveryFee = BigDecimal.ZERO;

        Integer zipCodeNum = Integer.parseInt(zipCode);

        /*
         * If-else conditions for ZIP codes
         * Check length of string is 5 and first letter is a "2"
         */
        if(zipCode.length() == 5 && zipCode.startsWith("2")){

            deliveryFee = deliveryFee.add(BigDecimal.valueOf(3.99));

        } else if(zipCode.length() == 5 && zipCode.startsWith("3")){

            deliveryFee = deliveryFee.add(BigDecimal.valueOf(6.99));

        } else if(zipCode.length() == 5 && zipCode.startsWith("1")){
            // Waived so maybe this condition isn't needed
        } else {

            /*
             * TODO: Refactor to not return in an else statement
             *  Maybe set sameDayDelivery to false
             */
            deliveryFee = deliveryFee.add(BigDecimal.valueOf(19.99));
            return deliveryFee;
        }

        /*
         * Factor in the same day delivery
         */
        if(sameDayDelivery){
            deliveryFee = deliveryFee.add(BigDecimal.valueOf(5.99));
        }

        // 1b. Create variable for the return
        return deliveryFee;
    }
}
