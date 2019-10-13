/*dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
}*/

dataSource {
    pooled = true
    dbCreate = "update"
    url = "jdbc:mysql://localhost:3306/place_of_sound?autoReconnect=true&useSSL=false"
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = org.hibernate.dialect.MySQL5InnoDBDialect
    username = "root"
    password = "asd12345"
}
