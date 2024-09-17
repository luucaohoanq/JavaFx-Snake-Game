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
    exports com.lcaohoanq.fxsnakegame.controllers;
    opens com.lcaohoanq.fxsnakegame.controllers to javafx.fxml;
    exports com.lcaohoanq.fxsnakegame.views.utils;
    opens com.lcaohoanq.fxsnakegame.views.utils to javafx.fxml;
    opens com.lcaohoanq.fxsnakegame.views.game.board to javafx.fxml;
    exports com.lcaohoanq.fxsnakegame.views.changepassword;
    opens com.lcaohoanq.fxsnakegame.views.changepassword to javafx.fxml;
    exports com.lcaohoanq.fxsnakegame.views.menu;
    opens com.lcaohoanq.fxsnakegame.views.menu to javafx.fxml;
    exports com.lcaohoanq.fxsnakegame.views.info;
    opens com.lcaohoanq.fxsnakegame.views.info to javafx.fxml;
    exports com.lcaohoanq.fxsnakegame.views.otpverification;
    opens com.lcaohoanq.fxsnakegame.views.otpverification to javafx.fxml;
    opens com.lcaohoanq.fxsnakegame.views.score to javafx.fxml;
    exports com.lcaohoanq.fxsnakegame.views.score;
//    opens com.lcaohoanq.fxsnakegame to org.testfx;
}