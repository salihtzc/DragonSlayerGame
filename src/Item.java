
public class Item {
    private String iName, iType;
    private  int damage, block;

    public Item(String iName, String iType, int damage, int block) {
        this.iName= iName;
        this.iType = iType;
        this.damage = damage;
        this.block = block;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public String getiType() {
        return iType;
    }

    public void setiType(String iType) {
        this.iType = iType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }
}
