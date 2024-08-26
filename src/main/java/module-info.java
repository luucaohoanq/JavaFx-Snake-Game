module com.lcaohoanq.formhandling {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.j;
    requires java.desktop;
    requires io.github.cdimascio.dotenv.java;
    requires static lombok;
    requires org.slf4j;
    requires com.fasterxml.jackson.databind;
    requires java.net.http;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires thymeleaf;
    requires javax.mail.api;
    requires swingx;

    opens com.lcaohoanq.formhandling to javafx.fxml;
    opens com.lcaohoanq.formhandling.modules.user to org.hibernate.orm.core;
    exports com.lcaohoanq.formhandling;
}