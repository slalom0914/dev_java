package anet.mvc;

public class AddressVO {
    private String name;
    private String address;
    private String telephone;
    private String gender;
    private String relationship;
    private String birthday;
    private String comments;
    private String registedate;
    private String command;
    private int id;

    public AddressVO() {}

    public AddressVO(String name, String address, String telephone,
                     String gender, String relationship, String birthday,
                     String comments, String registedate, int id) {
        this.name         = name;
        this.address      = address;
        this.telephone    = telephone;
        this.gender       = gender;
        this.relationship = relationship;
        this.birthday     = birthday;
        this.comments     = comments;
        this.registedate  = registedate;
        this.id           = id;
    }

    public String getName()         { return this.name; }
    public String getAddress()      { return this.address; }
    public String getTelephone()    { return this.telephone; }
    public String getGender()       { return this.gender; }
    public String getRelationship() { return this.relationship; }
    public String getBirthday()     { return this.birthday; }
    public String getComments()     { return this.comments; }
    public String getRegistedate()  { return this.registedate; }
    public String getCommand()		{ return this.command; }
    public int getId()           { return this.id; }

    public void setName(String name)                { this.name = name;}
    public void setAddress(String address)          { this.address = address;}
    public void setTelephone(String telephone)      { this.telephone = telephone;}
    public void setGender(String gender)            { this.gender = gender;}
    public void setRelationship(String relationship){ this.relationship = relationship;}
    public void setBirthday(String birthday)        { this.birthday = birthday;}
    public void setComments(String comments)        { this.comments = comments;}
    public void setRegistedate(String registedate)  { this.registedate = registedate;}
    public void setCommand(String command)			{ this.command = command; }
    public void setId(int id)                    	{ this.id = id;}

}
