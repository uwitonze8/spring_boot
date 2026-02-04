package day_one.restfullApi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class helloworldController {

    List<String> names =
    Arrays.asList("Eric","Rukundo",
    "Emmanuel","Joy","Munezero");

    //localhost:8080/login/hello
    @GetMapping(value = "/hello")
    public String HelloWorld(){
        return "Hello Web technology class";
    }

    //localhost:8080/login/names
    @GetMapping("/names")
    public List<String> getNames(){
        return names;
    }

    //localhost:8080/login/search?student=eric
    @GetMapping("/search")
    public String fetchStudentByNames(@RequestParam("student") String student){

        String foundName = null;
        for(String oneStudent: names){

           if(student.equalsIgnoreCase(oneStudent)){
                foundName = oneStudent;
            }
          }
         if(foundName != null){
                return "The student with this name " +foundName+" is found";
            }else{
                return "The student with this name "+student + " is not found";
            }
    }

}
