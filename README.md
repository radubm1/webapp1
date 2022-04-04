# Aplicatie web de tip REST pentru autentificarea accesului la un server PostgreSQL(9.6)

Cerinte:
1. Este nevoie sa aveti instalat un server Tomcat si sa download-ati jar-ul aferent driverului de PostgreSQL in folderul C:\Program Files\XAMPP\tomcat\lib. De ex: postgresql-9.4.1212.jar sau postgresql-42.3.3.jar
2. Driverul de maven din fis de configurare pom.xml trebuie sa coincida cu versiunea driverului de PostgreSQL din Tomcat, de ex.
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>9.4.1212</version>
        </dependency>
3. Asigurati deployment-ul arhivei de tip .war cu instrumentele specifice, de ex. Manager App

SUCCES!
