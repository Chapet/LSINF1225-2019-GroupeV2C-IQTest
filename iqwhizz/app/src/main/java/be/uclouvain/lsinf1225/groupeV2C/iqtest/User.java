package be.uclouvain.lsinf1225.groupeV2C.iqtest;

public class User {

    public User () {
    }

    public static String AddUser(String login, String password, String name, int age, char gender, String city){
        return "INSERT INTO User (Login, Password, Name, Age, Gender, City)\n" +
                "VALUES ("+login+", "+password+", "+name+", "+age+", "+gender+", "+city+");";
    }

    public static String createTable(){
        return "CREATE TABLE USER (\n" +
                "    Login      CHAR (20) PRIMARY KEY\n" +
                "                         UNIQUE\n" +
                "                         NOT NULL,\n" +
                "    Password   CHAR (20) NOT NULL,\n" +
                "    Name       CHAR (40) NOT NULL,\n" +
                "    Age        INT (1)   NOT NULL,\n" +
                "    Gender     CHAR (1)  CHECK (GENDER == 'M' OR \n" +
                "                                GENDER == 'W'),\n" +
                "    City       CHAR (30),\n" +
                "    ProfilePic BLOB      DEFAULT DefaultProfilePic,\n" +
                "    Langage    CHAR (3)  DEFAULT ENG\n" +
                "                         CHECK (LANGAGE == \"FR\" OR \n" +
                "                                LANGAGE == \"ENG\"),\n" +
                "    Sound      BOOLEAN   DEFAULT (1) \n" +
                ");";
    }

    public static String dropTable() {
        return "DROP TABLE IF EXISTS USER";
    }
}
