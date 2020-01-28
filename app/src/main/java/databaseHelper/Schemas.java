package databaseHelper;

public final class Schemas {

    private Schemas(){}

    public static class Person{

        public static final String table_name = "person";
        public static final String column_user_ID = "user_ID";
        public static final String column_name = "name";
        public static final String column_family = "family";
        public static final String column_email = "email";
        public static final String column_password = "password";
        public static final String column_phone = "phone";

        private static final String create_table_person = "create table " + table_name +
                "(" + column_user_ID + " integer primary key autoincrement," + column_name +
                " text," + column_family + " text," + column_email + " text," +
                column_password + " text," + column_phone + " integer)";

        private static final String drop_table_person = "drop table if exsits" + table_name;


        public static String getCreate_table_person() {
            return create_table_person;
        }

        public static String getDrop_table_person() {
            return drop_table_person;
        }
    }


}
