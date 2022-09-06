package com.app.a3_gamingapi.RecyclerAdapter;

public class dataClass {

    private String imageData;
    private String nameData;
    private String desData;
    private String attackData;
    private String defenseData;

    public dataClass(String imageData, String nameData, String desData, String attackData, String defenseData) {
        this.imageData = imageData;
        this.nameData = nameData;
        this.desData = desData;
        this.attackData = attackData;
        this.defenseData = defenseData;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public String getNameData() {
        return nameData;
    }

    public void setNameData(String nameData) {
        this.nameData = nameData;
    }

    public String getDesData() {
        return desData;
    }

    public void setDesData(String desData) {
        this.desData = desData;
    }

    public String getAttackData() {
        return attackData;
    }

    public void setAttackData(String attackData) {
        this.attackData = attackData;
    }

    public String getDefenseData() {
        return defenseData;
    }

    public void setDefenseData(String defenseData) {
        this.defenseData = defenseData;
    }
}
