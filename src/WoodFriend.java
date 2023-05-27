public class WoodFriend extends Customer {

    private int numMember;

    /**
     * @param ID
     * @param name
     * @param numMember
     */
    public WoodFriend(String ID, String name, int numMember) {
        super(ID, name);
        this.numMember = numMember;
    }

    /**
     * @return the numMember
     */
    public int getNumMember() {
        return numMember;
    }

    /**
     * @param numMember the numMember to set
     */
    public void setNumMember(int numMember) {
        this.numMember = numMember;
    }

    @Override
    public String toString() {
        return "WoodFriend [numMember=" + numMember + ", getNumMember()=" + getNumMember() + ", toString()="
                + super.toString() + "]";
    }






}
