package choi.java.member;

import java.util.Vector;

//ȸ������ ���� Ŭ����
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
   return String.format("�̸� : %s \n���� : %d \n��ȣ : %s \n�ּ� : %s"
         , name, age, number, addr);
}

}