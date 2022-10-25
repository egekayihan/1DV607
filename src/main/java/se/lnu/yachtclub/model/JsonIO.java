package se.lnu.yachtclub.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonIO {

    private final ObjectMapper objectMapper;

    public JsonIO() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public void convertMemberToJSON(List<Member> members, File file) {
        try {
            objectMapper.writeValue(file, members);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Member> convertJSONToMember(File file) {
        List<Member> members = new ArrayList<>();
        try {
            members = objectMapper.readValue(file, new TypeReference<List<Member>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return members;

    }

    public void updateJSON(List<Member> members , File file) {
        convertMemberToJSON(members,file);
    }

}
