module com.example.visprojekteshop {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires jakarta.persistence;
    requires spring.data.jpa;

    requires lombok;

    requires spring.beans;
    requires spring.web;
    requires jdk.httpserver;
    requires org.slf4j;
    requires org.aspectj.weaver;

    opens com.example.visprojekteshop to spring.core;
    exports com.example.visprojekteshop;
}