package by.bockroir;

/**
 * Created by orobye on 22.06.17.
 */
public enum  Commands {
    SHOW_COLUMNS, SHOW_TABLES;

    @Override
    public String toString(){
        switch (this){
            case SHOW_COLUMNS:

                return "select *\n" +
                        "from INFORMATION_SCHEMA.COLUMNS\n" +
                        "where TABLE_NAME='%s'";
            case SHOW_TABLES:
                return "Select Table_name as \"Table name\"\n" +
                        "From Information_schema.Tables\n" +
                        "Where Table_type = 'BASE TABLE' and Objectproperty \n" +
                        "(Object_id(Table_name), 'IsMsShipped') = 0";
            default:
                return null;
        }
    }
}
