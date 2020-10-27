package com.thoughtworks.capability.gtb.entrancequiz.API;

import com.thoughtworks.capability.gtb.entrancequiz.BO.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ListController {
    private List<Person> List = initial_List();

    private java.util.List<Person> initial_List() {
        List<Person> PersonList = new ArrayList<>();
        PersonList.add(new Person(1,"成吉思汗"));
        PersonList.add(new Person(2,"鲁班七号"));
        PersonList.add(new Person(3,"太乙真人"));
        PersonList.add(new Person(4,"钟无艳"));
        PersonList.add(new Person(5,"花木兰"));
        PersonList.add(new Person(6,"雅典娜"));
        PersonList.add(new Person(7,"芈月"));
        PersonList.add(new Person(8,"白起"));
        PersonList.add(new Person(9,"刘禅"));
        PersonList.add(new Person(10,"庄周"));
        PersonList.add(new Person(11,"马超"));
        PersonList.add(new Person(12,"刘备"));
        PersonList.add(new Person(13,"哪吒"));
        PersonList.add(new Person(14,"大乔"));
        PersonList.add(new Person(15,"蔡文姬"));
        return PersonList;
    }
    @GetMapping("/person/list")
    public ResponseEntity get_person_list(){
        return ResponseEntity.ok(List);
    }
    @PostMapping("/person/list")
    public ResponseEntity add_person_to_list(@RequestBody Person person){
        List.add(person);
        return ResponseEntity.ok(List);
    }
}
