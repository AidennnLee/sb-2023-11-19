package com.ll.sb20231119;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    String showMain(){
        return "안녕하세요.";
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout(){
        return "개발자 커뮤니티";
    }

    @GetMapping("/calc")
    @ResponseBody
    String showCalc(int a, int b){
        return "계산 결과 : " + (a + b);
    }

    @GetMapping("/calc2")
    @ResponseBody
    String showCalc2(Integer a, Integer b){
        return "계산 결과 : " + (a + b);
    }

    @GetMapping("/calc3")
    @ResponseBody
    String showCalc3(@RequestParam(defaultValue = "0") int a,
                     @RequestParam(defaultValue = "0") int b)
    {
        return "계산 결과 : " + (a + b);
    }

    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(@RequestParam(defaultValue = "0") double a,
                     @RequestParam(defaultValue = "0") double b)
    {
        return "계산 결과 : " + (a + b);
    }

    @GetMapping("/calc5")
    @ResponseBody
    String showCalc5(@RequestParam(defaultValue = "0") String a,
                     @RequestParam(defaultValue = "0") String b
    ) {
        return "계산 결과 : " + (a + b);
    }

    @GetMapping("/calc6")
    @ResponseBody
    int showCalc6(
            int a, int b
    ) {
        return a + b;
    }

    @GetMapping("/calc7")
    @ResponseBody
    boolean showCalc7(
            int a, int b
    ) {
        return a > b;
    }

    @GetMapping("/calc8")
    @ResponseBody
    Person showCalc8(
            String name, int age
    ) {
        return new Person(name, age);
    }

    @GetMapping("/calc9")
    @ResponseBody
    Person2 showCalc9(
            String name, int age
    ) {
        return new Person2(name, age);
    }

    @GetMapping("/calc10")
    @ResponseBody
    Map<String, Object> showCalc10(
            String name, int age
    ) {
        Map<String, Object> personMap = Map.of(
                "name", name,
                "age", age
        );
        return personMap;
    }

    @GetMapping("/calc11")
    @ResponseBody
    List<Person2> showCalc11(
            String name, int age
    ) {
        List<Person2> person2s = new ArrayList<>(){{
            add(new Person2(name, age));
            add(new Person2(name + "!", age + 1));
            add(new Person2(name + "!!", age + 2));
        }};

        return person2s;
    }

    @GetMapping("/calc12")
    @ResponseBody
    String showCalc12() {
        String html = "";

        html += "<div>";
        html += "<input type=\"text\" placeholder=\"이름을 입력하시오.\">";
        html += "<div>";

        return html;
    }

    @GetMapping("/calc13")
    @ResponseBody
    String showCalc13() {
        StringBuilder sb = new StringBuilder();

        sb.append("<div>");
        sb.append("<input type=\"text\" placeholder=\"이름을 입력하시오.\">");
        sb.append("</div>");

        return sb.toString();
    }

    @GetMapping("/calc14")
    @ResponseBody
    String showCalc14() {
        return """
               <div>
                    <input type="text" placeholder="이름을 입력하시오.">
               </div>  
               """;
        //return "<div><input type="text" placeholder="이름을 입력하시오."></div>";와 동일
    }

    @GetMapping("/calc15")
    @ResponseBody
    String showCalc15() {
        return """
               <div>
                    <input type="text" placeholder="내용" value="반갑습니다.">
               </div>  
               """;
    }

    @GetMapping("/calc16")
    @ResponseBody
    String showCalc16(@RequestParam(defaultValue = "") String content) {
        return """
               <div>
                    <input type="text" placeholder="내용" value="%s">
               </div>  
               """.formatted(content);
    }

    @GetMapping("/calc17")
    String showCalc17(){
        return "calc";
    }

    @GetMapping("/calc18")
    String showCalc18(Model model){
        model.addAttribute("v1", "Hi");
        model.addAttribute("v2", "Hello");
        return "calc";
    }

    @GetMapping("/calc19")
    @ResponseBody
    int showCalc19(){
        int num = 0;
        num++;

        return num;
    }

    int num = 0;
    @GetMapping("/calc20")
    @ResponseBody
    int showCalc20(){
        num++;

        return num;
    }
}

@AllArgsConstructor
class Person{
    public String name;
    public int age;
}

@AllArgsConstructor
@Getter
class Person2{
    private String name;
    private int age;
}