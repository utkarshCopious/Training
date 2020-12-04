//package com.copious.training.RepInterface;
//
//
//import com.copious.training.ProModel.employee;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import jdk.internal.org.objectweb.asm.TypeReference;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Repository;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Utkarsh Awasthi
// **/
//@Repository
//public class impl implements repoInterface {
//
//    @Override
//    public List<employee> getEmployee() throws IOException {
//
//        Path path = Paths.get("employee.json");
//        ObjectMapper mapper = new ObjectMapper();
//        ArrayList employees = mapper.readValue(Files.newBufferedReader(
//                path, StandardCharsets.UTF_8), ArrayList.class);
//
//
//
//        return employees;
//    }
//
//
////    public List<employee> Employee() throws IOException {
////
////        Path path = Paths.get("outputt.json");
////        ObjectMapper mapper = new ObjectMapper();
////        mapper.writeValue(Files.newBufferedWriter(path, StandardCharsets.UTF_8,
////                StandardOpenOption.CREATE, StandardOpenOption.WRITE), );
////
////
////
////        return employees;
////    }
//}