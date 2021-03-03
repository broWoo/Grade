package choi.java.member;

import java.util.Vector;

//회원정보 저장 클래스
public class MemberSave extends MemberSystem{

final String name;
int age;
String number;
String addr;
public MemberSave(String name, int age, String numr, String addr) {
   this.name = name;
   this.age = age;
   this.number = number;
   this.addr = addr;
}


public void setAge(int age) {
   this.age = age;
}

public void setNumber(String number) {
   this.number = number;
}

public void setAddr(String addr) {
   this.addr = addr;
}

public String getName() {
   return number;
}

public String toString() {
   return String.format("이름 : %s \n나이 : %d \n번호 : %s \n주소 : %s"
         , name, age, number, addr);
}

}