module com.lcaohoanq.fxsnakegame {
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

    opens com.lcaohoanq.fxsnakegame to javafx.fxml;
    opens com.lcaohoanq.fxsnakegame.views.base to javafx.fxml;
    exports com.lcaohoanq.fxsnakegame;
    exports com.lcaohoanq.fxsnakegame.views;
    opens com.lcaohoanq.fxsnakegame.views to javafx.fxml;
    exports com.lcaohoanq.fxsnakegame.controllers;
    opens com.lcaohoanq.fxsnakegame.controllers to javafx.fxml;
}