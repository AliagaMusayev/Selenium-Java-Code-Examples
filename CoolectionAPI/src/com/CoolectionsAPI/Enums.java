package com.CoolectionsAPI;

public enum Enums {

    High(10){
        @Override
        public String NormalizeEnum() {
            return High.toString().toUpperCase();
        }
    },
    Medium(20){
        @Override
        public String NormalizeEnum() {
            return Medium.toString().toUpperCase();
        }
    },
    Low(30){
        @Override
        public String NormalizeEnum() {
            return Low.toString().toUpperCase();
        }
    };


    private int enumValue;

    Enums(int value){
        this.enumValue = value;
    }

    public int getEnumValue(){
        return this.enumValue;
    }

    public abstract String NormalizeEnum();
}
